package corpcooga.pages;

import corpcooga.canvas.DrawingSurface;
import corpcooga.components.Text;

import java.awt.Color;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import processing.core.PApplet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TextInfoManager 
{
//	Fields
	
	public static final Map<String, Integer> infoMap = new HashMap<String, Integer>() 
	{{
		put("drawingWidth", DrawingSurface.DRAWING_WIDTH);
		put("drawingHeight", DrawingSurface.DRAWING_HEIGHT);
		put("leftAlign", PApplet.LEFT);
		put("centerAlign", PApplet.CENTER);
	}};
	
	private JsonNode textNode, sectionsNode;
	
	
//	Constructors
	
	public TextInfoManager()
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			textNode = mapper.readTree(new File("resources/data/textinfo.json"));
			sectionsNode = mapper.readTree(new File("resources/data/sectioninfo.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	Methods
	
	public int[] readTitlePages()
	{
		JsonNode file = sectionsNode.get("Title Pages");
		int[] titlePages = new int[file.size()];
		int idx = 0;
		
		for (JsonNode titlePage : file) {
			titlePages[idx] = titlePage.asInt();
			idx++;
		}
		
		return titlePages;
	}
	
	public String[] readSectionNames()
	{
		JsonNode file = sectionsNode.get("Section Names");
		String[] sectionNames = new String[file.size()];
		int idx = 0;
		
		for (JsonNode sectionName : file) {
			sectionNames[idx] = sectionName.asText();
			idx++;
		}
		
		return sectionNames;
	}
	
	public Color[] readSectionColors()
	{
		JsonNode file = sectionsNode.get("Section Colors");
		Color[] sectionColors = new Color[file.size()];
		int idx = 0;
		
		for (JsonNode sectionColor : file) {
			int[] rgb = new int[3];
			int i = 0;
			for (JsonNode color : sectionColor) {
				rgb[i] = color.asInt();
				i++;
			}
			sectionColors[idx] = new Color(rgb[0], rgb[1], rgb[2]);
			idx++;
		}
		
		return sectionColors;
	}
	
//	TODO use a helper method when reading the text coordinates, dimensions, size, and alignment
	public Page[] readPages()
	{
//		TODO change pages length or use ArrayList
		Page[] pages = new Page[20];
		for (int x = 0; x < pages.length; x++)
			pages[x] = new Page();
		int idx = 0;
		
//		TODO add coordinates, dimensions, size, and alignment in textinfo.json
		
//		loop through each section
		for (String sectionName : readSectionNames())
			for (JsonNode sectionTextNode: textNode.get(sectionName))
				
//				loop through pages in each section
				for (JsonNode pageTextNode : sectionTextNode) {
					Text[] text = new Text[pageTextNode.size()];
					int i = 0;
					
//					loop through text in each page
					for (JsonNode textNode : pageTextNode) {
						text[i] = new Text(textNode.asText());
						i++;
					}
					
					pages[idx].setTexts(text);
					idx++;
				}
		
		return pages;
	}
	
}
