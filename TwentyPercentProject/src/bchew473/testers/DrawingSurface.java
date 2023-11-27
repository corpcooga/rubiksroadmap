package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;
import bchew473.components.Page;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1280, DRAWING_HEIGHT = 800;
	
	private Page page;
	private Button goButton, backButton, nextButton;
	private double uMouseX, uMouseY;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		page = new Page();
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
	}
	
	public void draw()
	{
		scale((float)width / DRAWING_WIDTH, (float)height / DRAWING_HEIGHT);
		background(60, 60, 60);
		
		if (page.getPage() > 0) {
			push();
			textSize(20);
			text(""+page.getPage(), 10, 30);
			pop();
		}
		
		page.displayPage(this);
		
		if (page.getPage() == 0)
			goButton.draw(this);
		if (page.getPage() >= 1)
			nextButton.draw(this);
		if (page.getPage() >= 2)
			backButton.draw(this);
	}
	
	public void mousePressed()
	{
		uMouseX = mouseX * DRAWING_WIDTH / width;
		uMouseY = mouseY * DRAWING_HEIGHT / height;
		if (page.getPage() == 0 && goButton.pointOver(uMouseX, uMouseY))
			page.changePage(1);
		else if (page.getPage() >= 1 && nextButton.pointOver(uMouseX, uMouseY))
			page.changePage(1);
		else if (page.getPage() >= 2 && backButton.pointOver(uMouseX, uMouseY))
			page.changePage(-1);
	}

}
