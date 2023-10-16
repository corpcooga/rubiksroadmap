package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;

public class DrawingSurface extends PApplet
{
	public DrawingSurface()
	{
		
	}
	
	public void settings()
	{
		setSize(1000, 800);
	}
	
	public void setup()
	{
		background(60, 60, 60);
		push();
		textAlign(CENTER);
		textSize(50);
		fill(220);
		text("Rubik's Roadmap", width / 2, 60);
		pop();
		
		Button testButton = new Button("test", width / 2, height / 2, 100, 50);
		testButton.draw(this);
		System.out.println(testButton);
	}
	
	public void draw()
	{
		
	}

}
