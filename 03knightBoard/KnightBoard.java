public class KnightBoard {
    private int[][] board;

    public KnightBoard(int size) {
	board = new int[size + 4][size + 4];
	for (int eachRow = 0; eachRow < size; eachRow ++) {
	    for (int eachCol = 0; eachCol < size; eachCol ++) {
		if (eachRow == 0 || eachRow == 1 || eachRow == size - 1 || eachRow == size - 2 || eachCol == 0 || eachCol == 1 || eachCol == size - 1 || eachCol == size - 2) {
		    board[eachRow][eachCol] = -1;
		}
	    }
	}
    }

    public boolean solve() {
	return false;
    }

    public boolean solveH() {
	return false;
    }

    public void printSolution() {
    }
}