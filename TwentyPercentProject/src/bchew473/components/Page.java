package bchew473.components;

import processing.core.PApplet;
import bchew473.testers.DrawingSurface;
import java.util.ArrayList;

public class Page
{
//	Fields
	
	private int pageNum;
	private final int[] titlePages = {0, 4, 6};
	private final String[] sectionNames = {"Introduction", "The Cross", "The First Layer", 
											"The Second Layer", "The Cross 2.0", "The Corner Fix", 
											"The Solve", "Conclusion"};
	
	
//	Constructors
	
	public Page()
	{
		pageNum = 0;
	}
	
	
//	Methods
	
	public void displayPage(PApplet p, ArrayList<String[]> text)
	{
		p.push();
		
		p.textAlign(PApplet.CENTER);
		p.imageMode(PApplet.CENTER);
		p.fill(240);
		
		int y = 75;
		p.textSize(50);
		if (onTitlePage()) {
			p.textSize(100);
			y = 130;
		}
		
		if (pageNum > 0) {
			p.text(sectionNames[getSection()], DrawingSurface.DRAWING_WIDTH / 2, y);
			p.textAlign(PApplet.LEFT);
			p.textSize(22);
		}
		
		switch(pageNum)
		{
		case 0:
			p.text("Rubik's Roadmap", DrawingSurface.DRAWING_WIDTH / 2, y);
			p.image(p.loadImage("resources/img/roadmap_logo.png"), DrawingSurface.DRAWING_WIDTH / 2, 390, 500, 500);
			break;
			
		case 1:
			p.text(text.get(0)[0], 100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			p.textSize(15);
			p.text(text.get(0)[1], 100, 670);
			break;
			
		case 2:
			p.text("First, the Rubik's Cube is solved in layers, not sides. Surprisingly, trying "
					+ "to solve the cube by getting one side at a time makes it much more "
					+ "difficult. This is what a solved side versus a solved layer looks like:",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(36);
			p.text("Side", DrawingSurface.DRAWING_WIDTH / 2 - 200, 220);
			p.image(p.loadImage("resources/img/solved_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 200, 320, 180, 180);
			p.text("Layer", DrawingSurface.DRAWING_WIDTH / 2 + 200, 220);
			p.image(p.loadImage("resources/img/solved_layer.png"), DrawingSurface.DRAWING_WIDTH / 2 + 200, 320, 180, 180);
			p.pop();
			
			p.text("In the solved side, the entire face is yellow, but the parts along its edge "
					+ "don't match up. In the solved layer, the difference is that the colors "
					+ "along the edge do line up.\n\n"
					+ "That may have been a bit confusing, but don't worry! This idea of solving "
					+ "in layers is built into this tutorial, so it will happen naturally. Also, "
					+ "here's some quick nomenclature that I'll be using to identify certain "
					+ "pieces:",
					100, 430, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(30);
			p.text("Center pieces", DrawingSurface.DRAWING_WIDTH / 2 - 300, 620);
			p.image(p.loadImage("resources/img/center_pieces.png"), DrawingSurface.DRAWING_WIDTH / 2 - 300, 680, 100, 100);
			p.text("Edge pieces", DrawingSurface.DRAWING_WIDTH / 2, 620);
			p.image(p.loadImage("resources/img/edge_pieces.png"), DrawingSurface.DRAWING_WIDTH / 2, 680, 100, 100);
			p.text("Corner pieces", DrawingSurface.DRAWING_WIDTH / 2 + 300, 620);
			p.image(p.loadImage("resources/img/corner_pieces.png"), DrawingSurface.DRAWING_WIDTH / 2 + 300, 680, 100, 100);
			p.pop();
			
			break;
			
		case 3:
			p.text("Lastly, you need to learn about turning notation. Each of the six sides has a "
					+ "letter representing it, and indicates a turn to that side. It should be "
					+ "turned clockwise from the perspective of that side. Note that while doing "
					+ "the following turns, the leftmost of the three sides shown should point "
					+ "towards you.",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(36);
			p.image(p.loadImage("resources/img/front_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 500, 270, 100, 100);
			p.text("F", DrawingSurface.DRAWING_WIDTH / 2 - 500, 355);
			p.image(p.loadImage("resources/img/back_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 300, 270, 100, 100);
			p.text("B", DrawingSurface.DRAWING_WIDTH / 2 - 300, 355);
			p.image(p.loadImage("resources/img/up_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 100, 270, 100, 100);
			p.text("U", DrawingSurface.DRAWING_WIDTH / 2 - 100, 355);
			p.image(p.loadImage("resources/img/down_side.png"), DrawingSurface.DRAWING_WIDTH / 2 + 100, 270, 100, 100);
			p.text("D", DrawingSurface.DRAWING_WIDTH / 2 + 100, 355);
			p.image(p.loadImage("resources/img/left_side.png"), DrawingSurface.DRAWING_WIDTH / 2 + 300, 270, 100, 100);
			p.text("L", DrawingSurface.DRAWING_WIDTH / 2 + 300, 355);
			p.image(p.loadImage("resources/img/right_side.png"), DrawingSurface.DRAWING_WIDTH / 2 + 500, 270, 100, 100);
			p.text("R", DrawingSurface.DRAWING_WIDTH / 2 + 500, 355);
			p.pop();
			
			p.text("These letters represent the sides: Front, Back, Up, Down, Left, Right. These "
					+ "can be reversed by an apostrophe (known as a \"prime\" symbol) following "
					+ "it, which makes it turn counter-clockwise. The number 2 following it means "
					+ "to turn the side twice.\n\n"
					+ "For example, B' means to turn the back side (second image) "
					+ "counter-clockwise. 2R means to turn the right side (last image) twice.\n\n"
					+ "And that's all you really need to know about for now. So buckle up and get "
					+ "your cube out, because this is going to be a fun, easy, and relaxing "
					+ "experience. Also, did I forget to mention that there are more than 43 "
					+ "quintillion possible configurations of the Rubik's Cube? OOPS...",
					100, 390, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
			
		case 4:
			p.image(p.loadImage("resources/img/the_cross.png"), DrawingSurface.DRAWING_WIDTH / 2, 390, 500, 500);
			break;
			
		case 5:
			p.text("The first step to solving the Rubik's Cube is by making a white cross-shaped "
					+ "pattern.\n\n"
					+ "The pattern, as shown in the photo, is made up of a white center piece, and "
					+ "four white edge pieces (edge pieces with the white and another color). But "
					+ "one very important thing to notice is that the other color on the white "
					+ "edge pieces line up with the center pieces on the other sides. ",
					100, 120, DrawingSurface.DRAWING_WIDTH - 400, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/the_cross.png"), DrawingSurface.DRAWING_WIDTH - 200, 200, 200, 200);
			
			p.text("To accomplish this, you will mostly have to use your intuition. Luckily, I can "
					+ "give you a bit of help to make this easier. Instead of putting the white "
					+ "edge pieces directly into position, you can line them up around the yellow "
					+ "center piece, opposite of the white one. This pattern is known as the "
					+ "\"daisy\", shown on the left.\n\n"
					+ "As you can see, the white edge pieces don't have to be lined up with the "
					+ "adjacent center pieces. This pattern is a bit easier to make without that "
					+ "restriction.",
					300, 316, DrawingSurface.DRAWING_WIDTH - 400, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/the_daisy.png"), 180, 410, 200, 200);
			
			p.text("Once you get the white edge pieces lined up, all you have to do is rotate "
					+ "them into place. To do this, turn the daisy around until one of its white "
					+ "edge pieces' colored part lines up with the color of the adjacent center "
					+ "piece. Then, turn that side twice! Repeat this for all other three edge "
					+ "pieces.\n\n"
					+ "If you've done everything right, you should have completed The Cross!",
					100, 540, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
			
		case 6:
			p.image(p.loadImage("resources/img/first_layer.png"), DrawingSurface.DRAWING_WIDTH / 2, 390, 500, 500);
			break;
			
		case 7:
			p.text("The next step is filling out a layer. To do this, we just need to insert white "
					+ "corner pieces between parts of The Cross. First, make sure you're holding "
					+ "the cube so that The Cross is pointing down. This might be a bit confusing "
					+ "at first, but it will make things easier.",
					100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			p.text("Then, find a white corner piece. It should have white and two other colors "
					+ "on it, like the one shown in the photo (it doesn't have to be blue and "
					+ "orange). If the piece you found is already lined up next to the yellow "
					+ "center piece, you don't need to worry about this next part. Otherwise, "
					+ "make sure to follow along.",
					100, 230, DrawingSurface.DRAWING_WIDTH - 350, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/example_corner_piece.png"), DrawingSurface.DRAWING_WIDTH - 160, 290, 140, 140);
			p.image(p.loadImage("resources/img/first_layer_corner_up.png"), 160, 450, 140, 140);
			p.text("The corner piece should be in in the position as shown on the left. Make sure "
					+ "you hold your cube as shown on the right, so that the corner piece is on "
					+ "the bottom right, and execute the following algorigthm: [R U R' U']. This "
					+ "algorithm orients the corner piece next to the yellow center piece. Get "
					+ "used to doing this algorithm, as it comes up a lot.", 
					250, 380, DrawingSurface.DRAWING_WIDTH - 500, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/first_layer_corner_down.png"), DrawingSurface.DRAWING_WIDTH - 160, 450, 140, 140);

			break;
			
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
	
	public int getSection()
	{
		int section = -1;
		for (int x : titlePages)
			if (x <= pageNum)
				section += 1;
		return section;
	}
	
}
