package corpcooga.components;

import processing.core.PApplet;

public class Image extends GraphicsElement
{
//	Fields
	
	private String imagePath;
	private int imageMode;
	
	
//	Constructors
	
	public Image(String imagePath, int... settings)
	{
		super(settings[0], settings[1], settings[2], settings[3]);
		try {
			this.imagePath = "resources/img/" + imagePath;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		imageMode = settings[4];
	}
	
	public Image()
	{
		imagePath = "";
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		p.push();
		p.imageMode(imageMode);
		if (imagePath != null)
			p.image(p.loadImage(imagePath), getX(), getY(), getWidth(), getHeight());
		p.pop();
	}
	
}
