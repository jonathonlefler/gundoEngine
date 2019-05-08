//Jonathon Lefler
//The Map class handles putting together the Overworld image in an Terrain[][]. It also handles the movement of
//objects with the map, as well as map transfers - transfers between two maps-.

import java.awt.image.BufferedImage;

public class Map {
	private Terrain[][] ter;
	public int indexX, indexY, NumofTranPoints;
	private String name;
	int[][] tracker; //tracks the movement of things that can move. Index 0 is reserved for the player.
	private int[][] transPoints;
	
	public Map(String _name, int aIndex, int bIndex){
		ter = new Terrain[aIndex][bIndex];
		name = _name;
		indexX = aIndex; indexY = bIndex;
		tracker = new int[10][2];
		//Set individual map properties here, including transfer points
		transPoints = new int[2][2];
		if(name.equals("Test Map")){
			System.out.println("TransferPoints for Test Map initialized");		
			transPoints[0][0] = 2; transPoints[0][1] = 1;
			tracker[0][0] = 10; tracker[0][1] = 19;
			NumofTranPoints = 1;
		}
		else if(name.equals("map2")){
			System.out.println("TransferPoints for map2 initialized");
			transPoints[0][0] = 1; transPoints[0][1] = 1;
			tracker[0][0] = 12; tracker[0][1] = 11;
			NumofTranPoints = 1;
		}/*
		else if(name.equals(""))
		else if(name.equals(""))
		//*/
	}
	
	public void setTerrain(int aIndex, int bIndex, int terType){
			try{
				ter[aIndex][bIndex] = new Terrain(terType); //0 = void, 1 = grass								
			}
			catch(Exception e){
				System.out.println("Picture missing in Map object: " + name + " at indicies: " + aIndex + "," + bIndex);
			}
	}
	
	public BufferedImage getTerrainImg(int aIndex, int bIndex){
		if(aIndex < 0 || bIndex < 0)
			return null;
		else
			return ter[aIndex][bIndex].getImg();
	}
	
	public boolean passageCheck(String direction){
		if(direction.equalsIgnoreCase("W")){
			//System.out.println(tracker[0][0] + "," + tracker[0][1]);
			return ter[tracker[0][0] - 1][tracker[0][1]].getPass();
		}
		else if(direction.equalsIgnoreCase("S")){
			//System.out.println(tracker[0][0] + "," + tracker[0][1]);
			return ter[tracker[0][0] + 1][tracker[0][1]].getPass();
		}
		else if(direction.equalsIgnoreCase("A")){
			//System.out.println(tracker[0][0] + "," + tracker[0][1]);
			return ter[tracker[0][0]][tracker[0][1] + 1].getPass();
		}
		else{ // D
			//System.out.println(tracker[0][0] + "," + tracker[0][1]);
			return ter[tracker[0][0]][tracker[0][1] - 1].getPass();
		}
	}
	
	public Map transferMap(int transferIndex){
		System.out.println(tracker[0][0] + "," + tracker[0][1]);
		if(tracker[0][0] == transPoints[transferIndex][0] && tracker[0][1] == transPoints[transferIndex][1]){
			if(name.equals("Test Map")){ //map
				return OverworldEngine.map2;
			}
			else if(name.equals("map2")){ //map2
				return OverworldEngine.map;
			}
			else return OverworldEngine.currentMap;
		}
		else
			return OverworldEngine.currentMap;	
	}
	
	public boolean transferCheck(int transferIndex){
		if(tracker[0][0] == transPoints[transferIndex][0] && tracker[0][1] == transPoints[transferIndex][1]){
			System.out.println("Transfer Activated"); return true;
		}
		else
			return false;	
	}
	
	public void transferTracker(int transferPoint){
		tracker[0][0] = transPoints[transferPoint][0];
		tracker[0][1] = transPoints[transferPoint][1];
	}
	
	public void modTracker(int index, boolean lat, boolean up_right){ //index 0 is reserved for the party sprite.
		if(lat)
			if(up_right)
				tracker[index][0]--;
			else
				tracker[index][0]++;
		else
			if(up_right)
				tracker[index][1]--;
			else
				tracker[index][1]++;
	}
}
