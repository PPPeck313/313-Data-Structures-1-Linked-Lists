import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Takes 2 linked lists of type Polynomial at a time from a provided
 * input file. It then adds and multiplies the two and prints out
 * the results for each.
 *
 * @author Preston Peck 313
 * @version 1.0 July 21, 2016
 */

public class Project1 {
	public static void main(String[] args) {
		if (args.length == 0) System.out.println ("No file specified");
		else {
			Polynomial p1 = new Polynomial(); 
			Polynomial p2 = new Polynomial();
			FileReader theFile;
			BufferedReader inFile;
			String oneLine;
			try {
				theFile = new FileReader(args[0]);
				inFile = new BufferedReader(theFile);
				while ((oneLine = inFile.readLine()) != null) {
					String numbers[] = oneLine.split(",");
					for(int i=0; i < numbers.length; i++) {
						p1.append(Integer.parseInt(numbers[i]));
					}
					oneLine = inFile.readLine();
					numbers = oneLine.split(",");
					for(int i=0; i < numbers.length; i++) {
						p2.append(Integer.parseInt(numbers[i]));
					}
					System.out.print("Sum: ");
					p1.add(p2).display();
					System.out.print("Product: ");
					p1.multiply(p2).display();
					System.out.println();
					p1.makeEmpty();
					p2.makeEmpty();
					oneLine = inFile.readLine();//processes empty line
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}