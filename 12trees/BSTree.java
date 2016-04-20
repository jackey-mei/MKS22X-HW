public class BSTree<T extends Comparable<T>> {
    private class Node {
	T data;
	Node left;
	Node right;

	public Node() {
	    this.left = null;
	    this.right = null;
	    data = null;
	}

	public int height() {
	    return 0;
	}
	
	public void add(T value) {
	}
	
	public String toString() {
	    return "";
	}
	
	public boolean contains(T value) {
	    return false;
	}

	public T getData() {
	    return data;
	}

	public Node getLeft() {
	    return left;
	}
    
	public Node getRight() {
	    return right;
	}

	public void setData(T data) {
	    this.data = data;
	}
    
	public Node setLeft(Node left) {
	    this.left = left;
	}
    
	public Node setRight(Node right) {
	    this.right = right;
	}
    }

    private Node root;

    public BSTree() {
	root = new Node();
    }

    public BSTree(Node root) {
	this.root = root;
    }

    public int getHeight() {
	if (root.getData() != null) {
	    return root.height();
	}
	return -1;
    }

    public void add(T value) {
	if (root.getData() != null) {
	    
    }
    
    public String toString() {
	return "";
    }
    
    public boolean contains(T value) {
	return false;
    }
}
