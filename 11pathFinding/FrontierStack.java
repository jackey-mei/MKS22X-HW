import java.util.*;
public class FrontierStack<T> implements Frontier<T> {
    MyStack<T> fS;
	
    public FrontierStack() {
	fS = new MyStack<T>();
    }
	
    public void add(T element) {
	fS.push(element);
    }
	
    public T next() {
	if (fS.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return fS.pop();
    }
	
    public boolean hasNext() {
	return !fS.isEmpty();
    }
}
