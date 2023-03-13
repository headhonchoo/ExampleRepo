import java.io.File;
import java.util.Scanner;

public class Lab7a2 {
	public static void main(String[] args) {
		try {
			File file = new File("countries.txt");
			Scanner input = new Scanner(file);
			System.out.println("Enter search string: ");
			String searchString = new Scanner(System.in).nextLine();
	        System.out.println("The countries matching your input \"" + searchString + "\" are:");
	        while (input.hasNextLine()) {
	        	String line = input.nextLine();
	        	String[] parts = line.split(",");
	            String countryName = parts[0];
	            if (countryName.toUpperCase().contains(searchString.toUpperCase())) {
	            	System.out.println(countryName);
	                System.out.println("Population: " + parts[1]);
	                }
	            }
	        input.close();
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
	    }
}
