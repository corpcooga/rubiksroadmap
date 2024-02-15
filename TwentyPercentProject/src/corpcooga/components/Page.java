package corpcooga.components;

import corpcooga.canvas.DrawingSurface;

import processing.core.PApplet;
import java.util.ArrayList;

public class Page
{
//	Fields

	private String[] sectionNames = {"Introduction", "The Cross", "The First Layer", 
									"The Second Layer", "The Cross 2.0", 
									"The Corner Fix", "The Solve", "Conclusion"};
	private int[] titlePages = {0, 4, 6};
			
	private int pageNum;
	
	
//	Constructors
	
	public Page()
	{
		pageNum = 0;
	}
	
	
//	Methods
	
//	TODO add buttons that interact with certain elements
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
			p.text(text.get(0)[2], 100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
			p.push();
			p.textAlign(PApplet.CENTER);
			p.textSize(36);
			p.text("Side", DrawingSurface.DRAWING_WIDTH / 2 - 200, 220);
			p.image(p.loadImage("resources/img/solved_side.png"), DrawingSurface.DRAWING_WIDTH / 2 - 200, 320, 180, 180);
			p.text("Layer", DrawingSurface.DRAWING_WIDTH / 2 + 200, 220);
			p.image(p.loadImage("resources/img/solved_layer.png"), DrawingSurface.DRAWING_WIDTH / 2 + 200, 320, 180, 180);
			p.pop();
			
			p.text(text.get(0)[3], 100, 430, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
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
			p.text(text.get(0)[4], 100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			
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
			
			p.text(text.get(0)[5], 100, 390, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
			
		case 4:
			p.image(p.loadImage("resources/img/the_cross.png"), DrawingSurface.DRAWING_WIDTH / 2, 390, 500, 500);
			break;
			
		case 5:
			p.text(text.get(1)[0], 100, 120, DrawingSurface.DRAWING_WIDTH - 400, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/the_cross.png"), DrawingSurface.DRAWING_WIDTH - 200, 200, 200, 200);
			
			p.text(text.get(1)[1], 300, 316, DrawingSurface.DRAWING_WIDTH - 400, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/the_daisy.png"), 180, 410, 200, 200);
			
			p.text(text.get(1)[2], 100, 540, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			break;
			
		case 6:
			p.image(p.loadImage("resources/img/first_layer.png"), DrawingSurface.DRAWING_WIDTH / 2, 390, 500, 500);
			break;
			
		case 7:
			p.text(text.get(2)[0], 100, 120, DrawingSurface.DRAWING_WIDTH - 200, DrawingSurface.DRAWING_HEIGHT - 100);
			p.text(text.get(2)[1], 100, 230, DrawingSurface.DRAWING_WIDTH - 350, DrawingSurface.DRAWING_HEIGHT - 100);
			p.image(p.loadImage("resources/img/example_corner_piece.png"), DrawingSurface.DRAWING_WIDTH - 160, 290, 140, 140);
			p.image(p.loadImage("resources/img/first_layer_corner_up.png"), 160, 450, 140, 140);
			p.text(text.get(2)[2], 250, 380, DrawingSurface.DRAWING_WIDTH - 500, DrawingSurface.DRAWING_HEIGHT - 100);
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
