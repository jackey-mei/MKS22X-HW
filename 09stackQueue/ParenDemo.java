public class ParenDemo<T> extends MyStack<T> {

    public static boolean isMatching(String someString) {
	String s = someString;
        MyStack<Character> someStack = new MyStack<Character>();
	while (s.length() > 0) {
	    if (s.charAt(0) == '(' || s.charAt(0) == '{' || s.charAt(0) == '[' || s.charAt(0) == '<') {
		someStack.push(s.charAt(0));
		s = s.substring(1, s.length());
		//System.out.println("Here");
	    }
	    else if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == '>') {
		if (someStack.size() > 0) {
		    if (someStack.peek() == '(' && s.charAt(0) == ')' || someStack.peek() == '{' && s.charAt(0) == '}' || someStack.peek() == '[' && s.charAt(0) == ']') {
			someStack.pop();
			s = s.substring(1, s.length());
		    }
		    else {
			//System.out.println("Here!");
			return false;
		    }
		}
		else {
		    //System.out.println("Here!!");
		    return false;
		}
	    }
	    //System.out.println(someStack.size());
	}
	//System.out.println("Here!!!");
	return someStack.isEmpty();
    }

    public static void main(String[] args) {
	String input = "()()(([[]]))";
	if (args.length > 0) {
	    input = args[0];
	    System.out.println(isMatching(input)); 
	}
	else {
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }
}
   
