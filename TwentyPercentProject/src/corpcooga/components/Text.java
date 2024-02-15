package corpcooga.components;

import processing.core.PApplet;

public class Text extends GraphicalElement
{
//	Fields
	
	private String text;
	
	
//	Constructors
	
	public Text(float x, float y, float width, float height, String text)
	{
		super(x, y, width, height);
		this.text = text;
	}
	
	public Text()
	{
		super();
		this.text = "";
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		p.text(text, getX(), getY(), getWidth(), getHeight());
	}
	
}
