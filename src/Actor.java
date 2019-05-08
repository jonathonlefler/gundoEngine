//Jonathon Lefler
//This class creates place holders for statistics, and sprites(need to do)
//Gives access to Attack and Guard commands
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Actor {
	protected int str, mag, def, spd, man, tp, hp, cman, ctp, chp;
	//strength, magic, defense, speed, mana, tp, health, current mana, current tp, current health
	protected boolean skill, magic; //whether or not the actor can use skill and/or magic
	protected boolean Attack, Guard;
	protected String Name;
	protected BufferedImage Sprite;
	public Actor(String name, int STR, int MAG, int DEF, int SPD, int MAN, int TP, int HP, String sprite){
		str = 0; mag = 0; def = 0; spd = 0; man = 1; tp = 1; hp = 1;
		skill = false; magic = false;
		Attack = true; Guard = true;
		try{
			File s = new File(sprite);
			Sprite = ImageIO.read(s);
		}
		catch(Exception e){
			System.out.println("Picture missing in Actor.class(Super), in the Object " + name);
		}		
	}
	public int getstr(){
		return str;
	}
	public int getmag(){
		return mag;
	}
	public int getdef(){
		return def;
	}
	public int getspd(){
		return spd;
	}
	public int getman(){
		return man;
	}
	public int gettp(){
		return tp;
	}
	public int gethp(){
		return hp;
	}
	public int getCman(){
		return cman;
	}
	public int getCtp(){
		return ctp;
	}
	public int getChp(){
		return chp;
	}
	public void ModChp(int va){ //ModC methods will be used to modify the CURRENT parameter of the actor.
		chp = chp + va;
	}
	public void ModCtp(int va){
		ctp = ctp + va;
	}
	public void ModCman(int va){
		cman = cman + va;
	}
	public boolean Checkskill(){
		return skill;
	}
	public boolean Checkmagic(){
		return magic;
	}
	public boolean CheckAttack(){
		return Attack;
	}
	public boolean CheckGuard(){
		return Guard;
	}
	public String getName(){
		return Name;
	}
	public BufferedImage getSprite(){
		return Sprite;
	}
	public void PrintStats(){
		System.out.println(Name + "'s Strength:" + getstr());
		System.out.println(Name + "'s Magic:" + getmag());
		System.out.println(Name + "'s Defense:" + getdef());
		System.out.println(Name + "'s Speed:" + getspd());
		System.out.println(Name + "'s Mana:" + getman());
		System.out.println(Name + "'s Tp:" + gettp());
		System.out.println(Name + "'s Health:" + gethp());
		System.out.println("");
	}
}
