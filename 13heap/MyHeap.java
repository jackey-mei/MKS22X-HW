import java.util.*;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>> {
    private T[] heap;
    private boolean isMaxHeap;
    private int size;
    
    public MyHeap() {
	heap = (T[])(new Comparable[10]);
	isMaxHeap = true;
	size = 0;
    }

    public MyHeap(boolean max) {
	heap = (T[])(new Comparable[10]);
	isMaxHeap = max;
	size = 0;
    }

    public MyHeap(T[] array) {
	isMaxHeap = true;
	size = array.length;
	heap = (T[])new Comparable[array.length + 1];
	for (int i = 1; i <= size; i ++) {
	    heap[i] = array[i - 1];
	}
	for (int i = size / 2; i > 0; i --) {
	    pushDown(i);
	}
    }
    
    public MyHeap(T[] array, boolean max) {
	isMaxHeap = max;
	size = array.length;
	heap = (T[])new Comparable[array.length + 1];
	for (int i = 1; i <= size; i ++) {
	    heap[i] = array[i - 1];
	}
	for (int i = size / 2; i > 0; i --) {
	    pushDown(i);
	}
    }
    
    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T temp = heap[1];
	heap[1] = heap[size];
	size --;
	pushDown(1);
	return temp;
    }

    public void add(T value) {
	if (size + 1 == heap.length) {
	    doubleSize();
	}
	size ++;
	heap[size] = value;
	pushUp(size);
    }

    private void doubleSize() {
	T[] temp = (T[])new Comparable[size * 2 + 1];
	for (int i = 1; i <= size; i ++) {
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    private void pushUp(int index) {
	if (index > 1 && compareB(heap[index], heap[index / 2])) {
	    T temp = heap[index / 2];
	    heap[index / 2] = heap[index];
	    heap[index] = temp;
	    pushUp(index / 2);
	}
    }

    private void pushDown(int index) {
	if (index * 2 + 1 <= size) {
	    if (compareB(heap[index * 2], heap[index * 2 + 1])) {
		if (compareB(compareT(heap[index * 2], heap[index * 2 + 1]), heap[index])) {
		    T temp = heap[index * 2];
		    heap[index * 2] = heap[index];
		    heap[index] = temp;
		    pushDown(index * 2);
		}
	    }
	    else {
		if (compareB(compareT(heap[index * 2], heap[index * 2 + 1]), heap[index])) {
		    T temp = heap[index * 2 + 1];
		    heap[index * 2 + 1] = heap[index];
		    heap[index] = temp;
		    pushDown(index * 2 + 1);
		}
	    }
	}
	else {
	    if (index * 2 <= size) {
		if (compareB(heap[index], heap[index * 2])) {
		    T temp = heap[index * 2];
		    heap[index * 2] = heap[index];
		    heap[index] = temp;
		}
	    }
	}
    }

    public T peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return heap[1];
    }
    
    public T compareT(T first, T second) {
	if (isMaxHeap) {
	    if (first.compareTo(second) > 0) {
		return first;
	    }
	    return second;
	}
	else {
	    if (second.compareTo(first) > 0) {
		return second;
	    }
	    return first;
	}
    }

    public boolean compareB(T first, T second) {
	if (isMaxHeap) {
	    return first.compareTo(second) > 0;
	}
	return second.compareTo(first) > 0;
    }

    public String toString() {
	String temp = "";
	for (int i = 1; i <= size; i ++) {
	    temp += heap[i] + " ";
	}
	return temp;
    }

    public static void main(String[] args) {
	MyHeap<Integer> newH = new MyHeap<Integer>();
	newH.add(100);
	newH.add(36);
	newH.add(19);
	newH.add(17);
	newH.add(3);
	newH.add(14);
	newH.add(1);
	newH.add(2);
	newH.add(7);
	System.out.println(newH);
	System.out.println(newH.size);
	newH.delete();
	System.out.println(newH);

    }

    
}
