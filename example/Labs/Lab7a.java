import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab7a {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sourceFileName, targetFileName;
        Scanner sourceFile = null;
        PrintWriter targetFile = null;
        
        System.out.print("Enter source file name: ");
        sourceFileName = input.nextLine();
        
        File file = new File(sourceFileName);
        if (!file.exists()) {
            System.out.println("Error: Source file does not exist!");
            System.exit(1);
        }
        
        System.out.print("Enter target file name: ");
        targetFileName = input.nextLine();
        
        file = new File(targetFileName);
        if (file.exists()) {
            System.out.println("Error: Target file already exists!");
            System.exit(2);
        }
 
        try {
            sourceFile = new Scanner(new File(sourceFileName));
            targetFile = new PrintWriter(targetFileName);
            while (sourceFile.hasNextLine()) {
                String line = sourceFile.nextLine();
                targetFile.println(line);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } finally {
            if (sourceFile != null) {
                sourceFile.close();
            }
            if (targetFile != null) {
                targetFile.close();
            }
        }
    }

}
