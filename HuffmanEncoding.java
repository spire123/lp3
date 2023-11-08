//DAA practical no 2: Huffman's Encoding using greedy method
package practice1;
import java.util.*;

//creating huffmanNode class
class HuffmanNode {
	int data;
	char c;
	HuffmanNode right;
	HuffmanNode left;
}

//Comparator
class MyComparator1 implements Comparator<HuffmanNode>{

	@Override
	public int compare(HuffmanNode o1, HuffmanNode o2) {
		return o1.data - o2.data;
	}
}

public class HuffmansEncoding {
	
	//Method to print Huffman encoding
	public static void printCode(HuffmanNode root, String s)
	{
		if(root.right == null && root.left == null && Character.isLetter(root.c)) 
		{
			System.out.println(root.c + ":"+ s);
			return;
		}
		printCode(root.right, s + "0");
		printCode(root.left, s + "1");
	}
	
	
	
	public static void main(String args[]) {
		//declare values
		int n=6;
		char[] charArray = {'a','b','c','d','e','f'};
		int[] charfreq = {5,9,12,13,16,15};
		
		//creating the object of priority queue with HuffmanNode
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode> (n, new MyComparator1());
		
		//adding value to queue
		for(int i=0; i<n; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.data = charfreq[i];
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}
		//root is null
		HuffmanNode root = null;
		
		//adding values to HuffmanNode
		while(q.size()>1)
		{
			HuffmanNode x = q.peek();
			q.poll();
			HuffmanNode y = q.peek();
			q.poll();
			
			HuffmanNode f = new HuffmanNode();
			f.data = x.data + y.data;
			
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;
			q.add(f);
		}
		
		//call the printCode method
		printCode(root, "");
	}
}
