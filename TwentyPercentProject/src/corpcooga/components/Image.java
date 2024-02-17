package corpcooga.components;

import processing.core.PApplet;
import processing.core.PImage;

public class Image extends GraphicalElement
{
//	Fields
	
	private PImage image;
	
	
//	Constructors
	
	public Image(float x, float y, float width, float height, PImage image)
	{
		super(x, y, width, height);
		this.image = image;
	}
	
	public Image(float x, float y, float width, float height, String imagePath)
	{
		super(x, y, width, height);
		image = loadImage(imagePath);
	}
	
	public Image(float x, float y, float width, float height)
	{
		super(x, y, width, height);
		image = null;
	}
	
	public Image()
	{
		image = null;
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		if (image != null)
			p.image(image, getX(), getY(), getWidth(), getHeight());
	}
	
}
