//Jonathon Lefler
//Each individual equipable can modify stats. Actors can only equip a certain number of armor and weapons.
//you can essentially treat this class, and sub-classes, like placeholders for stats.

public class Equipables {
	protected int str, mag, def, spd, man, tp, hp;
	//strength, magic, defense, speed, mana, tp, health
	protected String Name;
	
	public Equipables(String name, int STR, int MAG, int DEF, int SPD, int MAN, int TP, int HP){
		str = 0; mag = 0; def = 0; spd = 0; man = 0; tp = 0; hp = 0;
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
	public String getName(){
		return Name;
	}
	public void PrintStats(){
		System.out.println(Name + " modifies Strength by " + getstr());
		System.out.println(Name + " modifies Magic by " + getmag());
		System.out.println(Name + " modifies Defense by " + getdef());
		System.out.println(Name + " modifies Speed by " + getspd());
		System.out.println(Name + " modifies Mana by" + getman());
		System.out.println(Name + " modifies Tp by " + gettp());
		System.out.println(Name + " modifies Health by " + gethp());
		System.out.println("");
	}
}
