package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;

public class DrawingSurface extends PApplet
{
//	Fields
	
	private Button goButton, backButton, nextButton;
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
		goButton = new Button("Go!", width / 2 - 100, 650, 200, 100);
		backButton = new Button("Back", 40, height - 80, 100, 50);
		nextButton = new Button("Next", width - 140, height - 80, 100, 50);
	}
	
	public void draw()
	{
		background(60, 60, 60);
		
		if (page > 0) {
			push();
			textSize(20);
			text(""+page, 10, 30);
			pop();
		}
		
		displayPage();
		
		if (page == 0)
			goButton.draw(this);
		if (page >= 1)
			nextButton.draw(this);
		if (page >= 2)
			backButton.draw(this);
	}
	
	public void displayPage()
	{
		push();
		switch(page) {
		case 0:
			textAlign(CENTER);
			textSize(100);
			fill(240);
			text("Rubik's Roadmap", width / 2, 130);
			imageMode(CENTER);
			image(loadImage("rubik's_cube.png"), width / 2, 400, 600, 600);
			break;
		case 1:
			textAlign(CENTER);
			textSize(50);
			fill(240);
			text("Introduction", width / 2, 60);
			break;
		case 2:
			textAlign(CENTER);
			textSize(50);
			fill(240);
			text("Step 1: The Cross", width / 2, 60);
			break;
		case 3:
			textAlign(CENTER);
			textSize(50);
			fill(240);
			text("Step 2: First Layer", width / 2, 60);
			break;
		case 4:
			textAlign(CENTER);
			textSize(50);
			fill(240);
			text("Step 3: Second Layer", width / 2, 60);
			break;
		default:
			textAlign(CENTER);
			textSize(50);
			fill(240);
			text("Invalid Page", width / 2, height / 2);
		}
		pop();
	}
	
	public void mousePressed()
	{
		if (page == 0 && goButton.pointOver(mouseX, mouseY))
			page += 1;
		else if (page >= 1 && nextButton.pointOver(mouseX, mouseY))
			page += 1;
		else if (page >= 2 && backButton.pointOver(mouseX, mouseY))
			page -= 1;
	}

}
