package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1000, DRAWING_HEIGHT = 800;
	
	private Button goButton, backButton, nextButton;
	private double uMouseX, uMouseY;
	private int page;
	
	
//	Constructors
	
	public DrawingSurface()
	{
		page = 0;
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
			text("Rubik's Roadmap", DRAWING_WIDTH / 2, 130);
			imageMode(CENTER);
			image(loadImage("rubik's_cube.png"), DRAWING_WIDTH / 2, 400, 600, 600);
			break;
		case 1:
			text("Introduction", DRAWING_WIDTH / 2, 60);
			break;
		case 2:
			text("1 - The Cross", DRAWING_WIDTH / 2, 60);
			break;
		case 3:
			text("2 - The First Layer", DRAWING_WIDTH / 2, 60);
			break;
		case 4:
			text("3 - The Second Layer", DRAWING_WIDTH / 2, 60);
			break;
		case 5:
			text("4 - The Cross 2.0", DRAWING_WIDTH / 2, 60);
			break;
		case 6:
			text("5 - The Corners", DRAWING_WIDTH / 2, 60);
			break;
		case 7:
			text("6 - The Great Rotation", DRAWING_WIDTH / 2, 60);
			break;
		default:
			text("Invalid Page", DRAWING_WIDTH / 2, DRAWING_HEIGHT / 2);
		}
		pop();
	}
	
	public void mousePressed()
	{
		updateUnscaledMouse();
		if (page == 0 && goButton.pointOver(uMouseX, uMouseY))
			page += 1;
		else if (page >= 1 && nextButton.pointOver(uMouseX, uMouseY))
			page += 1;
		else if (page >= 2 && backButton.pointOver(uMouseX, uMouseY))
			page -= 1;
	}
	
	public void updateUnscaledMouse()
	{
		uMouseX = mouseX * DRAWING_WIDTH / width;
		uMouseY = mouseY * DRAWING_HEIGHT / height;
	}

}
