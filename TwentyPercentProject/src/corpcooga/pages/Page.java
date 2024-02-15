package corpcooga.pages;

import corpcooga.components.Image;
import corpcooga.components.Text;
import processing.core.PApplet;

public class Page
{
//	Fields
	
	private Text[] texts;
	private Image[] images;
	
	
//	Constructors
	
	public Page(Text[] texts, Image[] images)
	{
		this.texts = texts;
		this.images = images;
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		for (Text t : texts)
			if (t != null)
				t.draw(p);
		for (Image i : images)
			if (i != null)
				i.draw(p);
	}
	
}
