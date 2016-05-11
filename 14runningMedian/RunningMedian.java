import java.util.*;
public class RunningMedian {
    MyHeap<Integer> minHeap;
    MyHeap<Integer> maxHeap;
    
    public RunningMedian() {
	//minHeap is the bigger group
	//maxHeap is the smaller group
	minHeap = new MyHeap<Integer>(false);
	maxHeap = new MyHeap<Integer>(true);
    }

    public double getMedian() {
	if (minHeap.size() == 0 && maxHeap.size() == 0) {
	    throw new NoSuchElementException();
	}
	else {
	    if (minHeap.size() == maxHeap.size()) {
		return (minHeap.peek() + maxHeap.peek()) / 2.0;
	    }
	    else if (minHeap.size() > maxHeap.size()) {
		return minHeap.peek();
	    }
	    else {
		return maxHeap.peek();
	    }
		
	}
    }

    public void add(Integer x) {
	//add to the "SmallValue" heap if  x < median, 
	//add to the "BigValue" heap otherwise. 
	//balance the two heaps so that their size differ by no more than 1.
	if (minHeap.size() == 0 && maxHeap.size() == 0) {
	    maxHeap.add(x);
	}
	else if (x < getMedian()) {
	    maxHeap.add(x);
	}
	else {
	    minHeap.add(x);
	}
	if (minHeap.size() - maxHeap.size() > 1) {
	    maxHeap.add(minHeap.delete());
	}
	else if (maxHeap.size() - minHeap.size() > 1) {
	    minHeap.add(maxHeap.delete());
	}
    }

    public static void main(String[] args) {
	RunningMedian rm = new RunningMedian();
	rm.add(1);
	rm.add(2);
	rm.add(3);
	rm.add(4);
        rm.add(5);
	System.out.println(rm.getMedian());
	rm.add(6);
	System.out.println(rm.getMedian());
    }
}
	    
	    
