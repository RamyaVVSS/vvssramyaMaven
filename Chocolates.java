package maven.newyear;

public class Chocolates extends Sweets {
	String chocoflav;
	Chocolates(int weight, int cost, int num, String chocoflav)
	{
		super(weight,cost,num);
		this.chocoflav=chocoflav;
	}
	public  String toString() {
		return("Cost: "+this.cost+" Weight: "+this.weight+" Number: "+this.num);
		}

}
