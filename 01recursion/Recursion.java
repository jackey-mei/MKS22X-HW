public class Recursion implements hw01 {
    public Recursion() {
    }
    
    public String name() {
	return "Mei,Jackey";
    }
    
    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("n cannot be less than 0");
	}
	return sqrtH(n, n / 2);
    }

    public double sqrtH(double n, double currentGuess) {
	if (Math.abs(((Math.sqrt(n) - currentGuess) / Math.sqrt(n))) > 0.00000000000001) {
	    return sqrtH(n, (n / currentGuess + currentGuess) / 2);
	}
	else {
	    return currentGuess;
	}
    }
}
	
    
