import java.util.*;
public class FrontierQueue<T> implements Frontier<T> {
    MyQueue<T> fS;
	
    public FrontierQueue() {
	fS = new MyQueue<T>();
    }
	
    public void add(T element) {
	fS.enqueue(element);
    }
	
    public T next() {
	if (fS.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return fS.dequeue();
    }
	
    public boolean hasNext() {
	return (!fS.isEmpty());
    }
}
