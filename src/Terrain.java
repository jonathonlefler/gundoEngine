//Jonathon Lefler
//This will be a place holder for terrain sprites and their associated "Troops" encounter probability. Troops is defined as enemy parties.
//This will be talked to by RhalEngine, returning probabilities of troop encounters(double) associated to a certain terrain.

import java.awt.image.*;
import java.io.File;

import javax.imageio.ImageIO;

public class Terrain {
	private BufferedImage IMG;
	private int tertype;
	private String name;
	boolean pass;

	public Terrain(int _tertype){
	tertype = _tertype;
	//use tertype to choose which terrain image to load. 0 = void, 1 = grass
	switch(tertype){
		case 0 : 
			try{
				File f = new File("void.png");
				name = "void.png"; pass = false;
				IMG = ImageIO.read(f);
			}
			catch(Exception e){
				System.out.println("Picture missing in Terrain.class, case 0.");
			}
			break;
		case 1 : 
			try{
				File f = new File("grass.png");
				name = "grass.png"; pass = true;
				IMG = ImageIO.read(f);
			}
			catch(Exception e){
				System.out.println("Picture missing in Terrain.class, case 1.");
			}
			break;
		}
	}
	
	public BufferedImage getImg(){
		return IMG;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean getPass(){
		if(pass == false)
			System.out.println("not passable");
		return pass;
	}
}
