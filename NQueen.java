//DAA Practical 4: N-Queen using Backtracking

import java.util.Scanner;

public class NQueen {
	
	static void solve(int col, int n, int board[][])
	{
		if(col==n)
		{
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(" " + board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int row=0; row<n; row++) {
			if(issafe(col, row, n, board))
			{
				board[row][col]=1;
				solve(col+1, n, board);
				board[row][col] = 0;
			}
		}
	}
	
	static boolean issafe(int col, int row, int n, int board[][])
	{
		int x= row;
		int y= col;
		while(y>=0)
		{
			if(board[x][y]==1) return false;
			y--;
		}
		y=col;
		while(x>=0 && y>=0)
		{
			if(board[x][y]==1) return false;
			y--;
			x--;
		}
		x=row;
		y=col;
		while(x<n && y>=0) 
		{
			if(board[x][y]==1) return false;
			y--;
			x++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the number for n queen: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int board[][] = new int[n][n];
		
		System.out.println("Solution for " + n + " queens is: ");
		solve(0, n, board);

	}

}

