import java.util.*;
public class MyQueue<T> extends MyLinkedList<T> {

    private MyLinkedList<T> LL;

    public MyQueue() {
	LL = new MyLinkedList<T>();
    }

    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item) {
	LL.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
	if (LL.size() > 0) {
	    return LL.remove(0);
	}
	throw new NoSuchElementException();
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	if (LL.size() > 0) {
	    return LL.get(0);
	}
	throw new NoSuchElementException();
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size() {
	return LL.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty() {
	return LL.size() == 0;
    }

    public static void main(String[] args) {
	MyQueue<String> newQ = new MyQueue<String>();
	newQ.enqueue("hiko");
	newQ.enqueue("adren");
	newQ.enqueue("nitr0");
	newQ.enqueue("elige");
	newQ.enqueue("s1mple");
	System.out.println(newQ.size());
	System.out.println(newQ);
	System.out.println(newQ.dequeue());
	System.out.println(newQ.dequeue());
	System.out.println(newQ.peek());
	newQ.enqueue("koosta");
	System.out.println(newQ);
    }

}
