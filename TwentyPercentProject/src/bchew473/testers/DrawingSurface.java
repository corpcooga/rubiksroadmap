package bchew473.testers;

import processing.core.PApplet;
import bchew473.components.Button;

public class DrawingSurface extends PApplet
{
//	Fields
	
	public static final int DRAWING_WIDTH = 1280, DRAWING_HEIGHT = 800;
	
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
			textSize(24);
			textAlign(LEFT);
			text("The Rubik's Cube is very misunderstood. Most people say things like, \"I just peel the stickers off,\" "
					+ "\"I can solve 5 sides,\" and \"Wow, you must be really smart if you can solve the Rubix (incorrect spelling) Cube!\" "
					+ "These things make cubers (people who solve the Rubik's Cube) cringe because they are common "
					+ "misconceptions that non-cubers (people who don't solve the Rubik's Cube) say to sound smart.\n\n"
					+ "You're probably wondering why this matters. It doesn't. Just don't go around doing these things if "
					+ "you don't know what you're talking about.\n\n"
					+ "Anyway, what is the Rubik's Cube? It's a simple puzzle that can be turned and configured in many "
					+ "different ways. When it is put into a \"scrambled\" state, it can be extremely difficult, nearly "
					+ "impossible, to solve without any guidance. Luckily, many methods have been created to make this process "
					+ "easier, and now pretty much anyone can solve it, including you!\n\n"
					+ "I'll be going over a method for beginners that is easy to understand, so if you're scared or think "
					+ "you're not capable or \"not smart enough\", don't worry! I even taught my dog how to do it*!\n\n"
					+ "So buckle up and get your cube out, because this will be a fun, easy, and relaxing experience. "
					+ "Also, did I forget to mention that there are more than 43 quintillion possible configurations of the "
					+ "Rubik's Cube? OOPS...", 
					100, 120, DRAWING_WIDTH - 200, DRAWING_HEIGHT - 100);
			textSize(16);
			text("*I don't have a dog, nor did I teach him how to solve the Rubik's Cube", 100, DRAWING_HEIGHT - 100);
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
