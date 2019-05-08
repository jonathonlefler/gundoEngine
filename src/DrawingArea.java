//Jonathon Lefler

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class DrawingArea extends JPanel {
	
	public DrawingArea(){	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		GFrame.SWITCH.paint(g);
	}
}
