package corpcooga.pages;

import java.awt.Color;

import corpcooga.canvas.DrawingSurface;
import processing.core.PApplet;

public class PageManager 
{
//	Fields
	
	private Page[] pages;
	private String[] sectionNames;
	private Color[] sectionColors;
	private int[] titlePages;
	
	private int pageNum;
	
	
//	Constructors
	
	public PageManager(Page[] pages, int[] titlePages, String[] sectionNames, Color[] sectionColors)
	{
		this.pages = pages;
		this.titlePages = titlePages;
		this.sectionNames = sectionNames;
		this.sectionColors = sectionColors;
		pageNum = 0;
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
		p.push();
		
		p.background(sectionColors[getSection()].getRGB());
		
//		page number display
		if (!onTitlePage()) {
			p.textSize(18);
			p.text(""+pageNum, 10, 30);
		}
		
//		p.imageMode(PApplet.CENTER);
		p.textAlign(PApplet.CENTER);
		p.fill(240);
		
		int y = 75;
		p.textSize(50);
		if (onTitlePage()) {
			p.textSize(100);
			y = 130;
		}
		
		if (pageNum == 0)
			p.text("Rubik's Roadmap", DrawingSurface.DRAWING_WIDTH / 2, y);
		else
			p.text(sectionNames[getSection()], DrawingSurface.DRAWING_WIDTH / 2, y);
		
//		pages[pageNum].draw(p);
		
		p.pop();
	}
	
	public int getPage()
	{
		return pageNum;
	}
	
	public int[] getTitlePages()
	{
		return titlePages;
	}
	
	public String[] getSectionNames()
	{
		return sectionNames;
	}
	
	public Color[] getSectionColors()
	{
		return sectionColors;
	}
	
	public void changePage(int amount)
	{
		pageNum += amount;
	}
	
	public boolean onTitlePage()
	{
		for (int x : titlePages)
			if (pageNum == x)
				return true;
		return false;
	}
	
	public int getSection()
	{
		int section = -1;
		for (int x : titlePages)
			if (x <= pageNum)
				section += 1;
		return section;
	}
	
}
