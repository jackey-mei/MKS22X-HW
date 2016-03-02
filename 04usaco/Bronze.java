import java.util.*;
import java.io.*;
public class Bronze {
    public static void stomp(int[][] land, int R_s, int C_s, int D_s) {
	R_s --;
	C_s --;
	int[][] cowStomp = new int[3][3];
	int highestLand = 0;
	for (int i = 0; i < 3; i ++) {
	    for (int j = 0; j < 3; j ++) {
		if (i == 0 && j == 0) {
		    highestLand = land[R_s + i][C_s + j];
		}
		if (land[R_s + i][C_s + j] > highestLand) {
		    highestLand = land[R_s + i][C_s + j];
		}
	    }
	}
	highestLand -= D_s;
	for (int i = 0; i < 3; i ++) {
	    for (int j = 0; j < 3; j ++) {
		if (land[R_s + i][C_s + j] > highestLand) {
		    land[R_s + i][C_s + j] = highestLand;
		}
	    }
	}
    }

    public static int calcFinalVol(int[][] land, int lakeHeight) {
	int depth = 0;
	int[][] newLake = new int[land.length][land[0].length];
	for (int i = 0; i < newLake.length; i ++) {
	    for (int j = 0; j < newLake[0].length; j ++) {
		if (lakeHeight > land[i][j]) {
		    newLake[i][j] = lakeHeight - land[i][j];
		}
		else {
		    newLake[i][j] = 0;
		}
	    }
	}
	for (int i = 0; i < newLake.length; i ++) {
	    for (int j = 0; j < newLake[0].length; j ++) {
		depth += newLake[i][j];
	    }
	}
	return depth * 72 * 72;
		
    }

    public static void main(String[] args) {
	try {
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    String firstLine = in.nextLine();
	    String[] newFirst = firstLine.split(" ");
	    int numRows = Integer.parseInt(newFirst[0]);
	    int numCols = Integer.parseInt(newFirst[1]);
	    int numElev = Integer.parseInt(newFirst[2]);
	    int numIns = Integer.parseInt(newFirst[3]);
	    int[][] land = new int[numRows][numCols];
	    for (int i = 0; i < numRows; i ++) {
		for (int j = 0; j < numCols; j ++) {
		    land[i][j] = in.nextInt();
		}
	    }
	    int[][] instructions = new int[numIns][3];
	    for (int i = 0; i < numIns; i ++) {
		for (int j = 0; j < 3; j ++) {
		    instructions[i][j] = in.nextInt();
		}
	    }
	    for (int i = 0; i < numIns; i ++) {
		stomp(land, instructions[i][0], instructions[i][1], instructions[i][2]);
	    }
	    System.out.println(calcFinalVol(land, numElev) + ",7,Mei,Jackey");
		
		
	}
	catch (FileNotFoundException e) {
	    System.out.println("makelake.in was not found");
	}
    }
}
