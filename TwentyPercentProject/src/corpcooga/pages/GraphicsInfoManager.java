package corpcooga.pages;

import corpcooga.canvas.DrawingSurface;
import corpcooga.components.Text;
import corpcooga.components.Image;

import java.awt.Color;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import processing.core.PApplet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GraphicsInfoManager 
{
//	Fields
	
	public static final Map<String, Integer> settingsMap = new HashMap<String, Integer>() 
	{{
		put("width", DrawingSurface.DRAWING_WIDTH);
		put("height", DrawingSurface.DRAWING_HEIGHT);
		put("halfWidth", DrawingSurface.DRAWING_WIDTH / 2);
		put("halfHeight", DrawingSurface.DRAWING_HEIGHT / 2);
		put("leftAlign", PApplet.LEFT);
		put("centerAlign", PApplet.CENTER);
	}};
	
	private JsonNode graphicsInfo, sectionsInfo;
	
	
//	Constructors
	
	public GraphicsInfoManager()
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			graphicsInfo = mapper.readTree(new File("resources/data/graphicsinfo.json"));
			sectionsInfo = mapper.readTree(new File("resources/data/sectioninfo.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	Methods
	
	public int[] readTitlePages()
	{
		JsonNode file = sectionsInfo.get("Title Pages");
		int[] titlePages = new int[file.size()];
		int idx = 0;
		
		for (JsonNode titlePage : file) {
			titlePages[idx] = titlePage.asInt();
			idx++;
		}
		
		return titlePages;
	}
	
	private String[] readSectionNames()
	{
		JsonNode file = sectionsInfo.get("Section Names");
		String[] sectionNames = new String[file.size()];
		int idx = 0;
		
		for (JsonNode sectionName : file) {
			sectionNames[idx] = sectionName.asText();
			idx++;
		}
		
		return sectionNames;
	}
	
	private Color[] readSectionColors()
	{
		JsonNode file = sectionsInfo.get("Section Colors");
		Color[] sectionColors = new Color[file.size()];
		int idx = 0;
		
		for (JsonNode sectionColor : file) {
			sectionColors[idx] = new Color(sectionColor.get(0).asInt(), 
											sectionColor.get(1).asInt(), 
											sectionColor.get(2).asInt());
			idx++;
		}
		
		return sectionColors;
	}
	
	private Image[] readTitlePageImages()
	{
		JsonNode file = sectionsInfo.get("Title Page Images");
		Image[] titlePageImages = new Image[file.size()];
		int idx = 0;
		
		for (JsonNode titlePageImage : file) {
			titlePageImages[idx] = new Image(titlePageImage.asText(), 
					DrawingSurface.DRAWING_WIDTH / 2, 390, 500, 500, PApplet.CENTER);
			idx++;
		}
		
		return titlePageImages;
	}
	
//	TODO clean up code
	public Page[] readPages()
	{
		Page[] pages = new Page[getNumPages()];
		int idx = 0;
		
//		read non-title pages
		
//		loop through each section
		for (String sectionName : readSectionNames())
//			loop through pages in each section
			for (JsonNode pageNode : graphicsInfo.get(sectionName)) {
				Text[] texts = new Text[pageNode.size() + 2];
				Image[] images = new Image[pageNode.size()];
				int i = 0;
				
//				page header
				texts[texts.length - 1] = new Text(sectionName, 
						DrawingSurface.DRAWING_WIDTH / 2, 75, 50, PApplet.CENTER);
				
//				loop through graphic elements in each page
				for (JsonNode graphicsNode : pageNode) {
					int[] settings;
//					text in the graphics element
					String graphicsText;
//					check if graphics element has default or specific settings
					if (graphicsNode.isTextual()) {
//						default text settings
						graphicsText = graphicsNode.asText();
						settings = readSettings(graphicsInfo.get("defaultSettings").get("textDefault"));
					} else {
//						specific settings--text or image
						graphicsText = graphicsNode.get(0).asText();
						settings = readSettings(graphicsNode.get(1));
					}
					
//					get last 4 characters of graphicsText
					String lastChars;
					if (graphicsText.length() > 4)
						lastChars = graphicsText.substring(graphicsText.length() - 4);
					else
						lastChars = graphicsText;
						
					if (lastChars.equals(".png"))
//						graphicsText is an image file
						images[i] = new Image(graphicsText, settings);
					else
//						graphicsText is a string of text
						texts[i] = new Text(graphicsText, settings);
					
					i++;
				}
//				skip through title pages
				for (int x : readTitlePages())
					if (idx == x)
						idx++;
				
//				page number
				texts[texts.length - 2] = new Text(""+idx, 10, 27, 18, PApplet.LEFT);
				
//				instantiate page at idx
				int section = -1;
				for (int x : readTitlePages())
					if (x <= idx)
						section += 1;
				pages[idx] = new Page(texts, images, readSectionColors()[section]);
				
				idx++;
			}
		
//		read title pages
		
		idx = 0;
		for (int titlePageIdx : readTitlePages()) {
			Text[] texts = {new Text(titlePageIdx == 0 ? 
					"Rubik's Roadmap" : readSectionNames()[idx], 
					DrawingSurface.DRAWING_WIDTH / 2, 130, 100, PApplet.CENTER)};
			Image[] images = {readTitlePageImages()[idx]};
			pages[titlePageIdx] = new Page(texts, images, readSectionColors()[idx]);
			idx++;
		}
		
		return pages;
	}
	
	private int getNumPages()
	{
		int numPages = 0;
		for (String sectionName : readSectionNames()) {
			numPages += graphicsInfo.get(sectionName).size() + 1;
		}
		return numPages;
	}
	
	private int[] readSettings(JsonNode settingsNode)
	{
		if (settingsNode == null)
			throw new IllegalArgumentException("JsonNode cannot be null");
		
		int[] settings = new int[settingsNode.size()];
		int idx = 0;
		
//		loop through each setting
		for (JsonNode setting : settingsNode)
		{
//			if setting is listed as null, use the default setting
			if (setting.isNull()) {
				if (settings.length == 6) {
//					6 settings are specified, text
					settings[idx] = parseSettingVal(
							graphicsInfo.get("defaultSettings").get("textDefault")
							.get(idx).asText());
				} else if (settings.length == 4) {
//					4 settings are specified, text
					int offset = idx == 2 || idx == 3 ? 2 : 0;
					settings[idx] = parseSettingVal(
							graphicsInfo.get("defaultSettings").get("textDefault")
							.get(idx + offset).asText());
				} else {
//					5 settings are specified, image
					settings[idx] = parseSettingVal(
							graphicsInfo.get("defaultSettings").get("imageDefault")
							.get(idx).asText());
				}
				idx++;
				continue;
			}
			settings[idx] = parseSettingVal(setting.asText());
			idx++;
		}
		
		return settings;	
	}
	
	private int parseSettingVal(String mapVal)
	{
//		get the setting as a split up string
		String[] strSplit = mapVal.split(" ");
//		either int value or variable value
		Integer var = settingsMap.get(strSplit[0]);
//		coordinate shift of var
		int val = strSplit.length > 1 ? Integer.parseInt(strSplit[1]) : 0;
		
		if (var != null)
//			value retrieved is a variable
			return var + val;
		else
//			value retrieved is an int
			return Integer.parseInt(mapVal);
	}
	
}
