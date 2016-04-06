import java.util.*;
public class MyDeque<T> {
    T[] data;
    int start;
    int end;
    int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (T[]) new Object[10];
	start = 0;
	end = 0;
	size = 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
	T[] newData = (T[]) new Object[data.length * 2];
	if (end > start) {
	    for (int i = 0; i < data.length; i ++) {
		newData[i] = data[i];
	    }
	}
	else {
	    for (int i = start; i < data.length; i ++) {
		newData[i - start] = data[i];
	    }
	    for (int i = 0; i <= end; i ++) {
		newData[data.length - start + i] = data[i];
	    }
	}
	start = 0;
	end = data.length - 1;
	data = newData;
    }		

    public void addFirst(T value) {
	if (size == 0) {
	    data[start] = value;
	    size ++;
	}
	else {
	    if (start > 0 && end != start - 1) {
		data[start - 1] = value;
		start --;
		size ++;
	    }
	    else if (start == 0 && end != data.length - 1) {
		data[data.length - 1] = value;
		start = data.length - 1;
		size ++;
	    }
	    else {
		grow();
		addFirst(value);
	    }
	}
	    
    }

    public void addLast(T value) {
	if (size == 0) {
	    data[end] = value;
	    size ++;
	}
	else {
	    if (end != data.length - 1 && end != start - 1) {
		data[end + 1] = value;
		end ++;
		size ++;
	    }
	    else if (end == data.length - 1 && start != 0) {
		data[0] = value;
		end = 0;
		size ++;
	    }
	    else {
		grow();
		addLast(value);
	    }
	}
    }

    public T removeFirst() {
	if (size != 0 && size != 1) {
	    size --;
	    if (start != data.length - 1) {
		start ++;
		return data[start - 1];
	    }
	    else {
		start = 0;
		return data[data.length - 1];
	    }
	}
	else if (size == 0) {
	    throw new NullPointerException("Nothing is in the array");
	}
	else {
	    size --;
	    return data[start];
	}
	    
    }

    public T removeLast() {
	if (size != 0 && size != 1) {
	    size --;
	    if (end != 0) {
		end --;
		return data[end + 1];
	    }
	    else {
		end = data.length - 1;
		return data[0];
	    }
	}
	else if (size == 0) {
	    throw new NullPointerException("Nothing is in the array");
	}
	else {
	    size --;
	    return data[end];
	}
    }

    public T getFirst() {
	return data[start];
    }

    public T getLast() {
	return data[end];
    }

    public int size() {
	return size;
    }

    public String toString() {
	System.out.println(start);
	System.out.println(end);
	String s = "[";
	for (int i = 0; i < data.length; i ++) {
	    s = s + data[i] + ", ";
	}
	s = s.substring(0, s.length() - 2);
	s += "]";
	return s;
    }

    public static void main(String[] args) {
	MyDeque<String> newD = new MyDeque<String>();
	newD.addFirst("hiko");
	newD.addFirst("n0thing");
	newD.addFirst("seangares");
	newD.addFirst("uber");
	newD.addFirst("sil3ntem");
	newD.addFirst("freakazoid");
	newD.addFirst("tarik");
	newD.addFirst("skadoodle");
	newD.addFirst("jdm64");
	newD.addFirst("hazed");
	newD.addFirst("s1mple");
	System.out.println(newD);
	
	MyDeque<String> newD2 = new MyDeque<String>();
	newD2.addLast("hiko");
	newD2.addLast("n0thing");
	newD2.addLast("seangares");
	newD2.addLast("uber");
	newD2.addLast("sil3ntem");
	newD2.addLast("freakazoid");
	newD2.addLast("tarik");
	newD2.addLast("skadoodle");
	newD2.addLast("jdm64");
	newD2.addLast("hazed");
	newD2.addLast("s1mple");
	System.out.println(newD2);
	
	MyDeque<String> newD3 = new MyDeque<String>();
	newD3.addFirst("hiko");
	newD3.addLast("n0thing");
	newD3.addFirst("seangares");
	newD3.addLast("uber");
	newD3.addFirst("sil3ntem");
	newD3.addLast("freakazoid");
	newD3.addFirst("tarik");
	newD3.addLast("skadoodle");
	newD3.addFirst("jdm64");
	newD3.addLast("hazed");
	newD3.addFirst("s1mple");
	System.out.println(newD3);

	newD3.removeFirst();
	System.out.println(newD3);

	newD3.removeFirst();
	System.out.println(newD3);
	
    }
}
    
