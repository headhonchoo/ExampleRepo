//Sidney Mcclendon (smcclendon1@csudh.edu)
import java.io.*;

public class FileCopy {

	public static void main(String[] args) {
		if (args.length < 2) {
		      System.out.println("Error: Missing arguments. Usage: java FileCopy <source file> <target file>");
		      System.exit(1);
		    }

		    String sourceFile = args[0];
		    String targetFile = args[1];

		    //This will check if source file exists
		    File file = new File(sourceFile);
		    if (!file.exists() || !file.isFile()) {
		      System.out.println("Error: Source file does not exist or is not a file.");
		      System.exit(1);
		    }

		    //This will check if target file is a directory
		    file = new File(targetFile);
		    if (file.isDirectory()) {
		      System.out.println("Error: Target file is a directory.");
		      System.exit(1);
		    }

		    //This will check if target file already exists
		    if (file.exists()) {
		      System.out.println("Error: Target file already exists.");
		      System.exit(1);
		    }

		    //This creates directories if needed
		    file.getParentFile().mkdirs();

		    //Then copies file
		    try (
		      InputStream in = new FileInputStream(sourceFile);
		      OutputStream out = new FileOutputStream(targetFile)
		    ) {
		      byte[] buffer = new byte[4096];
		      int bytesRead;
		      long totalBytesRead = 0;
		      while ((bytesRead = in.read(buffer)) != -1) {
		        out.write(buffer, 0, bytesRead);
		        totalBytesRead += bytesRead;
		      }
		      System.out.printf("%d bytes successfully copied from %s to %s\n", totalBytesRead, sourceFile, targetFile);
		    } catch (IOException e) {
		      System.out.println("Error: " + e.getMessage());
		      System.exit(1);
		    }

	}

}
