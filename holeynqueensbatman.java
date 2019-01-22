import java.util.*;

public class holeynqueensbatman	{
	
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		int boardSize;
		int numHoles;
		int temp;
		QueensBoard myBoard;
		
		
		while (sc.hasNext())	{
			
			boardSize = sc.nextInt();
			numHoles = sc.nextInt();
			
			
			if (boardSize == 0 && numHoles == 0)	{
				System.exit(0);
			}
			
			int[][] holes = new int[boardSize][boardSize];
			
			for (int i = 0; i < numHoles; i++)	{
				holes[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			myBoard = new QueensBoard(boardSize, holes);
			myBoard.findQueens(0);
			System.out.println(myBoard.numSolutions);
			
		}
		
	}
}

class QueensBoard	{
	
	int boardSize;
	int numSolutions;
	int[][] holes;
	int[][] board;
	
	public QueensBoard(int n, int[][] temp)	{
		boardSize = n;
		numSolutions = 0;
		holes = temp;
		board = new int[n][n];
	}
	
	boolean canPut(int board[][], int row, int col)	{
		
		// check if hole
		if (holes[row][col] == 1)	{
			return false;
		}
		
		// checks current row
		for (int i = 0; i < col; i++)	{
			if (board[row][i] == 1)	{
				return false;
			}
		}
		
		int i, j;
		
		// check up left diagonal
		for (i= row, j = col; i >= 0 && j >= 0; i--, j--)	{
			if (board[i][j] == 1)	{
				return false;
			}
		}
		
		// check down left diagonal
		for (i = row, j = col; j >= 0 && i < boardSize; i++, j--)	{
			if (board[i][j] == 1)	{
				return false;
			}
		}
		
		return true;
	}
	
	boolean findQueens(int col)	{
		
		// if end of board columns reached
		if (col >= boardSize)	{
			return true;
		}
		
		for (int i = 0; i < boardSize; i++)	{
			if (canPut(board, i, col))	{
				
				// placing
				board[i][col] = 1;
				numSolutions++;
				
				// recurring
				if (findQueens(col+1) == true)	{
					numSolutions++;
				}
								
				// not placing
				board[i][col] = 0;
				numSolutions--;
			}
		}
		return false;
	}
}