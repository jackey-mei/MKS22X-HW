public class MyLinkedList {

    private LNode start;
    private LNode next;
    private int size;

    public class LNode {
	private int value;
	private LNode next;

	public LNode(int x) {
	    value = x;
	}

	public int getCurrent() {
	    return value;
	}

	public void setCurrent(int value) {
	    this.value = value;
	}

	public int getNext() {
	    return next.getCurrent();
	}

	public void setNext(int value) {
	    next.setCurrent(value);
	}
    }

    public boolean add(int value) {




