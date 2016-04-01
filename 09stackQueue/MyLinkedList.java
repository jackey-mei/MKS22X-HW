import java.util.*;
public class MyLinkedList<T> implements Iterable<T> {
    
    public LNode start;
    public LNode end;
    private int size;
    private T thing;

    public Iterator<T> iterator() {
	return new LLIterator();
    }

    public class LLIterator implements Iterator<T> {
	private LNode next;

	public LLIterator() {
	    next = start;
	}

	public boolean hasNext() {
	    return next != null;
	}

	public T next() {
	    if (! hasNext()) {
		throw new NoSuchElementException();
	    }
	    T value = next.getValue();
	    next = next.getNext();
	    return value;
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    public MyLinkedList() {
	start = null;
	end = null;
	size = 0;
    }

    public MyLinkedList(LNode newStart) {
	start = newStart;
	end = newStart;
	size = 1;
    }

    public int size() {
	return size;
    }

    public int indexOf(T someThing) {
	LNode current = start;
	int index = 0;
	while (current.getNext() != null) {
	    if (current.getValue().equals(someThing)) {
		return index;
	    }
	    index ++;
	    current = current.getNext();
	}
	return -1;
    }

    public T remove(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException("index cannot be equal to or greater than size or less than 0");
	}
	LNode current = start;
	LNode removed;
	// sets the start to the second element
	if (index == 0) {
	    removed = start;
	    start = current.getNext();
	    // sets end to null when removing only one item
	    if (removed.getNext() == null) {
		end = null;
	    }
	}
	// removes element at index and redirects
	else {
	    for (int i = index; i > 1; i --) {
		current = current.getNext();
	    }
	    removed = current.getNext();
	    current.setNext(removed.getNext());
	    // sets the end to second to last node when removing last node
	    if (removed.getNext() == null) {
		end = current;
	    }
	}
	size --;
	return removed.getValue();
    }

    public boolean add(T someThing) {
	LNode temp = new LNode(someThing);
	if (start == null && end == null) {
	    start = temp;
	    end = temp;
	    size ++;
	}
	else {
	    end.setNext(temp);
	    end = temp;
	    size ++;
	}
	return true;
    }

    public boolean add(int index, T someThing) {
	LNode temp = new LNode(someThing);
	LNode current = start;
	if (index > size || index < 0) {
	    throw new IndexOutOfBoundsException("index cannot be equal to or greater than size or less than 0");
	}
	// sets empty start to new node
	if (current == null) {
	    start = temp;
	    end = temp;
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
	if (index == size) {
	    add(someThing);
	    return true;
	}
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
	int currSize = size();
	LNode current = start;
	if (currSize > 0) {
	    list += current.getValue();
	    current = current.getNext();
	    currSize --;
	}
	while (currSize > 0) {
	    list += ", " + current.getValue();
	    current = current.getNext();
	    currSize --;
	}
	list += "]";
	return list;    
    }

    public T get(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException("index cannot be equal to or greater than size or less than 0");
	}
	LNode current = start;
	if (index == size - 1) {
	    return end.getValue();
	}
	for (int i = index; i > 0; i --) {
	    current = current.getNext();
	}
	return current.getValue();
    }

    public void set(int index, T newThing) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException("index cannot be equal to or greater than size or less than 0");
	}
	LNode current = start;
	for (int i = index; i > 0; i --) {
	    current = current.getNext();
	}
	current.setValue(newThing);
    }
	
    public class LNode {
	private T thing;
	private LNode next;
	private LNode prev;

	public LNode(T thingValue) {
	    thing = thingValue;
	    next = null;
	    prev = null;
	}

	public LNode(T thingValue, LNode next) {
	    thing = thingValue;
	    this.next = next;
	}

	public T getValue() {
	    return thing;
	}


	public void setValue(T thingValue) {
	    thing = thingValue;
	}

	public LNode getNext() {
	    return next;
	}

	public LNode getPrev() {
	    return prev;
	}

	public void setNext(LNode newNext) {
	    next = newNext;
	}

	public void setPrev(LNode newPrev) {
	    prev = newPrev;
	}
    }

    public static void main(String[] args) {
	MyLinkedList<String> myLL = new MyLinkedList<String>();
	myLL.add("n0thing");
	System.out.println(myLL);
	myLL.add("shroud");
	System.out.println(myLL);
	myLL.add("seangares");
	System.out.println(myLL);
	myLL.set(1, "freakazoid");
	myLL.set(2, "stewie2k");
	System.out.println(myLL);
	myLL.add(3, "hiko");
	System.out.println(myLL);
	myLL.remove(0);
	System.out.println(myLL);
	myLL.add(0, "skadoodle");
	System.out.println(myLL);
	myLL.remove(3);
	System.out.println(myLL);
	MyLinkedList<Character> myLL2 = new MyLinkedList<Character>();
	myLL2.add('(');
	myLL2.add(')');
	System.out.println(myLL2);
    }
}




