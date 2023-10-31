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
		textAlign(CENTER);
		textSize(50);
		fill(240);
		switch(page) {
		case 0:
			textSize(100);
			text("Rubik's Roadmap", width / 2, 130);
			imageMode(CENTER);
			image(loadImage("rubik's_cube.png"), width / 2, 400, 600, 600);
			break;
		case 1:
			text("Introduction", width / 2, 60);
			break;
		case 2:
			text("1 - The Cross", width / 2, 60);
			break;
		case 3:
			text("2 - The First Layer", width / 2, 60);
			break;
		case 4:
			text("3 - The Second Layer", width / 2, 60);
			break;
		case 5:
			text("4 - The Cross 2.0", width / 2, 60);
			break;
		case 6:
			text("5 - The Corners", width / 2, 60);
			break;
		case 7:
			text("6 - The Great Rotation", width / 2, 60);
			break;
		default:
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
