//Jonathon Lefler
//Dictates what the canvas will look like while battle engine is active. Possible to use this as overworld as well. 
//Will need to be an image, dictated by what terrain the user is on.
//Could use the same canvas just make panels visable or not?

import java.awt.*;

@SuppressWarnings("serial")
public class Battleback extends Canvas {

	
	public Battleback(){
	}
	@Override
	public void paint(Graphics g){
		GFrame.SWITCH.paint(g);
	}
}
