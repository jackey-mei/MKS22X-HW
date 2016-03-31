import java.util.*;
public class MyStack<T> {

    private MyLinkedList<T> LL;

    public MyStack() {
	LL = new MyLinkedList<T>();
    }
    
    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item) {
	LL.add(item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop() {
	if (LL.size() > 0) {
	    return LL.remove(LL.size() - 1);
	}
	throw new NoSuchElementException();
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	if (LL.size() > 0) {
	    return LL.get(LL.size() - 1);
	}
	throw new NoSuchElementException();
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size() {
	return LL.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty() {
	return LL.size() == 0;
    }

    public String toString() {
	return LL.toString();
    }

    public static void main(String[] args) {
	MyStack<String> newS = new MyStack<String>();
	newS.push("hiko");
	newS.push("n0thing");
	newS.push("dazed");
	System.out.println(newS);
	newS.pop();
	System.out.println(newS);
    }
}
