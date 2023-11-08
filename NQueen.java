//DAA Practical no 5: Solve n-queen problem using backtracking

public class NQueen {

	public static void main(String[] args) {
		int n=8;
		int board[][] = new int[n][n];
		
		System.out.println("The solution for " + n + " Queen is: ");
		solve(0,n,board);

	}

	static void solve(int col, int n, int board[][]) {
		//if all queen is placed
		if(col==n)
		{
			//for printing the queens
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board.length; j++) {
					System.out.print(" "+board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int row=0; row<n; row++) {
			if(issafe(row,col,n,board)) 
			{
				board[row][col] = 1;
				//if one queen is place then 
				//increment column and call solve method again
				solve(col+1,n, board);
				//same row next col = 0
				board[row][col] = 0;
			}
		}
	}
	
	static boolean issafe(int row, int col, int n, int board[][]) 
	{
		int x = row;
		int y = col;
		
		while(y>=0)
		{
			if(board[x][y]==1)
				return false;
			y--;
		}
		y=col;
		//checking upper diagonal
		while(x>=0 && y>=0)
		{
			if(board[x][y]==1)
				return false;
			x--; 
			y--;
		}
		x=row; 
		y=col;
		while(x<n && y>=0)
		{
			if(board[x][y] == 1)
				return false;
			x++;
			y--;
		}
		return true;
	}

}
