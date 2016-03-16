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

    public boolean add(int value) {
	LNode temp = new LNode(value);
	LNode current = start;
	// from the start LNode, go to the end of the list
	if (current == null) {
	    start = temp;
	    size ++;
	    return true;
	}
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	// last node becomes the new next
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
	    throw new IllegalArgumentException("index cannot be bigger than size or less than 0");
	}
	LNode current = start;
	for (int i = index; i > 0; i --) {
	    current = current.getNext();
	}
	return current.getValue();
    }

    public void set(int index, int newValue) {
	if (index >= size || index < 0) {
	    throw new IllegalArgumentException("index cannot be bigger than sizeor less than 0");
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
	//myLL.set(3, 666);
	System.out.println(myLL);
	System.out.println(myLL.get(2));
    }
}




