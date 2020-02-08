package maven.newyear;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NewyearGift implements Gifts {
	String name;
	int totalsweets,totalchocos; //total sweets and chocolates in all the gifts
	static int totalwt; //total weight of all gifts
	static Sweets[] sweets;
	static Chocolates[] chocolates;
	static NewyearGift gifts[];
	static Scanner sc;
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	NewyearGift(int no_of_sweets, int no_of_chocolates ,String ch_name)
	{
		name=ch_name;
		sweets = new Sweets[no_of_sweets];
		chocolates = new Chocolates[no_of_chocolates];
	}
	
	public static void addnumber(String name, int quant)
	{
		if(hm.containsKey(name)) 
		{
			hm.put(name,hm.get(name)+quant);
		}
		else
		{
			hm.put(name,quant);	
		}
		
	}
	
	public void total_items()
	{
		System.out.println(sweets.length+chocolates.length+gifts.length);
	}
	
	public static void candyCount(int choice)
	{

		if(choice==1)
		{
			System.out.println("Enter the name of the child whose candies need to be counted: ");
			String ch_name = sc.next();
			if(hm.containsKey(ch_name))
				System.out.println(ch_name+"  has "+hm.get(ch_name)+" candies ");
			else
				System.out.println("Child not found");
			
		}
		else if(choice==2)
		{
			System.out.println("Enter the value of no to get the number of gifts in which the number of chocolates are less than no:");
			int no = sc.nextInt();
			int count=0;
			for(int i=0;i<gifts.length;i++)
			{
				if(gifts[i].totalchocos<no)
					count++;
			}
			System.out.println(count);
		}
		else if(choice==3)
		{
			System.out.println("Enter the value of no to find the number of gifts in which the number of chocolates are more than no:");
			int no = sc.nextInt();
			int count=0;
			for(int i=0;i<gifts.length;i++)
			{
				if(gifts[i].totalchocos>no)
					count++;
			}
			System.out.println(count);
		}
	}
	
	public static void main(String args[])
	{
		 sc = new Scanner(System.in);
		 System.out.println("Enter the number of children to whom the new year gifts have to be distributed: ");
		 int children = sc.nextInt();
		 gifts = new NewyearGift[children];
		 for(int i=0;i<children;i++)
		 {
			System.out.println("Enter the child's name: ");
			String ch_name = sc.next();
			System.out.println("Enter the number of varieties of sweets and chocolates in the gifts: ");
			int no_sweets_type = sc.nextInt();
			int no_chocolates_type = sc.nextInt();
			gifts[i] = new NewyearGift(no_sweets_type,no_chocolates_type,ch_name);
			
			int wt_of_sweet,cost_of_sweet,wt_of_choco,cost_of_choco;	
			int no_of_sw=0;
			int no_of_chocos=0;
			
			System.out.println("Enter the weight of sweets, cost and quantity for all the sweets: ");
			
			for(int j=0;j<no_sweets_type;j++)
			{
			    wt_of_sweet= sc.nextInt();
			    cost_of_sweet= sc.nextInt();
				int quantity =sc.nextInt();
				no_of_sw+=quantity;
				sweets[j]=new Sweets(wt_of_sweet,cost_of_sweet,quantity);
				gifts[i].totalwt+=wt_of_sweet*quantity;
			}
			
			gifts[i].totalsweets=no_of_sw;
			
			if(no_chocolates_type!=0)
				System.out.println("Enter the weight of chocolates, cost, quantity and flavour for all the chocolates: ");
			else
				addnumber(ch_name,0);
			
			for(int j=0;j<no_chocolates_type;j++)
			{
				wt_of_choco = sc.nextInt();
			    cost_of_choco = sc.nextInt();
				int quantity =sc.nextInt();
				String choc_flavour=sc.next();
				no_of_chocos+=quantity;
				chocolates[i]=new Chocolates(wt_of_choco,cost_of_choco,quantity,choc_flavour);
				gifts[i].totalwt+=wt_of_choco*quantity;
				addnumber(ch_name,quantity);
				
			}
	
			gifts[i].totalchocos=no_of_chocos;
			
			if(no_chocolates_type!=0)
			{
				System.out.println("How do you want to sort the chocolates?\n 1.Cost 2.Weight 3.Quantity");
				int choice=sc.nextInt();
				Arrays.sort(chocolates,new ChocolateSorting(choice));
				System.out.println("After sorting the chocolates in a gift");
				for(int j=0;j<no_chocolates_type;j++) 
				{
					System.out.print(chocolates[j]);
					System.out.println();
				}
			}
				System.out.println();
		 }
		 
		 System.out.println("following are the given options:\n1.Count chocolates for a particular child.\n"
+ "2.Count the gifts with chocolates less than some value.\n3.Count the gifts with chocolates more than some value");
			
		 System.out.println("Select an option: ");
		 int choice = sc.nextInt();
		 candyCount(choice);
			
		 System.out.println("Total Weight of the new year gifts is: "+totalwt);
		 sc.close();
			
		}
	
}
