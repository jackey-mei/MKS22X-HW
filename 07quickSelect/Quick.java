import java.util.*;
public class Quick {
    private static int partition(int[] data, int left, int right) {
	//choose a random partition element at a location from left to right inclusive.
        //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
        //smaller elements on the left side of the partition, larger on the right side
        //return the index of the partition element. 
        //this allows your quickselect method to decide where to go next.
	
	int randSel = left + new Random().nextInt(right - left + 1);
	swap(data, right, randSel);
	int tempL = left;
	int tempR = right - 1;
	//System.out.println(Arrays.toString(data));
	while (tempL != tempR) {
	    if (data[tempL] > data[right]) {
		swap(data, tempL, tempR);
		tempR --;
	    }
	    else {
		tempL ++;
	    }
	    //System.out.println(Arrays.toString(data));
	}
	if (data[tempL] > data[right]) {
	    swap(data, tempL, right);
	    //System.out.println(Arrays.toString(data));
	    return tempL;
	}
	else {
	    swap(data, tempL + 1, right);
	    //System.out.println(Arrays.toString(data));
	    return tempL + 1;
	}
    }
 
    private static void swap(int[] data, int x, int y) {
	int tmp = data[x];
	data[x] = data[y];
	data[y] = tmp;
    }
}
