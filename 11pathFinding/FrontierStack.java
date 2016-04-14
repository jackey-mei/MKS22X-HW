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

    public static void main(String[]args){
	FrontierStack<Integer> t = new FrontierStack<Integer>();
	t.add(5);
	t.add(7);
	System.out.println(t.next());
	System.out.println(t.hasNext());
	System.out.println(t.next());
	System.out.println(t.hasNext());
	//System.out.println(t.next());
    }
}
