package corpcooga.pages;

import corpcooga.components.Image;
import corpcooga.components.Text;

import java.awt.Color;
import processing.core.PApplet;

public class Page
{
//	Fields
	
	private Text[] texts;
	private Image[] images;
	
	private Color backgroundColor;
	
	
//	Constructors
	
	public Page(Text[] texts, Image[] images, Color backgroundColor)
	{
		this.texts = texts;
		this.images = images;
		this.backgroundColor = backgroundColor;
	}
	
	public Page(Text[] texts, Image[] images)
	{
		this(texts, images, null);
	}
	
	public Page()
	{
		this(null, null);
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		p.background(backgroundColor != null ? backgroundColor.getRGB() : 60);
		if (texts != null)
			for (Text t : texts)
				if (t != null)
					t.draw(p);
		if (images != null)
			for (Image i : images)
				if (i != null)
					i.draw(p);
	}
	
	public void setTexts(Text[] newText)
	{
		texts = newText;
	}
	
	public void setImages(Image[] newImages)
	{
		images = newImages;
	}
	
	public void setBackgroundColor(Color newColor)
	{
		backgroundColor = newColor;
	}
	
}
