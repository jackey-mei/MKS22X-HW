public class Board {
    int[][] board;

    public Board(int numRowCol) {
	board = new int[numRowCol][numRowCol];
    }
	
    public void addQueens(int row, int col) {
	board[row][col] = 1;
	for (int someRow = 0; someRow < board.length; someRow ++) {
	    for (int someCol = 0; someCol < board.length; someCol ++) {
		if (someRow == row && someCol != col) {
		    board[someRow][someCol] --;
		}
		if (someCol == col && someRow != row) {
		    board[someRow][someCol] --;
		}
		if (someCol - col == someRow - row && someCol - col != 0) {
		    board[someRow][someCol] --;
		}
	    }
	}
    }

    public void removeQueens(int row, int col) {
	board[row][col] = 0;
	for (int someRow = 0; someRow < board.length; someRow ++) {
	    for (int someCol = 0; someCol < board.length; someCol ++) {
		if (someRow == row && someCol != col) {
		    board[someRow][someCol] ++;
		}
		if (someCol == col && someRow != row) {
		    board[someRow][someCol] ++;
		}
		if (someCol - col == someRow - row && someCol - col != 0) {
		    board[someRow][someCol] ++;
		}
	    }
	}
    }
}
	
		
	
	
