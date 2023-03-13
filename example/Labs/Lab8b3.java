import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab8b3 {

    public static void main(String[] args) {
        
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            
            Collections.sort(lines);
            
            FileWriter writer = new FileWriter(outputFile);
            for (String sortedLine : lines) {
                writer.write(sortedLine + "\n");
            }
            writer.close();
            
            System.out.println("Lines sorted successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}