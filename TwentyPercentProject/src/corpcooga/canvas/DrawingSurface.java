package corpcooga.canvas;

import corpcooga.components.*;
import corpcooga.pages.*;

import processing.core.PApplet;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1280, 
							DRAWING_HEIGHT = 800;
	
	private PageManager pageManager;
	private ButtonManager buttonManager;
	
	private double uMouseX, uMouseY;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		GraphicsInfoReader infoManager = new GraphicsInfoReader();
		
		pageManager = new PageManager(infoManager.readPages(), infoManager.readTitlePages());
		
		buttonManager = new ButtonManager(new Button[] {
				new Button("Go!", DRAWING_WIDTH / 2 - 100, 650, 200, 100),
				new Button("Next", DRAWING_WIDTH - 135, DRAWING_HEIGHT - 80, 100, 50),
				new Button("Back", 35, DRAWING_HEIGHT - 80, 100, 50)},
				pageManager);
	}
	
	
//	Methods
	
	public void settings()
	{
		size(DRAWING_WIDTH, DRAWING_HEIGHT);
	}
	
	public void setup()
	{
		textFont(createFont("resources/fonts/avenir.ttf", 69));
	}
	
	public void draw()
	{
		scale((float)width / DRAWING_WIDTH, (float)height / DRAWING_HEIGHT);
		
		pageManager.draw(this);
		buttonManager.draw(this);
	}
	
	public void mousePressed()
	{
		uMouseX = mouseX * DRAWING_WIDTH / width;
		uMouseY = mouseY * DRAWING_HEIGHT / height;
		buttonManager.clickAt(uMouseX, uMouseY);
	}

}
