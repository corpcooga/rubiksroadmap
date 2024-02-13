package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;
import bchew473.components.Page;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1280, DRAWING_HEIGHT = 800;
	
	private Page page;
	private Button goButton, backButton, nextButton;
	private double uMouseX, uMouseY;
	
//	TODO update the section colors while making new sections
	private Color[] sectionColors = {new Color(60, 60, 60), new Color(80, 40, 40),
									new Color(80, 60, 40), new Color(40, 80, 40)};
	
	private JsonNode fileNode;
	private ArrayList<String[]> displayText;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		page = new Page();
		
//		json file text reading system
		ObjectMapper mapper = new ObjectMapper();
		try {
			fileNode = mapper.readTree(new File("resources/data/textinfo.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		displayText = new ArrayList<String[]>();
		String[] add;
		int i;
		
		i = 0;
		add = new String[fileNode.get("Introduction").size()];
		for (JsonNode n : fileNode.get("Introduction")) {
			add[i] = n.asText();
			i++;
		}
		displayText.add(add);
		
		i = 0;
		add = new String[fileNode.get("The Cross").size()];
		for (JsonNode n : fileNode.get("The Cross")) {
			add[i] = n.asText();
			i++;
		}
		displayText.add(add);
		
		i = 0;
		add = new String[fileNode.get("The First Layer").size()];
		for (JsonNode n : fileNode.get("The First Layer")) {
			add[i] = n.asText();
			i++;
		}
		displayText.add(add);
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
		background(sectionColors[page.getSection()].getRGB());
		
		if (!page.onTitlePage()) {
			push();
			textSize(18);
			text(""+page.getPage(), 10, 30);
			pop();
		}
		
//		TODO make this method take in a text object to use to write
		page.displayPage(this, displayText);
		
		if (page.onTitlePage())
			goButton.draw(this);
		else {
			if (page.getPage() >= 1)
				nextButton.draw(this);
			if (page.getPage() >= 2)
				backButton.draw(this);
		}
	}
	
	public void mousePressed()
	{
		uMouseX = mouseX * DRAWING_WIDTH / width;
		uMouseY = mouseY * DRAWING_HEIGHT / height;
		if (page.onTitlePage()) {
			if (goButton.pointOver(uMouseX, uMouseY))
				page.changePage(1);
		} else {
			if (page.getPage() >= 1 && nextButton.pointOver(uMouseX, uMouseY))
				page.changePage(1);
			if (page.getPage() >= 2 && backButton.pointOver(uMouseX, uMouseY)) {
				for (int x : page.getTitlePages())
					if (page.getPage() == x + 1) {
						page.changePage(-1);
						break;
					}
				page.changePage(-1);
			}
		}
	}

}
