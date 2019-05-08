//Jonathon Lefler
//Dictates what the controls will do, depending on which engine is active at the time of input.
//Initializes each map that are declared in Overworld class.
//This class will be the "Switch". Everything pipes through switch, and depending on which mode is active, Switch will send it to the correct class.

import java.awt.*;
import java.io.File;

public class ControlSwitch {
	private boolean mode;
	private static OverworldEngine OE;
	
	public ControlSwitch(){
		mode = true;
		OE = new OverworldEngine();

		int[][] _map;
		_map = MapReader.readFromCSV(new  File("map.csv"));
		System.out.println("" + _map.length + _map[0].length);
		OverworldEngine.map = new Map("Test Map", _map.length, _map[0].length );
		for(int x = 0; x < _map.length; x++)
			for(int y = 0; y < _map[x].length; y++)
				OverworldEngine.map.setTerrain(x, y, _map[x][y]);
		int[][] _map2;
		_map2 = MapReader.readFromCSV(new File("map2.csv"));
		System.out.println("" + _map2.length + _map2[0].length);
		OverworldEngine.map2 = new Map("map2", _map2.length, _map2[0].length );
		for(int x = 0; x < _map2.length; x++)
			for(int y = 0; y < _map2[x].length; y++)
				OverworldEngine.map2.setTerrain(x, y, _map2[x][y]);
		OE.changeMap();
	}
	
	public boolean checkPassable(String direction){
		if(direction.equalsIgnoreCase("W"))
			return OverworldEngine.currentMap.passageCheck("w");
		else if(direction.equalsIgnoreCase("S"))
			return OverworldEngine.currentMap.passageCheck("s");
		else if(direction.equalsIgnoreCase("A"))
			return OverworldEngine.currentMap.passageCheck("a");
		else // D
			return OverworldEngine.currentMap.passageCheck("d");
	}
	
	public boolean getMode(){
		return mode; 
	}
	
	public void SwitchMode(){
		if(mode)
			mode = false;
		else
			mode = true;
	}
	
	public void paint(Graphics g){
		if(mode)
			OverworldEngine.paint(g);
		else
			CombatEngine.paint(g);
	}
}
