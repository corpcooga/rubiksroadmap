package corpcooga.canvas;

import corpcooga.components.Button;
import corpcooga.pages.PageManager;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import processing.core.PApplet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1280, DRAWING_HEIGHT = 800;
	
	private PageManager page;
	private Button goButton, backButton, nextButton;
	private ArrayList<String[]> displayText;
//	private String[] displayText;
	private JsonNode fileNode;
	
	private double uMouseX, uMouseY;
	
	
//	Constructors
	
	public DrawingSurface()
	{
//		json file text reading system
		ObjectMapper mapper = new ObjectMapper();
		try {
			fileNode = mapper.readTree(new File("resources/data/textinfo.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		TODO Use a 2D array instead of arraylist of arrays 
		displayText = new ArrayList<String[]>();
//		displayText = new String[1];
		
		for (String sectionName : page.getSectionNames()) {
			int i = 0;
			String[] add = new String[fileNode.get(sectionName).size()];
			for (JsonNode n : fileNode.get(sectionName)) {
				add[i] = n.asText();
				i++;
			}
			displayText.add(add);
		}
		
//		TODO add pages
//		TODO find a way to make specific adjustments to pages (text size, positioning, etc.)
//		TODO update the section colors while making new sections
		page = new PageManager(null, new int[]{0, 4, 6}, 
				new String[]{"Introduction", "The Cross", "The First Layer", 
							"The Second Layer", "The Cross 2.0", 
							"The Corner Fix", "The Solve", "Conclusion"}, 
				new Color[] {new Color(60, 60, 60), new Color(80, 40, 40), 
							new Color(80, 60, 40), new Color(40, 80, 40)});
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
//		background(sectionColors[page.getSection()].getRGB());
		
//		page.displayPage(this, displayText);
		
//		if (!page.onTitlePage()) {
//			push();
//			textSize(18);
//			text(""+page.getPage(), 10, 30);
//			pop();
//		}
		
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
