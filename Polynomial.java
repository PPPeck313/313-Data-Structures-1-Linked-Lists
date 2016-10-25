/** 
 * A linked list that stores the coefficients of a polynomial.
 * 
 * @author Preston Peck 313
 * @version 1.0 July 21, 2016
 */

public class Polynomial {
	private Node head, tail, traveler;//instead of instances so searches don't reset from head every time
	private int length;
	
	/**
	 * Default constructor 
	 * @param head the beginning of the list
	 * @param tail the end of the list
	 * @param traveler used to traverse and read the list
	 * @param length the total number of nodes in the list
	 */
	Polynomial() {
		head = null;
		tail = null;
		traveler = null;
		length = 0;
	}
	
	public void append(int c) {
		Node n = new Node(c, null);
		if (length == 0) {
			head = n;
			traveler = head;
		}
		else {
			tail.setNext(n);
		}
		tail = n;
		length++;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void makeEmpty() {
		head = null; 
		tail = null;
		traveler = null;
		length = 0;
	}
	
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}
	
	public Node getTraveler() {
		return traveler;
	}
	
	public int getLength() {
		return length;
	}
	/**
	 * Moves traveler a given number of nodes
	 * @param n number of nodes traveler will move
	 */
	public void travel(int n) {
		for (int i = 0; i < n; i++) {
			if (traveler == tail) {
				System.out.println("Traveler cannot exceed tail. Please reset traveler.");
			}
			else {
				traveler = traveler.getNext();
			}
		}
	}
	/**
	 * Moves traveler back to the start of the list
	 */
	public void reset() {
		traveler = head;
	}
	/**
	 * Adds similarly positioned nodes across two Polynomials
	 * @param p2 Polynomial being added to the Polynomial it is called on
	 * @return p3 a Polynomial sum
	 */
	public Polynomial add(Polynomial p2) {
		Polynomial p3 = new Polynomial();
		this.reset();
		p2.reset();
		int counter1 = 0;
		int counter2 = 0;
		while (counter1 != length || counter2 != p2.getLength()) {
			int c1 = 0;
			int c2 = 0;
			if (counter1 < length) {
				if (counter1 != 0) {
					this.travel(1);
				}
				c1 = traveler.getCoefficient();
				counter1++;
			}
			if (counter2 < p2.getLength()) {
				if (counter2 != 0) {
					p2.travel(1);
				}
				c2 = p2.getTraveler().getCoefficient();
				counter2++;
			}
			p3.append(c1 + c2);		
		}
		return p3;
	}
	/**
	 * Multiplies two Polynomials by cycling through the nodes of one, multiplying,
	 * and resetting before cycling through a node on the other and repeating until
	 * all possible multiplications have been exhausted and added together.
	 * @param p2 Polynomial being multiplied with the Polynomial it is called on
	 * @return p3 a Polynomial product
	 */
	public Polynomial multiply(Polynomial p2) {
		Polynomial pTemp = new Polynomial();
		Polynomial p3 = new Polynomial();
		int counter = 0;
		p2.reset();
		for(int i = 0; i < p2.getLength(); i++) {
			if (i != 0) {
				p2.travel(1);
			}
			for (int j = 0; j < counter; j++) {
				pTemp.append(0);
			}
			this.reset();
			for(int j = 0; j < length; j++) {
				if (j != 0) {
					this.travel(1);
				}
				pTemp.append(traveler.getCoefficient() * p2.getTraveler().getCoefficient());
			}
			p3 = p3.add(pTemp);
			pTemp.makeEmpty();
			counter++;
		}
		return p3;
	}
	
	public void display() {
		this.reset();
		int counter = 0;
		for (int i = 0; i < length; i++) {
			if (counter == 0) {
				System.out.print(traveler.getCoefficient());
			}
			else {
				this.travel(1);
				String str1 = " + " + traveler.getCoefficient() + "x";
				String str2 = Integer.toString(counter);
				str1 = str1.replaceAll(" \\+ -", " - ");
			    str2 = str2.replaceAll("0", "⁰");
			    str2 = str2.replaceAll("1", "¹");
			    str2 = str2.replaceAll("2", "²");
			    str2 = str2.replaceAll("3", "³");
			    str2 = str2.replaceAll("4", "⁴");
			    str2 = str2.replaceAll("5", "⁵");
			    str2 = str2.replaceAll("6", "⁶");
			    str2 = str2.replaceAll("7", "⁷");
			    str2 = str2.replaceAll("8", "⁸");
			    str2 = str2.replaceAll("9", "⁹");
			    System.out.print(str1 + str2);
			}
			counter++;
		}
		System.out.println();
	}
}