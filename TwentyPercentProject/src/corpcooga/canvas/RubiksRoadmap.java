package corpcooga.canvas;

import processing.core.PApplet;

public class RubiksRoadmap 
{
	public static void main(String args[])
	{
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		drawing.windowResizable(true);
	}

}
