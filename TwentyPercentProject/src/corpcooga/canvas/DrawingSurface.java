package corpcooga.canvas;

import corpcooga.components.*;
import corpcooga.pages.*;

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
		
//		title pages
		idx = 0;
		int[] titlePages = new int[sectionsNode.get("Title Pages").size()];
		for (JsonNode titlePage : sectionsNode.get("Title Pages")) {
			titlePages[idx] = titlePage.asInt();
			idx++;
		}
		
//		section names
		idx = 0;
		String[] sectionNames = new String[sectionsNode.get("Section Names").size()];
		for (JsonNode sectionName : sectionsNode.get("Section Names")) {
			sectionNames[idx] = sectionName.asText();
			idx++;
		}
		
//		section colors
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
		
//		pages
//		TODO change pages length or use ArrayList
		Page[] pages = new Page[20];
		for (int x = 0; x < pages.length; x++)
			pages[x] = new Page();
		
//		TODO find out if dimensions that refer to DRAWING_WIDTH and DRAWING_HEIGHT work in json
//		TODO make each piece of text in textinfo.json have coordinates, dimensions, size, and alignment
		idx = 0;
//		loop through each section
		for (String sectionName : sectionNames)
			for (JsonNode sectionTextNode: textNode.get(sectionName))
				
//				loop through pages in each section
				for (JsonNode pageTextNode : sectionTextNode) {
					Text[] text = new Text[pageTextNode.size()];
					int i = 0;
					
//					loop through text in each page
					for (JsonNode textNode : pageTextNode) {
						text[i] = new Text(textNode.asText());
						i++;
					}
					
					pages[idx].setTexts(text);
					idx++;
				}
		
		pageManager = new PageManager(pages, titlePages, sectionNames, sectionColors);
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
		
		pageManager.draw(this);
		
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
