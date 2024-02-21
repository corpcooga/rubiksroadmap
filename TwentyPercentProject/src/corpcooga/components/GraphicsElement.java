package corpcooga.components;

import processing.core.PApplet;

public abstract class GraphicsElement
{
//	Fields
	
	private int x, y, width, height;
	
	
//	Constructors
	
	public GraphicsElement(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GraphicsElement(int x, int y)
	{
		this(x, y, 0, 0);
	}
	
	public GraphicsElement()
	{
		this(0, 0);
	}
	
	
//	Methods
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public abstract void draw(PApplet p);
	
}
