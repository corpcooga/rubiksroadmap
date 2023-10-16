package bchew473.components;

import processing.core.PApplet;
import java.awt.Color;

public class Button {
	
//	Fields
	
	String text;
	double x, y, width, height;
	int borderWidth;
	Color fillColor, borderColor;
	
	
//	Constructors
	
	public Button(String text, double x, double y, double width, double height, int bWidth, Color fCol, Color bCol)
	{
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		borderWidth = bWidth;
		fillColor = fCol;
		borderColor = bCol;
	}
	
	public Button(String text, double x, double y, double width, double height, int bWidth)
	{
		this(text, x, y, width, height, bWidth, Color.white, Color.black);
	}
	
	public Button(String text, double x, double y, double width, double height)
	{
		this(text, x, y, width, height, 1);
	}
	
	public Button()
	{
		this("", 0, 0, 0, 0);
	}
	
	
//	Methods
	
	
	
}
