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

	public Node(T value) {
	    this.left = null;
	    this.right = null;
	    data = value;
	}

	public int height() {
	    if (getLeft() == null && getRight() == null) {
		return 1;
	    }
	    else if (getLeft() == null) {
		return getRight.height() + 1;
	    }
	    else if (getRight() == null) {
		return getLeft().height() + 1;
	    }
	    else {
		return Math.max(getLeft().height(), getRight().height()) + 1;
	    }
		
	}
	
	public void add(T value) {
	    if (value < getData()) {
		if (getLeft() == null) {
		    setLeft(new Node(value));
		}
		else {
		    getLeft().add(value);
		}
	    }
	    else {
		if (getRight() == null) {
		    setRight(new Node(value));
		}
		else {
		    getRight().add(value);
		}
	    }
	}
	
	public String toString() {
	    String ans = getData() + " ";
	    if (getLeft() != null) {
		ans += getLeft().toString();
	    }
	    else {
		ans += "_ ";
	    }
	    if (getRight() != null) {
		ans += getRight().toString();
	    }
	    else {
		ans + "_ ";
	    }
	    return ans;
	    
	}
	
	public boolean contains(T value) {
	    if (getLeft() != null) {
		if (getData() != value) {
		    return getLeft().contains(value);
		}
	        else {
		    return true;
		}
	    }
	    else if (getRight() != null) {
		if (getData() != value) {
		    return getRight().contains(value);
		}
		else {
		    return true;
		}
	    }
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
