import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab8b {
	public static void main(String[] args) {
		Map<String,String> countries = new HashMap<>();
		
		try {
			File file = new File("countries.txt");
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String[] line = input.nextLine().split(",");
				countries.put(line[0], line[1]);
				}
	        } catch (Exception e) {
	        	System.out.println("Error reading file");
	        }
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter search string: ");
		String searchString = input.nextLine();
		
		if(countries.containsKey(searchString)) {
			System.out.println(searchString + "\nPopulation: " + countries.get(searchString));
			}
	        else {
	            System.out.println("Country not found.");
	        }
	}
}
