package corpcooga.pages;

import corpcooga.components.Button;
import processing.core.PApplet;

public class ButtonManager 
{
//	Fields
	
	private PageManager pages;
	private Button[] buttons;
	
	
//	Constructors
	
	public ButtonManager(Button[] buttons, PageManager p)
	{
		this.buttons = buttons;
		pages = p;
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		if (pages.onTitlePage())
//			go button
			buttons[0].draw(p);
		else {
			if (pages.getPage() < pages.getNumPages() - 1)
//				next button
				buttons[1].draw(p);
			if (pages.getPage() >= 2)
//				back button
				buttons[2].draw(p);
		}
	}
	
	public void clickAt(double x, double y)
	{
		if (pages.onTitlePage()) {
			if (buttons[0].pointOver(x, y))
				pages.changePage(1);
		} else {
			if (pages.getPage() < pages.getNumPages() - 1 && buttons[1].pointOver(x, y))
				pages.changePage(1);
			if (pages.getPage() >= 2 && buttons[2].pointOver(x, y)) {
				for (int titlePage : pages.getTitlePages())
					if (pages.getPage() == titlePage + 1) {
						pages.changePage(-1);
						break;
					}
				pages.changePage(-1);
			}
		}
	}
	
}
