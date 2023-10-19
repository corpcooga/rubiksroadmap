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
	
	public Button(String text, float x, float y, float width, float height)
	{
		this(text, x, y, width, height, 5, 10, (int)(height * 0.5));
	}
	
//	TODO: maybe add constructor that calculates width and height based on text
	
	public Button()
	{
		this("", 0, 0, 0, 0);
	}
	
	
//	Methods
	
	public void draw(PApplet drawer)
	{
		drawer.push();
		
//		Button body
		drawer.strokeWeight(borderWidth);
		drawer.fill(fillColor.getRGB());
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
//		TODO: add new fields and fix color print
		return "text: " + text + "\ncoordinates: ("+x+", "+y+")"
				+ "\ndimensions: " + width + "x" + height + "\nborderWidth: " + borderWidth
				+ "\nfillColor: " + fillColor + "\nborderColor: " + borderColor
				+ "\nborderRound: " + borderRound;
	}
}
