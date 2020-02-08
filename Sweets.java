package maven.newyear;

public class Sweets {
	int cost,weight,num;
	Sweets(int weight,int cost, int num)
	{
		this.cost=cost;
		this.weight=weight;
		this.num=num;
	}
	public String toString() 
	{
		return("Cost: "+this.cost+" Weight: "+this.weight+" Number: "+this.num);
	}
}
