package corpcooga.canvas;

import corpcooga.components.Button;
import corpcooga.pages.Page;
import corpcooga.pages.PageManager;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import processing.core.PApplet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1280, DRAWING_HEIGHT = 800;
	
	private PageManager pageManager;
	private Button goButton, backButton, nextButton;
	private JsonNode textNode, sectionsNode;
	
	private double uMouseX, uMouseY;
	
	
//	Constructors
	
	public DrawingSurface()
	{
//		JSON file text reading system
		ObjectMapper mapper = new ObjectMapper();
		try {
			textNode = mapper.readTree(new File("resources/data/textinfo.json"));
			sectionsNode = mapper.readTree(new File("resources/data/sectioninfo.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int idx;
		
		idx = 0;
		int[] titlePages = new int[sectionsNode.get("Title Pages").size()];
		for (JsonNode titlePage : sectionsNode.get("Title Pages")) {
			titlePages[idx] = titlePage.asInt();
			idx++;
		}
		
		idx = 0;
		String[] sectionNames = new String[sectionsNode.get("Section Names").size()];
		for (JsonNode sectionName : sectionsNode.get("Section Names")) {
			sectionNames[idx] = sectionName.asText();
			idx++;
		}
		
		idx = 0;
		Color[] sectionColors = new Color[sectionsNode.get("Section Colors").size()];
		for (JsonNode sectionColor : sectionsNode.get("Section Colors")) {
			int[] rgb = new int[3];
			int i = 0;
			for (JsonNode x : sectionColor) {
				rgb[i] = x.asInt();
				i++;
			}
			sectionColors[idx] = new Color(rgb[0], rgb[1], rgb[2]);
			idx++;
		}
		
//		TODO change pages length
//		Page[] pages = new Page[10];
//		
//		for (JsonNode sectionName : sectionsNode.get("Section Names")) {
//			idx = 0;
//			String[] add = new String[textNode.get(sectionName).size()];
//			for (JsonNode n : textNode.get(sectionName)) {
//				add[idx] = n.asText();
//				idx++;
//			}
////			displayText.add(add);
//		}
		
//		TODO add pages
//		TODO find a way to make specific adjustments to pages (text size, positioning, etc.)
//		TODO update the section colors while making new sections
		pageManager = new PageManager(null, titlePages, sectionNames, sectionColors);
	}
	
	
//	Methods
	
	public void settings()
	{
		setSize(DRAWING_WIDTH, DRAWING_HEIGHT);
	}
	
	public void setup()
	{
		goButton = new Button("Go!", DRAWING_WIDTH / 2 - 100, 650, 200, 100);
		backButton = new Button("Back", 40, DRAWING_HEIGHT - 80, 100, 50);
		nextButton = new Button("Next", DRAWING_WIDTH - 140, DRAWING_HEIGHT - 80, 100, 50);
		textFont(createFont("resources/fonts/avenir.ttf", 69));
	}
	
	public void draw()
	{
		scale((float)width / DRAWING_WIDTH, (float)height / DRAWING_HEIGHT);
		
//		pageManager.draw(this);
		
//		background(sectionColors[page.getSection()].getRGB());
		
//		if (!page.onTitlePage()) {
//			push();
//			textSize(18);
//			text(""+page.getPage(), 10, 30);
//			pop();
//		}
		
		if (pageManager.onTitlePage())
			goButton.draw(this);
		else {
			if (pageManager.getPage() >= 1)
				nextButton.draw(this);
			if (pageManager.getPage() >= 2)
				backButton.draw(this);
		}
	}
	
	public void mousePressed()
	{
		uMouseX = mouseX * DRAWING_WIDTH / width;
		uMouseY = mouseY * DRAWING_HEIGHT / height;
		
		if (pageManager.onTitlePage()) {
			if (goButton.pointOver(uMouseX, uMouseY))
				pageManager.changePage(1);
		} else {
			if (pageManager.getPage() >= 1 && nextButton.pointOver(uMouseX, uMouseY))
				pageManager.changePage(1);
			if (pageManager.getPage() >= 2 && backButton.pointOver(uMouseX, uMouseY)) {
				for (int x : pageManager.getTitlePages())
					if (pageManager.getPage() == x + 1) {
						pageManager.changePage(-1);
						break;
					}
				pageManager.changePage(-1);
			}
		}
	}

}
