public class Node {
    Coordinate location;
    Node last;

    public Node() {
	location = new Coordinate();
	last = null;
    }
    
    public Node(Coordinate location) {
	this.location = location;
	last = null;
    }
    
    public Node(Node last) {
	location = new Coordinate();
	this.last = last;
    }
    
    public Node(Coordinate location, Node last) {
	this.location = location;
	this.last = last;
    }

    public Node getLast() {
	return last;
    }
    
    public Coordinate getCoordinate() {
	return location;
    }
}
