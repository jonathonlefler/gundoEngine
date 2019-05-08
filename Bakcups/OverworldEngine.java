//Jonathon Lefler
//This is the engine for the overworld
//Knows what terrain the player is on - will need to talk to the terrain class.

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class OverworldEngine {
	private static BufferedImage[][] ter;

	public OverworldEngine(){
		ter = new BufferedImage[76][40];
		for(int a = 0; a < 76; a++)
			for(int b = 0; b < 40; b++){
				if(b == 0 || b == 39){
					try{
						File f = new File("void.png");
						ter[a][b] = ImageIO.read(f);
						System.out.println("Loading a " + f + " into ter[" + a +"][" + b + "].");
					}
					catch(Exception e){
						System.out.println("Picture missing in OverworldEngine.class");
					}		
				}
				else if(a == 0 || a == 75){
					try{
						File f = new File("void.png");
						ter[a][b] = ImageIO.read(f);
						System.out.println("Loading a " + f + " into ter[" + a +"][" + b + "].");
					}
					catch(Exception e){
						System.out.println("Picture missing in OverworldEngine.class");
					}
				}
				else{
					try{
						File f = new File("grass.png");
						ter[a][b] = ImageIO.read(f);
						System.out.println("Loading a " + f + " into ter[" + a +"][" + b + "].");
					}
					catch(Exception e){
						System.out.println("Picture missing in OverworldEngine.class");
					}
				}
			}	
	}
	
	public static void paint(Graphics g){
		for(int a = 0; a < 40; a++)
			for(int b = 0; b < 76; b++){
				g.drawImage(ter[b][a], 25*b, 25*a, null);
		}//*/
	}
}
