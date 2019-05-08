//Jonathon Lefler
//Creates the window of the game. And handles user inputs.

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GFrame extends JFrame {

	static ControlSwitch SWITCH = new ControlSwitch();
	static DrawingArea Battle = new DrawingArea();
	static DrawingArea Overworld = new DrawingArea();
	static JPanel cont2 = new JPanel();
	static JPanel cont3 = new JPanel();

	public GFrame(){
		setBounds(0, 0, 1900, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); setUndecorated(true);

		InputMap im = cont2.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap am = cont2.getActionMap();
		InputMap im2 = cont3.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap am2 = cont3.getActionMap();
		
		getContentPane().add(cont2);
		cont2.setLayout(new BorderLayout());
		cont2.add(Overworld, BorderLayout.CENTER);
	
		cont3.setLayout(new BorderLayout());
		cont3.add(Battle, BorderLayout.CENTER);
		
		JPanel BattlePanel = new JPanel();
		cont3.add(BattlePanel, BorderLayout.SOUTH);
		
		BattlePanel.setLayout(new GridLayout(1,2));
		
		String[] commands = {"Attack", "Guard", "Skill", "Magic"};
		JList<String> t1 = new JList<String>(commands);
		JButton t2 = new JButton("East - Where protagonist stats will go");
		
		BattlePanel.add(t1);
		BattlePanel.add(t2);
		
		JButton b3 = new JButton("You're in the battle engine.");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Battle button was pressed.");
			}
		});
		cont3.add(b3, BorderLayout.EAST);

		//Overworld
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "w"); //Move up
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "s"); //Move down
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "p"); //Debugging
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "d"); //Move left
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "a"); //Move right
		am.put("a", new ActionIn("a"));
		am.put("d", new ActionIn("d"));
		am.put("p", new ActionIn("p"));
		am.put("w", new ActionIn("w"));
		am.put("s", new ActionIn("s"));
		
		//Battle
		im2.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "w"); 
		im2.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "s");
		im2.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "p"); 
		am2.put("p", new ActionIn("p"));
		am2.put("w", new ActionIn("w"));
		am2.put("s", new ActionIn("s"));
		
		getContentPane().removeAll();
		getContentPane().add(cont2);
		
		setVisible(true);

	}
		
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new GFrame();
			}
		});		
	}
	
	public void switchV(){
		if(SWITCH.getMode() == false){
			getContentPane().removeAll();
			getContentPane().add(cont2);
			SWITCH.SwitchMode();
			validate();
			repaint();
		}
		else{
			getContentPane().removeAll();
			getContentPane().add(cont3);
			SWITCH.SwitchMode();
			validate();
			repaint();
		}
	}
	
	private class ActionIn extends AbstractAction{
		private String cmd;
		
		public ActionIn(String COMMAND){
			cmd = COMMAND;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(cmd.equalsIgnoreCase("W")){
				if(SWITCH.getMode() == true){ //'w' will move the player/party sprite up _OVERWORLD_
					if(SWITCH.checkPassable(cmd))
						OverworldEngine.currentMap.modTracker(0, true, true);			
				}
				else{ //'w' will move the selector up _BATTLE_

				}
				System.out.println("W was pressed");
			}
			else if(cmd.equalsIgnoreCase("S")){
				if(SWITCH.getMode() == true){ //'s' will move the player/party sprite down _OVERWORLD_
					if(SWITCH.checkPassable(cmd))
						OverworldEngine.currentMap.modTracker(0, true, false);
				}
				else{ //'s' will move the selector down _BATTLE_
					
				}
				System.out.println("S was pressed");
			}
			if(cmd.equalsIgnoreCase("D")){
				if(SWITCH.getMode() == true){ //'d' will move the player/party sprite right _OVERWORLD_
					if(SWITCH.checkPassable(cmd))
						OverworldEngine.currentMap.modTracker(0, false, true);
				}
				else{ //'d' will move the selector right _BATTLE_
					
				}
				System.out.println("D was pressed");
			}
			if(cmd.equalsIgnoreCase("A")){
				if(SWITCH.getMode() == true){ //'a' will move the player/party sprite left _OVERWORLD_
					if(SWITCH.checkPassable(cmd))
						OverworldEngine.currentMap.modTracker(0, false, false);
				}
				else{ //'a' will move the selector left _BATTLE_
					
				}
				System.out.println("A was pressed");
			}
			if(cmd.equalsIgnoreCase("P")){ //Debugging
				switchV();
			}
			repaint();
		}
	}
}
