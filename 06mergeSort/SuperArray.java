public class SuperArray {
    private int[] data;
    private int size;

    public SuperArray(int[] nums) {
	data = nums;
	size = nums.length;
    }
	    
    public SuperArray() {
	data = new int[10];
	size = 0;
    }

    public SuperArray(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException("initialCapacity cannot be less than 0");
	}
	data = new int[initialCapacity];
	size = 0;
    }

    public int size() {
	return size;
    }

    private void add(int n) {
	if (size >= data.length / 2) {
	    grow();
	}
	data[size] = n;
	size += 1;
    }

    public int get(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException("index cannot be less than 0 or greater than the size");
	}
	return data[index];
    }

    public void grow() {
	int[] newSuperArray = new int[data.length * 2];
	for (int i = 0; i < data.length; i ++) {
	    newSuperArray[i] = data[i];
	}
	data = newSuperArray;
    }

    public String toString() {
	String message = "[";
	int i;
	for (i = 0; i < size - 1; i ++) {
	    message += data[i] + ", ";
	}
	if (size == 0) {
	    message += "]";
	}
  	else {
	    message = message + data[i] + "]";
	}
  	return message;
    }

    public String toStringDebug() {
	String message = "[";
	int i;
	for (i = 0; i < size - 1; i ++) {
	    message += data[i] + ", ";
	}
	if (size != 0) {
	    message += data[i];
	    for (i = 0; i < data.length - size; i ++) {
		message += ", X";
	    }
	    message += "]";
	}
	else {
	    for (i = 0; i < data.length; i ++) {
		if (i == 0) {
		    message += "X";
		}
		else {
		    message += ", X";
		}
	    }
	    message += "]";
	}
	return message;
    }

    public void clear() {
	size = 0;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public int set(int index, int element) {
	if (index >= size || index < 0) {
	    throw new IllegalArgumentException("index cannot be less than 0 or greater than the size");
	}
	int oldElement = data[index];
	data[index] = element;
	return oldElement;
    }

    public void add(int index, int element) {
	if (index > size || index < 0) {
	    throw new IllegalArgumentException("index cannot be less than 0 or greater than the size");
	}
 	if (size > data.length / 2) {
	    grow();
	}
	if (index > size) {
	    data[index] = element;
	}
	else {
	    int[] newData = new int[data.length];
	    int i;
	    for (i = 0; i < index; i ++) {
		newData[i] = data[i];
	    }
	    newData[i] = element;
	    while (i < size) {
		newData[i + 1] = data[i];
		i ++;
	    }
	    data = newData;
	}	   
	size += 1;
    }

    public int remove(int index) {
	if (index >= size || index < 0) {
	    throw new IllegalArgumentException("index cannot be less than 0 or greater than the size");
	}
	int oldNumber = data[index];
	int[] newData = new int[data.length];
	int i;
	for (i = 0; i < index; i ++) {
	    newData[i] = data[i];
	}
	while (i < size - 1) {
	    newData[i] = data[i + 1];
	    i ++;
	}
	size -= 1;
	data = newData;
	return oldNumber;
    }

    public int indexOf(int value) {
	for (int i = 0; i < size; i ++) {
	    if (data[i] == value) {
		return i;
	    }
	}
	return -1;
    }
    
    public int[] toArray() {
	int[] newData = new int[size];
	for (int i = 0; i < size; i ++) {
	    newData[i] = data[i];
	}
	return newData;
    }

    public static void main(String[] args) {
	//SuperArray b = new SuperArray(-1);
	SuperArray a = new SuperArray(10);
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(5);
	a.add(6);
	a.add(7);
	a.add(8);
	a.add(9);
	System.out.println(a);
	System.out.println(a.toStringDebug());
	System.out.println(a.indexOf(100));
    }
}
	
	
