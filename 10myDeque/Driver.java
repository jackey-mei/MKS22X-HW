import java.util.*;
public class Driver{
    
    public static void main(String[] args) {
	
	MyDeque<Integer> a = new MyDeque<Integer>();
	
	Deque<Integer> b = new ArrayDeque<Integer>();
	
	Random r = new Random();
	
	for (int i = 0; i < 10000; i ++){
	    int c;
	    c = r.nextInt(40);

	    a.addFirst(c);
	    b.addFirst(c);
	}
	
	//System.out.println(a == b); //assuming that there is a toString for MyDeque
	//System.out.println(b); //assuming that there is a toString for Deque
	int counter = 0;
	while (counter < 10000 && a.size != 0 && b.size() != 0){
	    int op = r.nextInt(4);
	    if (op == 0) {
		if (a.removeFirst() != b.removeFirst()) {
		    System.out.println("removeFirst Error");
		    return;
		}
	    }
	    else if (op == 1) {
		if (a.removeLast() != b.removeLast()) {
		    System.out.println("removeLast Error");
		    return;
		}
	    }
	    else if (op == 2) {
		if (a.getFirst() != b.getFirst()) {
		    System.out.println("getFirst Error");
		    return;
		}
	    }
	    else if (op == 3) {
		if (a.getLast() != b.getLast()) {
		    System.out.println("getLast Error");
		    return;
		}
	    }
	    counter ++;
	}

	System.out.println("Success!");
    }
}
