package corpcooga.pages;

import processing.core.PApplet;

public class PageManager 
{
//	Fields
	
	private Page[] pages;
	private int[] titlePages;
	
	private int pageNum;
	
	
//	Constructors
	
	public PageManager(Page[] pages, int[] titlePages)
	{
		this.pages = pages;
		this.titlePages = titlePages;
		pageNum = 0;
	}
	
	
//	Methods
	
	public void draw(PApplet p)
	{
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
