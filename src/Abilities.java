//Jonathon Lefler
// Abilities use either Mana or Tp as a resource to do various effects

public class Abilities {
	protected int magnitude, cost;
	protected String Name;
	
	public Abilities(String name, int COST, int MAGNITUDE){
		magnitude = 1; cost = 1;
	}
	public int getMagnitude(){
		return magnitude;
	}
	public int getCost(){
		return cost;
	}
	public String getName(){
		return Name;
	}
}
