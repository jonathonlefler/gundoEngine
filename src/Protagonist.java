//Jonathon Lefler
//Gives access to equipables. Protagonist are controlled by user

public class Protagonist extends Actor {
	private boolean equipW, equipA;
	private Weapon WEAPON = new Weapon("", 0, 0, 0, 0, 0, 0, 0); private Armor ARMOR = new Armor("", 0, 0, 0, 0, 0, 0, 0);
	//constructor will take the actors name, initial stats, whether or not they can use magic and/or skills(booleans)
	public Protagonist(String name, int STR, int MAG, int DEF, int SPD, int MAN, int TP, int HP, String sprite, boolean SKILL, boolean MAGIC){
		super(name, STR, MAG, DEF, SPD, MAN, TP, HP, sprite);
		equipW = false; equipA = false;

		chp = hp; ctp = tp; cman = man;
		skill = SKILL; magic = MAGIC;
	}	
	private void ModStr(int va){
		str = str + va;
	}
	private void ModMag(int va){
		mag = mag + va;
	}
	private void ModDef(int va){
		def = def + va;
	}
	private void ModSpd(int va){
		spd = spd + va;
	}
	private void ModMan(int va){
		man = man + va;
	}
	private void ModTp(int va){
		tp = tp + va;
	}
	private void ModHp(int va){
		hp = hp + va;
	}

	public String getEquipedWeapon(){
		return WEAPON.getName();
	}
	public String getEquipedArmor(){
		return ARMOR.getName();
	}
	public void EquipWeapon(Weapon Ename){
		if(equipW == false){
		ModStr(Ename.getstr()); ModMag(Ename.getmag()); ModDef(Ename.getdef());
		ModSpd(Ename.getspd()); ModMan(Ename.getman()); ModTp(Ename.gettp()); ModHp(Ename.gethp());
		equipW = true; WEAPON = Ename;
		}
		else{ // this makes sure the stat increases aren't cumulative
			ModStr(-WEAPON.getstr()); ModMag(-WEAPON.getmag()); ModDef(-WEAPON.getdef());
			ModSpd(-WEAPON.getspd()); ModMan(-WEAPON.getman()); ModTp(-WEAPON.gettp()); ModHp(-WEAPON.gethp());
			ModStr(Ename.getstr()); ModMag(Ename.getmag()); ModDef(Ename.getdef());
			ModSpd(Ename.getspd()); ModMan(Ename.getman()); ModTp(Ename.gettp()); ModHp(Ename.gethp());
			WEAPON = Ename;
		}
	}
	public void EquipArmor(Armor Ename){
		if(equipA == false){
		ModStr(Ename.getstr()); ModMag(Ename.getmag()); ModDef(Ename.getdef());
		ModSpd(Ename.getspd()); ModMan(Ename.getman()); ModTp(Ename.gettp()); ModHp(Ename.gethp());
		equipA = true; ARMOR = Ename;
		}
		else { // this makes sure the stat increases aren't cumulative
			ModStr(-ARMOR.getstr()); ModMag(-ARMOR.getmag()); ModDef(-ARMOR.getdef());
			ModSpd(-ARMOR.getspd()); ModMan(-ARMOR.getman()); ModTp(-ARMOR.gettp()); ModHp(-ARMOR.gethp());
			ModStr(Ename.getstr()); ModMag(Ename.getmag()); ModDef(Ename.getdef());
			ModSpd(Ename.getspd()); ModMan(Ename.getman()); ModTp(Ename.gettp()); ModHp(Ename.gethp());
			ARMOR = Ename;
		}
	}
	
	public final static Protagonist Gundobald = new Protagonist("Gundobald", 10, 10, 10, 10, 10, 10, 10, "gundobald.png", true, true);
	
}
