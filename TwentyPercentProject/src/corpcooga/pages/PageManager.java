package corpcooga.pages;

import java.awt.Color;
import processing.core.PApplet;

public class PageManager 
{
//	Fields
	
//	TODO update the section colors while making new sections
	private Color[] sectionColors;
//		{new Color(60, 60, 60), new Color(80, 40, 40), new Color(80, 60, 40), new Color(40, 80, 40)}
	private Page[] pages;
	private String[] sectionNames;
	private int[] titlePages;
	
	private int pageNum;
	
	
//	Constructors
	
	public PageManager(Page[] pages, int[] titlePages, String[] sectionNames)
	{
		this.pages = pages;
		this.titlePages = titlePages;
		this.sectionNames = sectionNames;
		pageNum = 0;
	}
	
	public PageManager(Page[] pages)
	{
		this(pages, null, null);
	}
	
	
//	Methods
	
	public void drawPage(PApplet p)
	{
		pages[pageNum].draw(p);
	}
	
	public int getPage()
	{
		return pageNum;
	}
	
	public void changePage(int amount)
	{
		pageNum += amount;
	}
	
	public Color[] getSectionColors()
	{
		return sectionColors;
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
