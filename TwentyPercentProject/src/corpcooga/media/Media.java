package corpcooga.media;

import processing.core.PApplet;

public abstract class Media 
{
//	Fields
	
	private float x, y, width, height;
	
	
//	Constructors
	
	public Media(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Media()
	{
		this(0, 0, 0, 0);
	}
	
	
//	Methods
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getWidth()
	{
		return width;
	}
	
	public float getHeight()
	{
		return height;
	}
	
	public abstract void display(PApplet p);
	
}
