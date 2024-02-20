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
	
	public static final Map<String, Integer> settingsMap = new HashMap<String, Integer>() 
	{{
		put("width", DrawingSurface.DRAWING_WIDTH);
		put("height", DrawingSurface.DRAWING_HEIGHT);
		put("halfWidth", DrawingSurface.DRAWING_WIDTH / 2);
		put("halfHeight", DrawingSurface.DRAWING_HEIGHT / 2);
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
			sectionColors[idx] = new Color(sectionColor.get(0).asInt(), 
											sectionColor.get(1).asInt(), 
											sectionColor.get(2).asInt());
			idx++;
		}
		
		return sectionColors;
	}
	
	public Page[] readPages()
	{
//		TODO change pages length or use ArrayList
		Page[] pages = new Page[20];
		for (int x = 0; x < pages.length; x++)
			pages[x] = new Page();
		int idx = 0;
		
//		loop through each section
		for (String sectionName : readSectionNames())
//			loop through pages in each section
			for (JsonNode pageTextNode : textNode.get(sectionName)) {
				Text[] text = new Text[pageTextNode.size()];
				int i = 0;
				
//				loop through text in each page
				for (JsonNode textNode : pageTextNode) {
					int[] settings;
//					text in the text object
					String textText;
//					check if text has default or specific settings
					if (textNode.isTextual()) {
//						default settings
						textText = textNode.asText();
						settings = readSettings(this.textNode.get("defaultSettings"));
					} else {
//						specific settings
						textText = textNode.get(0).asText();
						settings = readSettings(textNode.get(1));
					}
					
					text[i] = new Text(textText, settings);
					i++;
				}
//				skip through title pages
				for (int x : readTitlePages())
					if (idx == x)
						idx++;
				
//				set all text on page at idx
				pages[idx].setTexts(text);
				idx++;
			}
		
		return pages;
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
//					6 settings are specified
					settings[idx] = parseSettingVal(
							textNode.get("defaultSettings")
							.get(idx).asText());
				} else {
//					4 settings are specified
					int offset = idx == 2 || idx == 3 ? 2 : 0;
					settings[idx] = parseSettingVal(
							textNode.get("defaultSettings")
							.get(idx + offset).asText());
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
