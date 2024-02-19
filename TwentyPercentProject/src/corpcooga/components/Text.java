package corpcooga.components;

import processing.core.PApplet;

public class Text extends GraphicalElement
{
//	Fields
	
	private String text;
	private int textSize;
	private int textAlign;
	
	
//	Constructors
	
	public Text(String text, float x, float y, float width, float height, int textSize, int textAlign)
	{
		super(x, y, width, height);
		this.text = text;
		this.textSize = textSize;
		this.textAlign = textAlign;
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
		p.text(text, getX(), getY(), getWidth(), getHeight());
		p.pop();
	}
	
}
