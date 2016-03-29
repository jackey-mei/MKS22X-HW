public class ParenDemo {

    public static boolean isMatching(String s) {
	String opening = "";
	String closing = "";
	for (int i = 0; i < s.length(); i ++) {
	    if (s.substring(i, i + 1).equals("[") || s.substring(i, i + 1).equals("(") || s.substring(i, i + 1).equals("{")) {
		opening += s.substring(i, i + 1);
	    }
	    else if (s.substring(i, i + 1).equals("]") || s.substring(i, i + 1).equals(")") || s.substring(i, i + 1).equals("}")) {
		closing += s.substring(i, i + 1);
	    }
	}
	System.out.println(opening);
	System.out.println(closing);
	if (opening.length() == closing.length()) {
	    while (opening.length() > 0) {
		if (opening.charAt(opening.length() - 1) == closing.charAt(0)) {
		    opening = opening.substring(0, opening.length() - 1);
		    closing = closing.substring(1, closing.length());
		}
		else {
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    public static void main(String[] args) {
	String input = "()()(([[]]))";
	System.out.println(isMatching(input));
    }
}
   
