import java.util.*;
public class Quick {

    private static String name() {
	return "7,Mei,Jackey";
    }

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

    public static int quickselect(int[] data, int k) {
	if (k >= data.length) {
	    throw new IllegalArgumentException("k must be less than the length of the array");
	}
	return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int left, int right) {
	if (left == right) {
	    return data[left];
	}
	int index = partition(data, left, right);
	if (index == k) {
	    return data[k];
	}
	else if (index > k) {
	    return quickselectH(data, k, left, index - 1);
	}
	else {
	    return quickselectH(data, k, index + 1, right);
	}
    }

    public static void quickSort(int[] data) {
	quickSortH(data, 0, data.length - 1);
    }
	
    private static void quickSortH(int[] data, int left, int right) {
	if (left >= right) {
	    return;
	}
	int divider = partition(data, left, right);
	quickSortH(data, left, divider - 1);
	quickSortH(data, divider + 1, right);
    }
	

    public static void main(String[] args) {
	int[] examp = {0, -1, 22, 1, 23, 30, 3, 11, 12, 4};
	int[] examp2 = {0, 1, 2, 1, 2, 2, 1, 1, 2, 0};
	System.out.println(partition(examp2, 0, 9));
	System.out.println(Arrays.toString(examp2));
	//{-1, 0, 1, 3, 4, 11, 12, 22, 23, 30}
	//System.out.println(quickselect(examp, 20));
	//quickSort(examp);
	//System.out.println(Arrays.toString(examp));
    }
}
