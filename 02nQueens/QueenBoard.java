public class QueenBoard{
    private int[][] board;
    
    public QueenBoard(int size) {
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve() {
	return solveH(0);
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH(int col) {
	if (col == board.length) {
	    return true;
	}
	for (int row = 0; row < board.length; row ++) {
	    if (col == 0) {
		for (int someRow = 0; someRow < board.length; someRow ++) {
		    for (int someCol = 1; someCol < board.length; someCol ++) {
			board[someRow][someCol] = 0;
		    }
		}
	    }
	    if (addQueen(row, col)) {
		return solveH(col + 1);
	    }
	    if (row == board.length - 1 && addQueen(row, col) == false) {
		if (col == 0) {
		    return false;
		}
		for (int eachRow = 0; eachRow < board.length; eachRow ++) {
		    if (board[eachRow][col - 1] == 1) {
			removeQueen(eachRow, col - 1);
			board[eachRow][col - 1] = -1;
		    }
		}
		return solveH(col - 1);
	    }
	}
	return false;
    }

    public void printSolution() {
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
	String theBoard = "";
	for (int eachRow = 0; eachRow < board.length; eachRow ++) {
	    for (int eachCol = 0; eachCol < board[eachRow].length; eachCol ++) {
		if (board[eachRow][eachCol] == 0 || board[eachRow][eachCol] < 0) {
		    theBoard += "_ ";
		}
		if (board[eachRow][eachCol] == 1) {
		    theBoard += "Q ";
		}
	    }
	    theBoard += "\n";
	}
	System.out.println(theBoard);
    }

    private boolean addQueen(int row, int col) {
	if (board[row][col] != 0) {
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while (col + offset < board[row].length) {
	    //right
	    board[row][col + offset] --;
	    //diagonally top right
	    if (row - offset >= 0){
		board[row - offset][col + offset] --;
	    }
	    //diagonally bottom right
	    if (row + offset < board.length) {
		board[row + offset][col + offset] --;
	    }
	    offset ++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col) {
	if (board[row][col] != 1) {
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while (col + offset < board[row].length) {
	    //right
	    board[row][col + offset] ++;
	    //diagonally top right
	    if (row - offset >= 0){
		board[row - offset][col + offset] ++;
	    }
	    //diagonally bottom right
	    if (row + offset < board.length) {
		board[row + offset][col + offset] ++;
	    }
	    offset ++;
	}
	return true;
    }

    public String toString() {
	String ans = "";
	for(int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board[0].length; col ++){
		ans += board[row][col] + "\t";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public static void main(String[] args) {
	QueenBoard b = new QueenBoard(5);
        b.solve();
	System.out.println(b);
	b.printSolution();
    }
}
