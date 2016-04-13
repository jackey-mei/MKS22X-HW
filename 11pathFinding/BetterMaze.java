import java.util.*;
import java.io.*;
public class BetterMaze {
    private class Node {
	Coordinate location;
	Node prev;

	public Node() {
	    location = new Coordinate();
	    prev = null;
	}
    
	public Node(Coordinate location) {
	    this.location = location;
	    prev = null;
	}
    
	public Node(Node prev) {
	    location = new Coordinate();
	    this.prev = prev;
	}
    
	public Node(Coordinate location, Node prev) {
	    this.location = location;
	    this.prev = prev;
	}

	public Node getPrev() {
	    return prev;
	}

	public void setPrev(Node prev) {
	    this.prev = prev;
    
	public Coordinate getCoordinate() {
	    return location;
	}
    }

    private char[][] maze;
    private int[] solution;
    private int startRow, startCol;
    private Frontier<Node> placesToGo;
    private boolean animate;

    public int[] solutionCoordinates() {
        return solution;
    }

    public boolean solveBFS() {  
        placesToGo = new FrontierQueue<T>();
	return solve();
    }

    public boolean solveDFS() {  
        placesToGo = new FrontierStack<T>();
	return solve();
    }

    private boolean solve() {  
        placesToGo.add(new Node(new Coordinate(startRow, startCol)));
	while (placesToGo.hasNext()) {
	    getNeightbors(placesToGo.next());
	}
    }

    public void getNeighbors(Node current) {
	if (maze[current.getCoordinate().getX() + 1][current.getCoordinate().getY()] == ' ') {
	    placesToGo.add(new Node(new Coordinate(x + 1, y), current));
	}
	if (maze[current.getCoordinate().getX() - 1][current.getCoordinate().getY()] != ' ') {
	    placesToGo.add(new Node(new Coordinate(x + 1, y), current));
	}
	if (maze[current.getCoordinate().getX()][current.getCoordinate().getY() + 1] != ' ') {
	    placesToGo.add(new Node(new Coordinate(x + 1, y), current));
	}
	if (maze[current.getCoordinate().getX()][current.getCoordinate().getY() - 1] != ' ') {
	    placesToGo.add(new Node(new Coordinate(x + 1, y), current));
	}
    }
	
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b) {
	/** IMPLEMENT THIS **/
    }    


    public BetterMaze(String filename) {
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try {
	    Scanner in = new Scanner(new File(filename));
	    //keep reading next line
	    while (in.hasNext()) {
		String line = in.nextLine();
		if (maxr == 0) {
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr ++;
		ans += line;
	    }
	}
	catch (Exception e) {
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr + " " + maxc);
	maze = new char[maxr][maxc];
	for (int i = 0; i < ans.length(); i ++) {
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if (c == 'S') {
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }

    private static final String CLEAR_SCREEN = "\033[2J";
    private static final String HIDE_CURSOR = "\033[?25l";
    private static final String SHOW_CURSOR = "\033[?25h";
    private String go(int x, int y) {
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground, int background) {
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal() {
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis) {
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString() {
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if (animate) {
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for (int i = 0; i < maxc * maxr; i ++) {
	    if(i % maxc == 0 && i != 0) {
		ans += color(37, 40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if (c == '#') {
		ans += color(38, 47) + c;
	    }
	    else {
		ans += color(33, 40) + c;
	    }
	}
	//nice animation string
	if (animate) {
	    return HIDE_CURSOR + go(0, 0) + ans + color(37, 40) + "\n" + SHOW_CURSOR + color(37, 40);
	}
	else {
	    return ans + color(37, 40) + "\n";
	}
    } 
}
