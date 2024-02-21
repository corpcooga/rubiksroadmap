package corpcooga.pages;

import java.awt.Color;
import processing.core.PApplet;

public class PageManager 
{
//	Fields
	
//	TODO see if sectionNames is necessary
	private Page[] pages;
	private int[] titlePages;
	private String[] sectionNames;
	private Color[] sectionColors;
	
	
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
		pages[pageNum].draw(p);
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
