//DAA Practical no 4: Fractional Knapsack using Greedy Method
package practice1;

import java.util.Arrays;
import java.util.Comparator;

//create class for store the wt and profit
class item{
	float wt;
	float profit;
	
	public item(int p, int w) {
		this.wt = w;
		this.profit = p;
	}
}

//comparator class
class MyComparator2 implements Comparator<item> {

	@Override
	public int compare(item x, item y) {
		float a = (x.profit/x.wt);
		float b = (y.profit/y.wt);
		
		if(a>b) return -1;
		else return 1;
	}
	
}

public class FractionalKnapsack {

	static void fracKnapsack(item[] items, float bagsize) {
		float maxprofit=0;
		//sorting using mycomparator
		Arrays.sort(items, new MyComparator2());
		
		
		for(int i=0; i<items.length; i++)
		{
			if(bagsize >= items[i].wt)
			{
				maxprofit = maxprofit + items[i].profit;
				bagsize = bagsize-items[i].wt;
			}
			else
			{
				float x = (items[i].profit/items[i].wt) * bagsize;
				maxprofit = maxprofit+x;
				bagsize=0;
				break;
			}
		}
		System.out.println(maxprofit);
	}
	
	public static void main(String[] args) {
		item[] arr = {new item(60,10), new item(100,20), new item(120,30)};
		int bagsize = 50;

		System.out.println("MaxProfit is: ");
		fracKnapsack(arr, bagsize);
	}

}
