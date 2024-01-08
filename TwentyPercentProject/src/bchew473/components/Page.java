package bchew473.components;

import processing.core.PApplet;
import bchew473.testers.DrawingSurface;

public class Page
{
//	Fields
	
	private int pageNum;
	private int[] titlePages;
	
	
//	Constructors
	
	public Page()
	{
		pageNum = 0;
//		TODO: incorporate titlePages into displayPage()
		titlePages = new int[] {0, 4};
	}
	
	
//	Methods
	
	public void displayPage(PApplet p)
	{
		p.push();
		p.textAlign(PApplet.CENTER);
		if (onTitlePage())
			p.textSize(100);
		else
			p.textSize(50);
		p.fill(240);
		switch(pageNum) {
		case 0:
			p.text("Rubik's Roadmap", DrawingSurface.DRAWING_WIDTH / 2, 130);
			p.imageMode(PApplet.CENTER);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2, 400, 600, 600);
			break;
		case 1:
			p.text("Introduction", DrawingSurface.DRAWING_WIDTH / 2, 75);
			p.textSize(24);
			p.textAlign(PApplet.LEFT);
			p.text("The Rubik's Cube is very misunderstood. Most people say things like, \"I just peel the stickers off,\" "
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
					+ "If you're excited to solve your first Rubik's Cube, that's great! But before we get into how to solve it,"
					+ "you'll have to know a few important things.",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			p.textSize(16);
			p.text("*I don't have a dog, nor did I teach him how to solve the Rubik's Cube", 100, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
		case 2:
			p.text("Introduction", DrawingSurface.DRAWING_WIDTH / 2, 75);
			p.textSize(24);
			p.textAlign(PApplet.LEFT);
			p.text("First, the Rubik's Cube is solved in layers, not sides. Surprisingly, trying to solve the cube by getting one side "
					+ "at a time makes it much more difficult. This is what a solved side versus a solved layer looks like:",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
//			TODO: change images
			p.push();
			p.textAlign(PApplet.CENTER);
			p.imageMode(PApplet.CENTER);
			p.textSize(36);
			p.text("Side", DrawingSurface.DRAWING_WIDTH / 2 - 200, 220);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2 - 200, 320, 200, 200);
			p.text("Layer", DrawingSurface.DRAWING_WIDTH / 2 + 200, 220);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2 + 200, 320, 200, 200);
			p.pop();
			p.text("In the solved side, the entire face is white, but the parts along its edge don't match up. In the solved layer, "
					+ "the difference is that the colors along the edge do line up.\n\n"
					+ "That may have been a bit confusing, but don't worry! This idea of solving in layers is built into this "
					+ "tutorial, so it will happen naturally. Also, here's some quick nomenclature that I'll be using to identify "
					+ "certain pieces:",
					100, 430, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			p.push();
			p.textAlign(PApplet.CENTER);
			p.imageMode(PApplet.CENTER);
			p.textSize(30);
			p.text("Center piece", DrawingSurface.DRAWING_WIDTH / 2 - 300, 620);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2 - 300, 680, 120, 120);
			p.text("Edge piece", DrawingSurface.DRAWING_WIDTH / 2, 620);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2, 680, 120, 120);
			p.text("Corner piece", DrawingSurface.DRAWING_WIDTH / 2 + 300, 620);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2 + 300, 680, 120, 120);
			p.pop();
//			+ "So buckle up and get your cube out, because this will be a fun, easy, and relaxing experience. "
//			+ "Also, did I forget to mention that there are more than 43 quintillion possible configurations of the"
//			+ "Rubik's Cube? OOPS...", 
			break;
		case 3:
			p.text("The Cross", DrawingSurface.DRAWING_WIDTH / 2, 130);
			p.imageMode(PApplet.CENTER);
//			TODO Find better photo
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2, 400, 600, 600);
			break;
		case 4:
			p.text("1 - The Cross", DrawingSurface.DRAWING_WIDTH / 2, 75);
			p.textSize(24);
			p.textAlign(PApplet.LEFT);
			p.text("The first step to solving the Rubik's Cube is by making a white cross-shaped pattern ", 
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
//		case 3:
//			p.text("2 - The First Layer", DrawingSurface.DRAWING_WIDTH / 2, 75);
//			break;
//		case 4:
//			p.text("3 - The Second Layer", DrawingSurface.DRAWING_WIDTH / 2, 75);
//			break;
//		case 5:
//			p.text("4 - The Cross 2.0", DrawingSurface.DRAWING_WIDTH / 2, 75);
//			break;
//		case 6:
//			p.text("5 - The Corners", DrawingSurface.DRAWING_WIDTH / 2, 75);
//			break;
//		case 7:
//			p.text("6 - The Great Rotation", DrawingSurface.DRAWING_WIDTH / 2, 75);
//			break;
		default:
			p.text("Invalid Page", DrawingSurface.DRAWING_WIDTH / 2, DrawingSurface.DRAWING_HEIGHT / 2);
		}
		p.pop();
	}
	
	public int getPage()
	{
		return pageNum;
	}
	
	public void changePage(int amount)
	{
		pageNum += amount;
	}
	
	public boolean onTitlePage()
	{
		for (int x : titlePages)
			if (pageNum == x)
				return true;
		return false;
	}
	
}
