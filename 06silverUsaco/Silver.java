import java.util.*;
import java.io.*;
public class Silver {
    public static int countTravel(int[][] land, int startx, int starty, int endx, int endy, int numofMoves, boolean firstIteration) {
	//printArray(land);
	if (numofMoves == 0) {
	    return land[endx][endy];
	}
	if (firstIteration) {
	    land[startx][starty] = 1;
	    return countTravel(land, startx, starty, endx, endy, numofMoves, false);
	}
	else {
	    int[][] newLand = new int[land.length][land[0].length];
	    for (int i = 0; i < land.length; i ++) {
		for (int j = 0; j < land[0].length; j ++) {
		    if (land[i][j] != -1) {
			if (i - 1 >= 0 && land[i - 1][j] != -1) {
			    newLand[i][j] += land[i - 1][j];
			}
			if (j + 1 < land[0].length && land[i][j + 1] != -1) {
			    newLand[i][j] += land[i][j + 1];
			}
			if (i + 1 < land.length && land[i + 1][j] != -1) {
			    newLand[i][j] += land[i + 1][j];
			}
			if (j - 1 >= 0 && land[i][j - 1] != -1) {
			    newLand[i][j] += land[i][j - 1];
			}
		    }
		    else {
			newLand[i][j] = -1;
		    }
		}
	    }
	    numofMoves --;
	    return countTravel(newLand, startx, starty, endx, endy, numofMoves, false);
	}
    }
	
    public static void printArray(int[][] land) {
	String theLand = "";
	for (int i = 0; i < land.length; i ++) {
	    for (int j = 0; j < land[0].length; j ++) {
		theLand = theLand + land[i][j] + " ";
	    }
	    theLand += "\n";
	}
	System.out.println(theLand);
    }
		
	
    public static void main(String[] args) {
	try {
	    File f = new File("ctravel.in");
	    Scanner in = new Scanner(f);
	    String firstLine = in.nextLine();
	    String[] newFirst = firstLine.split(" ");
	    int[][] cowPasture = new int[Integer.parseInt(newFirst[0])][Integer.parseInt(newFirst[1])];
	    String cowLand = "";
	    for (int i = 0; i < Integer.parseInt(newFirst[0]); i ++) {
		cowLand += in.nextLine();
	    }
	    for (int i = 0; i < Integer.parseInt(newFirst[0]); i ++) {
		for (int j = 0; j < Integer.parseInt(newFirst[1]); j ++) {
		    if (cowLand.charAt(i * Integer.parseInt(newFirst[1]) + j) == '.') {
			cowPasture[i][j] = 0;
		    }
		    else {
			cowPasture[i][j] = -1;
		    }
		}
	    }
	    String lastLine = in.nextLine();
	    String[] newLast = lastLine.split(" ");
	    int[] intLast = new int[newLast.length];
	    for (int i = 0; i < newLast.length; i ++) {
		int newPos = Integer.parseInt(newLast[i]);
		intLast[i] = newPos - 1;
	    }
	    //System.out.println(intLast[0]);
	    //System.out.println(intLast[1]);
	    //System.out.println(intLast[2]);
	    //System.out.println(intLast[3]);
	    //System.out.println(Integer.parseInt(newFirst[2]));
	    //printArray(cowPasture);
	    System.out.println(countTravel(cowPasture, intLast[0], intLast[1], intLast[2], intLast[3], Integer.parseInt(newFirst[2]), true) + ",7,Mei,Jackey");
	}
	catch(FileNotFoundException e) {
	    System.out.println("File Not Found");
	}
    }
}
	    
