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
	for (int i = size; i > 0; i --) {
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
	for (int i = size; i > 0; i --) {
	    pushDown(i);
	}
    }
    
    public T delete() {
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
	if (index > 1 && compare(heap[index], heap[index / 2])) {
	    T temp = heap[index / 2];
	    heap[index / 2] = heap[index];
	    heap[index] = temp;
	    pushUp(index / 2);
	}
    }

    private void pushDown(int index) {
	try {
	    if (heap[index * 2 + 1] == null || compare(heap[index * 2], heap[index * 2 + 1])) {
		T temp = heap[index * 2];
		heap[index * 2] = heap[index];
		heap[index] = temp;
		if (index * 2 <= size) {
		    pushDown(index * 2);
		}
	    }
	    else {
		T temp = heap[index * 2 + 1];
		heap[index * 2 + 1] = heap[index];
		heap[index] = temp;
		if (index * 2 + 1 <= size) {
		    pushDown(index * 2 + 1);
		}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    System.out.println("index is out of bounds");
	}
    }

    public T peek() {
	return heap[1];
    }
    
    public boolean compare(T first, T second) {
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
	//return Arrays.toString(heap);
    }
    
}
