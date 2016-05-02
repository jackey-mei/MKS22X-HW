import java.util.*;
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
		return getRight().height() + 1;
	    }
	    else if (getRight() == null) {
		return getLeft().height() + 1;
	    }
	    else {
		return Math.max(getLeft().height(), getRight().height()) + 1;
	    }
		
	}
	
	public void add(T value) {
	    if (data == null) {
		data = value;
	    }
	    else {
		if (value.compareTo(data) < 0) {
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
		ans += "_ ";
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
    
	public void setLeft(Node left) {
	    this.left = left;
	}
    
	public void setRight(Node right) {
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
	if (root != null) {
	    return root.height();
	}
	return -1;
    }

    public void add(T value) {
	if (root != null) {
	    root.add(value);
	}
    }
    
    public String toString() {
	if (root != null) {
	    return root.toString();
	}
	return "";
    }
    
    public boolean contains(T value) {
	if (root != null) {
	    return root.contains(value);
	}
	return false;
    }

    public static void main(String[] args) {
	BSTree<Integer> BSTree1 = new BSTree<Integer>();
	BSTree1.add(7);
	System.out.println(BSTree1);
	BSTree1.add(6);
	System.out.println(BSTree1);
	BSTree1.add(5);
	System.out.println(BSTree1);
	BSTree1.add(4);
	System.out.println(BSTree1);
	BSTree1.add(3);
	System.out.println(BSTree1);
	BSTree1.add(2);
	System.out.println(BSTree1);
	BSTree1.add(1);
	System.out.println(BSTree1);
	System.out.println(BSTree1.contains(8));
	System.out.println(BSTree1.getHeight());
    }
}
