package bchew473.components;

import processing.core.PApplet;
import java.awt.Color;

public class Button {
	
//	Fields
	
	String text;
	double x, y, width, height;
	int borderWidth, borderRound, textSize;
	Color fillColor, borderColor, textColor;
	
	
//	Constructors
	
	public Button(String text, double x, double y, double width, double height, int bWidth, int bRound, Color fCol, Color bCol)
	{
//		TODO: set textSize and textColor
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		borderWidth = bWidth;
		borderRound = bRound;
		fillColor = fCol;
		borderColor = bCol;
	}
	
	public Button(String text, double x, double y, double width, double height, int bWidth, int bRound)
	{
		this(text, x, y, width, height, bWidth, bRound, Color.white, Color.black);
	}
	
	public Button(String text, double x, double y, double width, double height)
	{
		this(text, x, y, width, height, 1, 10);
	}
	
	public Button()
	{
		this("", 0, 0, 0, 0);
	}
	
	
//	Methods
	
	public void draw(PApplet drawer)
	{
		drawer.push();
		drawer.rect((float)x, (float)y, (float)width, (float)height, 20);
		drawer.textAlign(PApplet.CENTER, PApplet.CENTER);
		drawer.text(text, (float)x, (float)y);
		drawer.pop();
	}
	
	public String toString()
	{
		return "text: " + text + "\ncoordinates: ("+x+", "+y+")"
				+ "\ndimensions: " + width + "x" + height + "\nborderWidth: " + borderWidth
				+ "\nfillColor: " + fillColor + "\nborderColor: " + borderColor
				+ "\nborderRound: " + borderRound;
	}
}
