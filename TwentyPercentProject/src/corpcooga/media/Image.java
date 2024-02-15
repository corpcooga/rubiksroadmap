package corpcooga.media;

import processing.core.PApplet;
import processing.core.PImage;

public class Image extends Media
{
//	Fields
	
	private PImage image;
	
	
//	Constructors
	
	public Image(float x, float y, float width, float height, PImage image)
	{
		super(x, y, width, height);
		this.image = image;
	}
	
	public Image()
	{
		super();
		this.image = null;
	}
	
	
//	Methods
	
	public void display(PApplet p)
	{
		p.image(image, getX(), getY(), getWidth(), getHeight());
	}
	
}
