//Sidney Mcclendon (smcclendon1@csudh.edu)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectoryAnalyzer {
	public static void main(String[] args) {
	       //Check if directory name was provided as a command line argument
	       if (args.length == 0) {
	           System.out.println("Please provide a directory name.");
	           return;
	       }

	       String directoryName = args[0];
	       File directory = new File(directoryName);
	       
	       System.out.println();

	       //Check if directory exists and is a directory
	       if (!directory.exists()) {
	           System.out.println("Directory does not exist.");
	           return;
	       } else if (!directory.isDirectory()) {
	           System.out.println(directoryName + " is not a directory.");
	           return;
	       }

	       int totalFiles = 0;
	       int totalAlphaChars = 0;
	       int totalNumericChars = 0;
	       int totalSpaceChars = 0;
	       long totalSize = 0;

	       System.out.format("%-20s %-20s %-20s %-20s %-20s %n", "Size", "Alpha Chars", "Numeric Chars", "Spaces", "File Name");
	       System.out.println("----------------------------------------------------------------------------------------------------");

	       for (File file : directory.listFiles()) {
	           if (file.isFile()) {
	               totalFiles++;
	               int alphaChars = 0;
	               int numericChars = 0;
	               int spaceChars = 0;
	               long size = file.length();

	               try (Scanner scanner = new Scanner(file)) {
	                   while (scanner.hasNext()) {
	                       String token = scanner.next();
	                       for (int i = 0; i < token.length(); i++) {
	                           char c = token.charAt(i);
	                           if (Character.isLetter(c)) {
	                               alphaChars++;
	                           } else if (Character.isDigit(c)) {
	                               numericChars++;
	                           } else if (Character.isWhitespace(c)) {
	                               spaceChars++;
	                           }
	                       }
	                   }
	               } catch (FileNotFoundException e) {
	                   e.printStackTrace();
	               }

	               totalAlphaChars += alphaChars;
	               totalNumericChars += numericChars;
	               totalSpaceChars += spaceChars;
	               totalSize += size;

	               String fileSize = formatFileSize(size);

	               System.out.format("%-20s %-20s %-20s %-20s %-20s %n", fileSize, alphaChars, numericChars, spaceChars, file.getName());
	           }
	       }

	       String totalFileSize = formatFileSize(totalSize);

	       System.out.println();
	       System.out.format("%-20s %-20s %-20s %-20s %n", "Total Files:", "Total Alpha Chars:", "Total Numeric Chars:", "Total Space Chars:");
	       System.out.format("%-20s %-20s %-20s %-20s %n", totalFiles, totalAlphaChars, totalNumericChars, totalSpaceChars);
	       System.out.format("%-20s %-20s %n", "Total Size Disk:", totalFileSize);
	   }

	   private static String formatFileSize(long size) {
	       if (size < 1024) {
	           return size + " bytes";
	       } else if (size < 1024 * 1024) {
	           return String.format("%.2f KBs", (double) size / 1024);
	       } else if (size < 1024 * 1024 * 1024) {
	           return String.format("%.2f MBs", (double) size / (1024 * 1024));
	       } else {
	           return String.format("%.2f GBs", (double) size / (1024 * 1024 * 1024));
	       }
	       
	   }

}
