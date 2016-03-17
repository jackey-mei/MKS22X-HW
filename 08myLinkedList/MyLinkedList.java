public class MyLinkedList {

    private LNode start;
    private int size;

    public MyLinkedList() {
	start = null;
	size = 0;
    }

    public MyLinkedList(LNode newStart) {
	start = newStart;
	size = 1;
    }

    public int size() {
	return size;
    }

    public int indexOf(int value) {
	LNode current = start;
	int index = 0;
	while (current.getNext() != null) {
	    if (current.getValue() == value) {
		return index;
	    }
	    index ++;
	    current = current.getNext();
	}
	return -1;
    }

    public int remove(int index) {
	if (index >= size || index < 0) {
	    throw new IllegalArgumentException("index cannot be equal to or greater than size or less than 0");
	}
	LNode current = start;
	LNode removed;
	// sets the start to the second element
	if (index == 0) {
	    removed = start;
	    start = current.getNext();
	}
	// removes element at index and redirects
	else {
	    for (int i = index; i > 1; i --) {
		current = current.getNext();
	    }
	    removed = current.getNext();
	    current.setNext(removed.getNext());
	}
	size --;
	return removed.getValue();
    }

    public boolean add(int value) {
	LNode temp = new LNode(value);
	LNode current = start;
	// sets empty start to new node
	if (current == null) {
	    start = temp;
	    size ++;
	    return true;
	}
	// from the start LNode, go to the end of the list
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	// last node becomes the new node
	current.setNext(temp);
	size ++;
	return true;
    }

    public boolean add(int index, int value) {
	LNode temp = new LNode(value);
	LNode current = start;
	if (index > size || index < 0) {
	    throw new IllegalArgumentException("index cannot be equal to or greater than size or less than 0");
	}
	// sets empty start to new node
	if (current == null) {
	    start = temp;
	    size ++;
	    return true;
	}
	// adds new node at index 0
	if (index == 0) {
	    temp.setNext(current);
	    start = temp;
	    size ++;
	    return true;
	}
	// accounts for cases where index is not 0
	// new node sets next to node at index if that node exists
	// node at index - 1 sets next to new node
	for (int i = index; i > 1; i --) {
	    current = current.getNext();
	}
	temp.setNext(current.getNext());
	current.setNext(temp);
	size ++;
	return true;
    }

    public String toString() {
	String list = "[";
	int currSize = size;
	LNode current = start;
	if (currSize > 0) {
	    list += String.valueOf(current.getValue());
	    current = current.getNext();
	    currSize --;
	}
	while (currSize > 0) {
	    list += ", " + String.valueOf(current.getValue());
	    current = current.getNext();
	    currSize --;
	}
	list += "]";
	return list;    
    }

    public int get(int index) {
	if (index >= size || index < 0) {
	    throw new IllegalArgumentException("index cannot be equal to or greater than size or less than 0");
	}
	LNode current = start;
	for (int i = index; i > 0; i --) {
	    current = current.getNext();
	}
	return current.getValue();
    }

    public void set(int index, int newValue) {
	if (index >= size || index < 0) {
	    throw new IllegalArgumentException("index cannot be equal to or greater than size or less than 0");
	}
	LNode current = start;
	for (int i = index; i > 0; i --) {
	    current = current.getNext();
	}
	current.setValue(newValue);
    }
	
    public class LNode {
	private int value;
	private LNode next;

	public LNode(int dataValue) {
	    value = dataValue;
	    next = null;
	}

	public LNode(int dataValue, LNode next) {
	    value = dataValue;
	    this.next = next;
	}

	public int getValue() {
	    return value;
	}

	public void setValue(int value) {
	    this.value = value;
	}

	public LNode getNext() {
	    return next;
	}

	public void setNext(LNode newNext) {
	    next = newNext;
	}
    }

    public static void main(String[] args) {
	MyLinkedList myLL = new MyLinkedList();
	myLL.add(3);
	myLL.add(5);
	myLL.add(7);
	myLL.set(1, 50);
	myLL.set(2, 25);
	System.out.println(myLL);
	myLL.add(3, 100);
	//System.out.println(myLL.remove(0));
	//myLL.remove(0);
	//System.out.println(myLL);
	
    }
}




