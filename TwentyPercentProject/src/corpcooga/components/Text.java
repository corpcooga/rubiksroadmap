package corpcooga.components;

import processing.core.PApplet;

public class Text extends GraphicalElement
{
//	Fields
	
	private String text;
	private int textSize, textAlign;
	
	
//	Constructors
	
	public Text(String text, int[] settings)
	{
		super(settings[0], settings[1], settings[2], settings[3]);
		
		this.text = text;
		
		if (settings.length == 6) {
//			6 specified settings
			textSize = settings[4];
			textAlign = (int)settings[5];
		} else {
//			4 specified settings
			setWidth(0);
			setHeight(0);
			textSize = settings[2];
			textAlign = (int)settings[3];
		}
	}
	
	public Text()
	{
		text = "";
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		p.push();
		p.textSize(textSize);
		p.textAlign(textAlign);
		
		if (getWidth() == 0 && getHeight() == 0)
//			unbounded text
			p.text(text, getX(), getY());
		else
//			bounded text
			p.text(text, getX(), getY(), getWidth(), getHeight());
		
		p.pop();
	}
	
}
