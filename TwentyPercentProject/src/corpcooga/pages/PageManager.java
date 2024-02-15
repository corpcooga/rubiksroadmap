package corpcooga.pages;

import java.awt.Color;
import processing.core.PApplet;

public class PageManager 
{
//	Fields
	
	private Color[] sectionColors;
	private Page[] pages;
	private String[] sectionNames;
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
		p.background(sectionColors[getSection()].getRGB());
		
		if (!onTitlePage()) {
			p.push();
			p.textSize(18);
			p.text(""+pageNum, 10, 30);
			p.pop();
		}
		pages[pageNum].draw(p);
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
