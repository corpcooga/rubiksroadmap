package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;

public class DrawingSurface extends PApplet
{
//	Fields
	
	private Button backButton, nextButton;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		
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
		
//		Title
		push();
		textAlign(CENTER);
		textSize(50);
		fill(220);
		text("Rubik's Roadmap", width / 2, 60);
		pop();
		
		backButton.draw(this);
		nextButton.draw(this);
	}

}
