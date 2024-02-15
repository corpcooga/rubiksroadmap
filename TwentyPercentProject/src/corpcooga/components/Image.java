package corpcooga.components;

import processing.core.PApplet;
import processing.core.PImage;

public class Image extends GraphicalElement
{
//	Fields
	
	private PImage image;
//	private String imagePath;
	
	
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
//		this.imagePath = imagePath;
//		this.image = null;
	}
	
	public Image(float x, float y, float width, float height)
	{
		super(x, y, width, height);
		this.image = null;
	}
	
	public Image()
	{
		this.image = null;
	}
	
	
//	Methods
	
//	TODO add way to deal with this.image being null
	public void draw(PApplet p)
	{
//		if (image == null)
//			image = p.loadImage(imagePath);
		p.image(image, getX(), getY(), getWidth(), getHeight());
	}
	
}
