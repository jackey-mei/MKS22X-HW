import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private int startx, starty;
    private boolean animate;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani) {
        try {
	    startx = -1;
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int numOfLines = 0;
	    int charPerLine = 0;
	    while(in.hasNextLine()) {
		numOfLines ++;
		String currentLine = in.nextLine();
		charPerLine = currentLine.length();
	    }
	    maze = new char[numOfLines][charPerLine];
	    animate = ani;
	    Scanner in2 = new Scanner(f);
	    //System.out.println(numOfLines);
	    //System.out.println(charPerLine);
	    in.close();
	    String mazeS = "";
	    while (in2.hasNextLine()) {
		mazeS += in2.nextLine();
	    }
	    for (int i = 0; i < numOfLines; i ++) {
		for (int j = 0; j < charPerLine; j ++) {
		    maze[i][j] = mazeS.charAt(((i * charPerLine) + j));
		    if (maze[i][j] == 'S') {
			startx = i;
			starty = j;
		    }
		}
	    }
	    in2.close();
	}
	catch(FileNotFoundException e) {
	    System.out.println("File was not found");
	}
	    
		
    }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve() {
        if (startx < 0) {
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }
	else {
            maze[startx][starty] = ' ';
            return solve(startx, starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int row, int col){
        if (animate) {
            System.out.println(this);
            wait(30);
        }
	else {
	    return false; //so it compiles
	}
	if (maze[row][col] == 'E') {
	     return true;
	}

	maze[row][col] = '@';
	if (isMovable(row - 1, col) && solve(row - 1, col)) {
	    return true;
	}
	if (isMovable(row, col + 1) && solve(row, col + 1)) {
	    return true;
	}
	if (isMovable(row + 1, col) && solve(row + 1, col)) {
	    return true;
	}
	if (isMovable(row, col - 1) && solve(row, col - 1)) {
	    return true;
	}
	maze[row][col] = ' ';
	return false;
    }

    public boolean isMovable(int row, int col) {
	if (maze[row][col] != '#' && maze[row][col] != '@') {
	    return true;
	}
	return false;
    }


    //FREE STUFF!!! *you should be aware of this*


    public void clearTerminal() {
        System.out.println(CLEAR_SCREEN);
    }


    public String toString() {
        int maxx = maze.length;
        int maxy = maze[0].length;
	//System.out.println(maxx);
	//System.out.println(maxy);
        String ans = "";

        if (animate) {

            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";

        }
        for (int i = 0; i < maxx * maxy; i ++) {
            if (i % maxy == 0 && i != 0){
		ans += "\n";
            }
            char c = maze[i / maxy][i % maxy];
            if (c == '#'){
                ans += color(38,47) + c;
            }
	    else {
                ans += color(33,40) + c;
            }
        }
        return HIDE_CURSOR + go(0, 0) + ans + "\n" + SHOW_CURSOR + color(37, 40);
    }


    //MORE FREE STUFF!!! *you can ignore all of this*

    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN = "\033[2J";
    private static final String HIDE_CURSOR = "\033[?25l";
    private static final String SHOW_CURSOR = "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x, int y) {
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground, int background) {
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
}
