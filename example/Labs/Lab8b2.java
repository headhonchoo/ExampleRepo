import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Lab8b2 {
	public static void main(String[] args) {
		
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			HashSet<String> lines = new HashSet<String>();
			String line;
			
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			
			FileWriter writer = new FileWriter(outputFile);
			for (String uniqueLine : lines) {
				writer.write(uniqueLine + "\n");
				}
			writer.close();
			
			System.out.println("Duplicate lines removed successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}