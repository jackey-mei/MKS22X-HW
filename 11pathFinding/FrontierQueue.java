import java.util.*;
public class FrontierQueue<T> implements Frontier<T> {
    private ArrayDeque<T> frontierQueue;

    public void add(T element) {
	FrontierQueue.add(element);
    }

    public T next() {
	if (frontierQueue.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return FrontierQueue.remove();
    }

    public boolean hasNext() {
	return !frontierQueue.size() == 0;
    }
}

