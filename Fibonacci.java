//DAA Practical No 1: Fibonnaci using Java (Recursive and Non Recursive) 
//Time Complexity: 
//Space Complexity: 

package practice1;

import java.util.Scanner;

public class Fibonacci {

	static int fib_rec(int n) {
		if(n==1) return 0;
		else if(n==2) return 1;
		
		return fib_rec(n-1) + fib_rec(n-2);
	}
	
	static int fib(int n) {
		if(n==1) return 0;
		else if(n==2) return 1;
		
		int f1=0, f2=1, f3=0;
		for(int i=3; i<=n; i++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f3;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n= sc.nextInt();
		
		System.out.println("Recursive: ");
		for(int i=1; i<=n; i++) {
			System.out.print(fib_rec(i)+ " ");
		}
		
		System.out.println("Non Recursive");
		for(int i=1; i<=n; i++) {
			System.out.print(fib(i)+" ");
		}

	}

}
