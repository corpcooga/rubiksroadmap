package bchew473.components;

import processing.core.PApplet;
import java.awt.Color;

public class Button {
	
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
	
//	TODO: make borderRound and borderWidth scale to button width and height
	public Button(String text, float x, float y, float width, float height)
	{
		this(text, x, y, width, height, 5, 10, (int)(height * 0.5));
	}
	
//	FIXME: find out how to make this work
//	public Button(String text, float x, float y)
//	{
//		this(text, x, y, 0, 0);
//		setWidth(textWidth(text));
//		setHeight(textSize);
//	}
	
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
	
	public void setX(float newX)
	{
		x = newX;
	}
	
	public void setY(float newY)
	{
		y = newY;
	}
	
	public void setHeight(float newHeight)
	{
		height = newHeight;
	}
	
	public void setFillColor(Color c)
	{
		fillColor = c;
	}
	
	public void draw(PApplet drawer)
	{
		drawer.push();
		
//		Button body
		drawer.strokeWeight(borderWidth);
		drawer.fill(fillColor.getRGB());
		if (pointOver(drawer.mouseX, drawer.mouseY)) {
			drawer.fill(fillColor.getRed() * 3/4, fillColor.getGreen() * 3/4,
					fillColor.getBlue() * 3/4);
			if (drawer.mousePressed)
				drawer.fill(fillColor.getRed() / 2, fillColor.getGreen() / 2,
						fillColor.getBlue() / 2);
		}
		drawer.stroke(borderColor.getRGB());
		drawer.rect(x, y, width, height, borderRound);
		
//		Button text
		drawer.textSize(textSize);
		drawer.textAlign(PApplet.CENTER, PApplet.CENTER);
		drawer.fill(textColor.getRGB());
		drawer.text(text, x + width / 2, y + height / 2);
		
		drawer.pop();
	}
	
	public String toString()
	{
		return "text: " + text + "\ncoordinates: ("+x+", "+y+")"
				+ "\ndimensions: " + width + "x" + height + "\nborderWidth: " + borderWidth
				+ "\nborderRound: " + borderRound + "\ntextSize: " + textSize + "\nfillColor: "
				+ fillColor + "\nborderColor: " + borderColor + "\ntextColor: " + textColor;
	}
}
