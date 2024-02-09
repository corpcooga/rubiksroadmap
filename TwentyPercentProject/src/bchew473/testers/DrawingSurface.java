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
	private ArrayList<String> displayText;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		page = new Page();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
//			TODO make a text file to read from
			fileNode = mapper.readTree(new File("data/textinfo.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		displayText = new ArrayList<String>();
//		TODO make this properly add string text to the ArrayList
//		displayText.add(new String(100,50,600,75,fileNode.get("intro").asText()));
//		displayText.add(new Textbox(100,150,600,75,fileNode.get("instruction1").asText()));
		
//		for(JsonNode n : fileNode.get("jsonexplain")) {
//			displayText.add(new Textbox(x,y,250,100,n.asText()));
//		}
		
//		textboxes.add(new Textbox(725,50,375,400,"The text file we're using looks like this:\n" + fileNode.toPrettyString(),Color.WHITE));
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
		textFont(createFont("Avenir Regular.ttf", 69));
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
		page.displayPage(this);
		
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
