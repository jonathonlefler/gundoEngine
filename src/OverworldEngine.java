//Jonathon Lefler
//This is the engine for the overworld
//Knows what terrain the player is on - will need to talk to the terrain class.

import java.awt.*;

public class OverworldEngine {
	public static Map map;
	public static Map map2;
	public static Map currentMap;
	
	public OverworldEngine(){
	}
	
	public void changeMap(){
		currentMap = map2;
	}
	
	public static void paint(Graphics g){
		g.setColor(Color.black); //g.fillRect(0, 0, 1920, 1080);
		for(int transferIndex = 0; transferIndex < currentMap.NumofTranPoints; transferIndex++)
			if(currentMap.transferCheck(transferIndex)){
				currentMap = currentMap.transferMap(transferIndex);
				currentMap.transferTracker(transferIndex);
			}
		for(int x = 0; x < currentMap.indexY; x++)
			for(int y = 0; y < currentMap.indexX; y++){
				g.drawImage(currentMap.getTerrainImg(y, x), 50*(x + 19 - currentMap.tracker[0][1]), 50*(y + 10 - currentMap.tracker[0][0]), null);		
		}
		g.drawImage(Protagonist.Gundobald.getSprite(), 50*19, 50*10, null);			
	}
}
