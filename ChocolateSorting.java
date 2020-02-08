package maven.newyear;

import java.util.Comparator;
public class ChocolateSorting implements Comparator<Chocolates>
{
	int choice;
	ChocolateSorting(int opt)
	{
		this.choice=opt;
	}
	public int compare(Chocolates c1,Chocolates c2)
	{
		switch(choice){
			case 1:
				return c1.cost-c2.cost;
		case 2:
				return c1.weight-c2.weight;
			case 3:
				return c1.num-c2.num;
		}
		return 0;
	}
}
