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
		titlePages = new int[] {0, 4, 6};
	}
	
	
//	Methods
	
	public void displayPage(PApplet p)
	{
		p.push();
		p.textAlign(PApplet.CENTER);
		p.imageMode(PApplet.CENTER);
		p.fill(240);
		if (onTitlePage())
			p.textSize(100);
		else
			p.textSize(50);
		
		switch(pageNum)
		{
		case 0:
			p.text("Rubik's Roadmap", DrawingSurface.DRAWING_WIDTH / 2, 130);
			p.image(p.loadImage("roadmap_logo.png"), DrawingSurface.DRAWING_WIDTH / 2, 400, 550, 550);
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
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(36);
			p.text("Side", DrawingSurface.DRAWING_WIDTH / 2 - 200, 220);
			p.image(p.loadImage("solved_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 200, 320, 180, 180);
			p.text("Layer", DrawingSurface.DRAWING_WIDTH / 2 + 200, 220);
			p.image(p.loadImage("solved_layer.png"), DrawingSurface.DRAWING_WIDTH / 2 + 200, 320, 180, 180);
			p.pop();
			p.text("In the solved side, the entire face is white, but the parts along its edge don't match up. In the solved layer, "
					+ "the difference is that the colors along the edge do line up.\n\n"
					+ "That may have been a bit confusing, but don't worry! This idea of solving in layers is built into this "
					+ "tutorial, so it will happen naturally. Also, here's some quick nomenclature that I'll be using to identify "
					+ "certain pieces:",
					100, 430, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(30);
			p.text("Center pieces", DrawingSurface.DRAWING_WIDTH / 2 - 300, 620);
			p.image(p.loadImage("center_pieces.png"), DrawingSurface.DRAWING_WIDTH / 2 - 300, 680, 100, 100);
			p.text("Edge pieces", DrawingSurface.DRAWING_WIDTH / 2, 620);
			p.image(p.loadImage("edge_pieces.png"), DrawingSurface.DRAWING_WIDTH / 2, 680, 100, 100);
			p.text("Corner pieces", DrawingSurface.DRAWING_WIDTH / 2 + 300, 620);
			p.image(p.loadImage("corner_pieces.png"), DrawingSurface.DRAWING_WIDTH / 2 + 300, 680, 100, 100);
			p.pop();
			break;
		case 3:
			p.text("Introduction", DrawingSurface.DRAWING_WIDTH / 2, 75);
			p.textSize(24);
			p.textAlign(PApplet.LEFT);
			p.text("Lastly, you need to learn about turning notation. Each of the six sides has a letter representing it, and "
					+ "indicates a turn to that side. It should be turned clockwise from the perspective of that side. "
					+ "Note that while doing the following turns, the leftmost of the three sides shown should point towards you.",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(40);
			p.image(p.loadImage("front_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 500, 270, 100, 100);
			p.text("F", DrawingSurface.DRAWING_WIDTH / 2 - 500, 355);
			p.image(p.loadImage("back_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 300, 270, 100, 100);
			p.text("B", DrawingSurface.DRAWING_WIDTH / 2 - 300, 355);
			p.image(p.loadImage("up_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 100, 270, 100, 100);
			p.text("U", DrawingSurface.DRAWING_WIDTH / 2 - 100, 355);
			p.image(p.loadImage("down_side.png"), DrawingSurface.DRAWING_WIDTH / 2 + 100, 270, 100, 100);
			p.text("D", DrawingSurface.DRAWING_WIDTH / 2 + 100, 355);
			p.image(p.loadImage("left_side.png"), DrawingSurface.DRAWING_WIDTH / 2 + 300, 270, 100, 100);
			p.text("L", DrawingSurface.DRAWING_WIDTH / 2 + 300, 355);
			p.image(p.loadImage("right_side.png"), DrawingSurface.DRAWING_WIDTH / 2 + 500, 270, 100, 100);
			p.text("R", DrawingSurface.DRAWING_WIDTH / 2 + 500, 355);
			p.pop();
			
			p.text("These letters represent the sides: Front, Back, Up, Down, Left, Right. These can be reversed "
					+ "by an apostrophe (known as a \"prime\" symbol) following it, which makes it turn counter-clockwise. "
					+ "The number 2 following it means to turn the side twice.\n\n"
					+ "For example, B' means to turn the back side (second image) counter-clockwise. 2R means to turn the "
					+ "right side (last image) twice.\n\n"
					+ "And that's all you really need to know about for now. So buckle up and get your cube out, because this "
					+ "is going to be a fun, easy, and relaxing experience. Also, did I forget to mention that there are more "
					+ "than 43 quintillion possible configurations of the Rubik's Cube? OOPS...",
					100, 400, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
		case 4:
			p.text("The Cross", DrawingSurface.DRAWING_WIDTH / 2, 130);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2, 400, 600, 600);
			break;
		case 5:
			p.text("The Cross", DrawingSurface.DRAWING_WIDTH / 2, 75);
			p.textSize(24);
			p.textAlign(PApplet.LEFT);
			p.text("The first step to solving the Rubik's Cube is by making a white cross-shaped pattern.\n\n"
					+ "The pattern, as shown in the photo, is made up of a white center piece, and four white edge "
					+ "pieces (edge pieces with the white and another color). But one very important thing to notice "
					+ "is that the other color on the white edge pieces line up with the center pieces on the other sides. ",
					100, 120, DrawingSurface.DRAWING_WIDTH - 400, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH - 200, 200, 200, 200);
			p.text("To accomplish this, you will mostly have to use your intuition. Luckily, I can give you a bit of help "
					+ "to make this easier. Instead of putting the white edge pieces directly into position, you can line "
					+ "them up around the yellow center piece, opposite of the white one. This pattern is known as the \"daisy\", "
					+ "shown on the left.\n\n"
					+ "As you can see, the white edge pieces don't have to be lined up with the adjacent center pieces. "
					+ "This pattern is a bit easier to make without that restriction.",
					300, 316, DrawingSurface.DRAWING_WIDTH - 400, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("rubik's_cube.png"), 180, 410, 200, 200);
			p.text("Once you get the white edge pieces lined up, all you have to do is rotate them into place. To do this, "
					+ "turn the yellow side around until one of the white edge pieces lines up with the adjacent center piece. "
					+ "Then, turn that side twice! Repeat this for all other three edge pieces.\n\n"
					+ "If you've done everything right, you should have completed The Cross!",
					100, 540, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
		case 6:
			p.text("The First Layer", DrawingSurface.DRAWING_WIDTH / 2, 130);
//			TODO Change image
			p.image(p.loadImage("rubik's_cube.png"), DrawingSurface.DRAWING_WIDTH / 2, 400, 600, 600);
			break;
		case 7:
//			TODO Make this text write automatically based on title page
			p.text("The First Layer", DrawingSurface.DRAWING_WIDTH / 2, 75);
			p.textSize(24);
			p.textAlign(PApplet.LEFT);
			p.text("",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
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
	
	public int[] getTitlePages()
	{
		return titlePages;
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
