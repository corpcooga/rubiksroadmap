package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;

public class DrawingSurface extends PApplet
{
//	Fields
	
	private Button backButton, nextButton;
	private int page;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		page = 0;
	}
	
	
//	Methods
	
	public void settings()
	{
		setSize(1000, 800);
	}
	
	public void setup()
	{
		backButton = new Button("Back", 40, height - 80, 100, 50);
		nextButton = new Button("Next", width - 140, height - 80, 100, 50);
	}
	
	public void draw()
	{
		background(60, 60, 60);
		
		push();
		textSize(20);
		text(""+page, 10, 30);
		pop();
		
		switch(page) {
			case 0:
				push();
				textAlign(CENTER);
				textSize(50);
				fill(240);
				text("Rubik's Roadmap", width / 2, 60);
				pop();
				break;
			case 1:
				push();
				textAlign(CENTER);
				textSize(50);
				fill(240);
				text("Introduction", width / 2, 60);
				pop();
				break;
			default:
				text("Invalid page", width / 2, height / 2);
		}
		
		if (page > 0)
			backButton.draw(this);
		nextButton.draw(this);
	}
	
	public void mousePressed()
	{
		if (nextButton.pointOver(mouseX, mouseY))
			page += 1;
		else if (backButton.pointOver(mouseX, mouseY))
			if (page > 0)
				page -= 1;
	}

}
