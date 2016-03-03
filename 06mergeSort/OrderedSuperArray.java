public class OrderedSuperArray extends SuperArray {
    
    public OrderedSuperArray() {
	super();
    }

    public OrderedSuperArray(int capacity) {
	super(capacity);
    }

    public OrderedSuperArray(int[] ary) {
	super(ary.length);
	for (int i = 0; i < ary.length; i ++) {
	    add(ary[i]);
	}
    }
    
    private int findIndex(int n) {
	int i;
	for (i = 0; i < super.size(); i ++) {
	    if (get(i) > n) {
		return i;
	    }
	}
	return i;
    }
    
    public void add(int n) {
	super.add(findIndex(n), n);
    }

    public int set(int index, int element) {
	if (index >= size() || index < 0) {
	    throw new IllegalArgumentException("index cannot be less than 0 or greater than the size");
	}
	int oldElement = get(index);
	remove(index);
	add(element);
	return oldElement;
    }

    public void add(int index, int element) {
	throw new UnsupportedOperationException("You cannot use a function to manually add elements in the OrderedSuperArray class");
    }

    public int indexOf(int value) {
	int placeholderIndex;
	int currentIndex = size() / 2;
	int oldIndex = size();
	int correctIndex = -1;
	boolean firstCorrect = true;
	while (currentIndex != 0 && currentIndex != size() - 1) {
	    if (get(currentIndex) < value) {
		currentIndex = (currentIndex + oldIndex) / 2;
		if (get(currentIndex) == value) {
		    if (currentIndex < correctIndex || firstCorrect == true) {
			correctIndex = currentIndex;
			firstCorrect = false;
		    }
		}
		if (currentIndex + 1 == oldIndex) {
		    if (get(currentIndex) == value) {
			if (currentIndex < correctIndex || firstCorrect == true) {
			    correctIndex = currentIndex;
			    firstCorrect = false;
			}
			else {
			    return correctIndex;
			}
		    }
		    else if (oldIndex != size() && get(oldIndex) == value) {
			if (oldIndex < correctIndex || firstCorrect == true) {
			    correctIndex = oldIndex;
			    firstCorrect = false;
			}
			else {
			    return correctIndex;
			}
		    }
		    else {
			return correctIndex;
		    }
		}
	    }
	    else if (get(currentIndex) >= value) {
		placeholderIndex = currentIndex;
		currentIndex = currentIndex / 2;
		oldIndex = placeholderIndex;
		if (get(currentIndex) == value) {
		    if (currentIndex < correctIndex || firstCorrect == true) {
			correctIndex = currentIndex;
			firstCorrect = false;
		    }
		}
		if (oldIndex == currentIndex) {
		    if (get(currentIndex) == value) {
			if (currentIndex < correctIndex || firstCorrect == true) {
			    correctIndex = currentIndex;
			    firstCorrect = false;
			}
			else {
			    return correctIndex;
			}
		    }
		    else {
			return correctIndex;
		    }
		}
	    }
	}
	return correctIndex;
    }
			
		
    public static void main(String[] args) {
	OrderedSuperArray a = new OrderedSuperArray();
	OrderedSuperArray b = new OrderedSuperArray(10);
	System.out.println(a);
	System.out.println(b);
	a.add(1);
	a.add(2);
	a.add(4);
	a.add(7);
	a.add(2);
	System.out.println(a);
	System.out.println(a);
	System.out.println(a.indexOf(-1));
	System.out.println(a.indexOf(1));
	System.out.println(a.indexOf(2));
	System.out.println(a.indexOf(3));
	System.out.println(a.indexOf(4));
	System.out.println(a.indexOf(7));
	System.out.println(a.indexOf(9));
	System.out.println(a.indexOf(10));
	System.out.println(a.indexOf(11));
	System.out.println(a.indexOf(22));
	System.out.println(a.indexOf(1001));
    }
}
	
	
