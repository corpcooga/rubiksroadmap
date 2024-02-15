package corpcooga.pages;

import corpcooga.canvas.DrawingSurface;
import java.awt.Color;
import processing.core.PApplet;

public class Button
{
//	Fields
	
	private String text;
	private float x, y, width, height;
	private int borderWidth, borderRound, textSize;
	private Color fillColor, borderColor, textColor;
	
	
//	Constructors
	
	public Button(String text, float x, float y, float width, float height,
			int bWidth, int bRound, int tSize, Color fCol, Color bCol, Color tCol)
	{
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		borderWidth = bWidth;
		borderRound = bRound;
		textSize = tSize;
		textColor = tCol;
		fillColor = fCol;
		borderColor = bCol;
	}
	
	public Button(String text, float x, float y, float width, float height, int bWidth, int bRound, int tSize)
	{
		this(text, x, y, width, height, bWidth, bRound, tSize, Color.white, Color.black, Color.black);
	}
	
	public Button(String text, float x, float y, float width, float height)
	{
		this(text, x, y, width, height, (int)(width / 20), (int)(height / 3), (int)(height * 0.5));
	}
	
	public Button()
	{
		this("", 0, 0, 0, 0);
	}
	
	
//	Methods
	
	public boolean pointOver(double x, double y)
	{
		if (x >= this.x && x <= this.x + width &&
				y >= this.y && y <= this.y + this.height)
			return true;
		return false;
	}
	
	public void draw(PApplet p)
	{
		p.push();
		
//		Button body
		p.strokeWeight(borderWidth);
		p.fill(fillColor.getRGB());
		if (pointOver(p.mouseX * DrawingSurface.DRAWING_WIDTH / p.width, 
				p.mouseY * DrawingSurface.DRAWING_HEIGHT / p.height)) {
			p.fill(fillColor.getRed() * 3/4, fillColor.getGreen() * 3/4, fillColor.getBlue() * 3/4);
			if (p.mousePressed)
				p.fill(fillColor.getRed() / 2, fillColor.getGreen() / 2, fillColor.getBlue() / 2);
		}
		p.stroke(borderColor.getRGB());
		p.rect(x, y, width, height, borderRound);
		
//		Button text
		p.textSize(textSize);
		p.textAlign(PApplet.CENTER, PApplet.CENTER);
		p.fill(textColor.getRGB());
		p.text(text, x + width / 2, y + height / 2);
		
		p.pop();
	}
	
	public String toString()
	{
		return "text: " + text + "\ncoordinates: ("+x+", "+y+")"
				+ "\ndimensions: " + width + "x" + height + "\nborderWidth: " + borderWidth
				+ "\nborderRound: " + borderRound + "\ntextSize: " + textSize + "\nfillColor: "
				+ fillColor + "\nborderColor: " + borderColor + "\ntextColor: " + textColor;
	}
	
}
