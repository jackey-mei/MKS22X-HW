import java.util.Arrays;
public class Sorts {
    
    public static String name() {
	return "7,Mei,Jackey";
    }

    public static void mergesort(int[] arr) {
	int[] sortedArr = mergeSortH(arr);
	for (int i = 0; i < arr.length; i ++) {
	    arr[i] = sortedArr[i];
	}
    }

    private static int[] mergeSortH(int[] arr) {
	if (arr.length == 1) {
	    return arr;
	}
	int middleIndex = arr.length / 2;
	int[] firstHalf = new int[arr.length / 2];
	int[] secondHalf = new int[arr.length - arr.length / 2];
	for (int i = 0; i < arr.length / 2; i ++) {
	    firstHalf[i] = arr[i];
	}
	for (int i = arr.length / 2; i < arr.length; i ++) {
	    secondHalf[i - middleIndex] = arr[i];
	}
	return merge(mergeSortH(firstHalf), mergeSortH(secondHalf));
    }
	


    public static int[] remove(int index, int[] arr) {
	if (index >= arr.length || index < 0) {
	    throw new IllegalArgumentException("index cannot be less than 0 or greater than the size");
	}
	int[] newArr = new int[arr.length - 1];
	int i;
	for (i = 0; i < index; i ++) {
	    newArr[i] = arr[i];
	}
	while (i < arr.length - 1) {
	    newArr[i] = arr[i + 1];
	    i ++;
	}
	return newArr;
    }
   
    public static int[] merge(int[] firstArr, int[] secondArr) {
	int[] newArr = new int[firstArr.length + secondArr.length];
	//System.out.println(firstArr.length + secondArr.length);
	int j = 0;
	for (int i = 0; i < newArr.length; i ++) {
	    if (firstArr.length > 0 && secondArr.length > 0) {
		if (firstArr[0] > secondArr[0]) {
		    newArr[i] = secondArr[0];
		    secondArr = remove(0, secondArr);
		    //System.out.println(Arrays.toString(secondArr));
		}
		else {
		    newArr[i] = firstArr[0];
		    firstArr = remove(0, firstArr);
		    //System.out.println(Arrays.toString(firstArr));
		}
	    }
	    else {
		if (firstArr.length == 0) {
		    //System.out.println(Arrays.toString(secondArr));
		    newArr[i] = secondArr[j];
		    j ++;
		}
		else {
		    newArr[i] = firstArr[j];
		    j ++;
		}
	    }
	}
	return newArr;
    }

    public static void main(String[] args) {
	int[] bob = {41, 11, 0, 123, 55, 22, 1, 2, 3, 2};
	mergesort(bob);
	System.out.println(Arrays.toString(bob));
    }
}
		    
	    
	    
	
