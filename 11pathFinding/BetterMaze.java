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
	}
    
	public Coordinate getCoordinate() {
	    return location;
	}
    }

    private char[][] maze;
    private int[] solution;
    private int startRow, startCol;
    private Frontier<Node> placesToGo;
    private boolean animate;
    private Node finalNode;

    public int[] solutionCoordinates() {
        Node count = finalNode;
	int i = 1;
	while (count.getPrev() != null) {
	    count = count.getPrev();
	    i ++;
	}
	int[] sol = new int[i * 2];
	Node count2 = finalNode;
        for (i = sol.length - 1; i > 0; i = i - 2) {
	    sol[i] = count2.getCoordinate().getY();
	    sol[i - 1] = count2.getCoordinate().getX();
	    count2 = count2.getPrev();
	}
	solution = sol;
	return sol;
    }

    public boolean solveBFS() {  
        placesToGo = new FrontierQueue<Node>();
	return solve();
    }

    public boolean solveDFS() {  
        placesToGo = new FrontierStack<Node>();
	return solve();
    }

    private boolean solve(){
	placesToGo.add(new Node(new Coordinate(startRow, startCol)));
	maze[startRow][startCol] = '.';
	while(placesToGo.hasNext()){
	    Node n = placesToGo.next();
	    if (maze[n.getCoordinate().getX() + 1][n.getCoordinate().getY()] == ' ') {
		placesToGo.add(new Node(new Coordinate(n.getCoordinate().getX() + 1, n.getCoordinate().getY()), n));
		maze[n.getCoordinate().getX() + 1][n.getCoordinate().getY()] = '.';
	    }
	    if (maze[n.getCoordinate().getX() - 1][n.getCoordinate().getY()] == ' ') {
		placesToGo.add(new Node(new Coordinate(n.getCoordinate().getX() - 1, n.getCoordinate().getY()), n));
		maze[n.getCoordinate().getX() - 1][n.getCoordinate().getY()] = '.';
	    }
	    if (maze[n.getCoordinate().getX()][n.getCoordinate().getY() + 1] == ' ') {
		placesToGo.add(new Node(new Coordinate(n.getCoordinate().getX(), n.getCoordinate().getY() + 1), n));
		maze[n.getCoordinate().getX()][n.getCoordinate().getY() + 1] = '.';
	    }
	    if (maze[n.getCoordinate().getX()][n.getCoordinate().getY() - 1] == ' ') {
		placesToGo.add(new Node(new Coordinate(n.getCoordinate().getX(), n.getCoordinate().getY() - 1), n));
		maze[n.getCoordinate().getX()][n.getCoordinate().getY() - 1] = '.';
	    }

	    if (maze[n.getCoordinate().getX() + 1][n.getCoordinate().getY()] == 'E') {
		finalNode = new Node(new Coordinate(n.getCoordinate().getX() + 1, n.getCoordinate().getY()), n);
		maze[n.getCoordinate().getX() + 1][n.getCoordinate().getY()] = '.';
		solutionCoordinates();
		return true;
	    }
	    if (maze[n.getCoordinate().getX() - 1][n.getCoordinate().getY()] == 'E') {
		finalNode = new Node(new Coordinate(n.getCoordinate().getX() - 1, n.getCoordinate().getY()), n);
		maze[n.getCoordinate().getX() - 1][n.getCoordinate().getY()] = '.';
		solutionCoordinates();
		return true;
	    }
	    if (maze[n.getCoordinate().getX()][n.getCoordinate().getY() + 1] == 'E') {
		finalNode = new Node(new Coordinate(n.getCoordinate().getX(), n.getCoordinate().getY() + 1), n);
		maze[n.getCoordinate().getX()][n.getCoordinate().getY() + 1] = '.';
		solutionCoordinates();
		return true;
	    }
	    if (maze[n.getCoordinate().getX()][n.getCoordinate().getY() - 1] == 'E') {
		finalNode = new Node(new Coordinate(n.getCoordinate().getX(), n.getCoordinate().getY() - 1), n);
		maze[n.getCoordinate().getX()][n.getCoordinate().getY() - 1] = '.';
		solutionCoordinates();
		return true;
	    }

	    if (animate) {
		System.out.println(this);
		wait(100);
	    }
	}
	return false;
    }
	
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b) {
	animate = b;
    }    


    public BetterMaze(String filename) {
	finalNode = null;
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
    
    public static void main(String[] args) {
	BetterMaze someMaze = new BetterMaze("data3.dat");
	someMaze.setAnimate(false);
	System.out.println(someMaze.solveDFS());
	int[] sol = someMaze.solutionCoordinates();
	String s = "[";
	for(int i = 0; i < sol.length; i++){
	    s = s + sol[i] + ", ";
	}
	s = s.substring(0, s.length() - 2) + "]";
        System.out.println(s);
    }
}
