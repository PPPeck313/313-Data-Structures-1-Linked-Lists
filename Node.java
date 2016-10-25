/** 
 * A node that stores a value of type integer and a reference
 * to another node.
 * 
 * @author Preston Peck 313
 * @version 1.0 July 21, 2016
 */

public class Node {
	private int coefficient;
	private Node next;
	
	Node() {this (0, null);}
	
	public Node(int c, Node n) {
		coefficient = c;
		next = n;
	}
	
	void setCoefficient(int c) {
		coefficient = c;
	}
	
	int getCoefficient() {
		return coefficient;
	}
	
	void setNext(Node n) {
		next = n;
	}
	
	Node getNext() {
		return next;
	}
}
