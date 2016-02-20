public class KnightBoard {
    private int[][] board;
    private int pos;;

    public KnightBoard(int size) {
	board = new int[size][size];
	for (int eachRow = 0; eachRow < size; eachRow ++) {
	    for (int eachCol = 0; eachCol < size; eachCol ++) {
		board[eachRow][eachCol] = 0;
	    }
	}
	pos = 1;
    }

    public KnightBoard(int row, int col) {
	board = new int[row][col];
	for (int eachRow = 0; eachRow < row; eachRow ++) {
	    for (int eachCol = 0; eachCol < col; eachCol ++) {
		board[eachRow][eachCol] = 0;
	    }
	}
	pos = 1;
    }

    public boolean solve() {
	return solveH(0, 0, 0);
    }

    public boolean solveH(int row, int col, int index) {
	if (board[row][col] != 0) {
	    return false;
	}
	board[row][col] = pos ++;
	if (index == board.length * board[0].length - 1) {
	    return true;
	}

	
	if (isMovable(row - 2, col + 1) && solveH(row - 2, col + 1, index + 1)) {
	    return true;
	}
	if (isMovable(row - 2, col - 1) && solveH(row - 2, col - 1, index + 1)) {
	    return true;
	}
	if (isMovable(row + 2, col + 1) && solveH(row + 2, col + 1, index + 1)) {
	    return true;
	}
	if (isMovable(row + 2, col - 1) && solveH(row + 2, col - 1, index + 1)) {
	    return true;
	}
	if (isMovable(row + 1, col + 2) && solveH(row + 1, col + 2, index + 1)) {
	    return true;
	}
	if (isMovable(row + 1, col - 2) && solveH(row + 1, col - 2, index + 1)) {
	    return true;
	}
	if (isMovable(row - 1, col + 2) && solveH(row - 1, col + 2, index + 1)) {
	    return true;
	}
	if (isMovable(row - 1, col - 2) && solveH(row - 1, col - 2, index + 1)) {
	    return true;
	}

	board[row][col] = 0;
	pos --;
	return false;
    }

    public boolean isMovable(int row, int col) {
	if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
	    return true;
	}
	return false;
    }

    public void printSolution() {
	boolean doubleDig = false;
	String theBoard = "";
	if (board.length * board[0].length >= 10) {
	    doubleDig = true;
	}
	for (int eachRow = 0; eachRow < board.length; eachRow ++) {
	    for (int eachCol = 0; eachCol < board[0].length; eachCol ++) {
		if (doubleDig && board[eachRow][eachCol] < 10) {
		    theBoard = theBoard + "0" + board[eachRow][eachCol] + " ";
		}
		else {
		    theBoard = theBoard + board[eachRow][eachCol] + " ";
		}   
	    }
	    theBoard += "\n";
	}
	System.out.println(theBoard);
    }

    public static void main(String[] args) {
	KnightBoard k = new KnightBoard(5);
	k.solve();
	k.printSolution();
    }
}
