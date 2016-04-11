import java.util.*;
public class FrontierStack<T> implements Frontier<T> {
    Stack<T> frontierStack = new Stack<T>();

    public void add(T element) {
	frontierStack.push(element);
    }

    public T next() {
	if (frontierStack.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return frontierStack.pop();
    }

    public boolean hasNext() {
	return !frontierStack.isEmpty();
    }
}
