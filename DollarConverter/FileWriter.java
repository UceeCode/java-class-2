import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {

    public static void main(String[] args) {
        String serverFolderPath = "/Users/uche/IdeaProjects/DollarConverter/server";
        String fileName = "Myfile.txt";
        String lineToWrite = "The name of my school is Aptech.";

    
        Path filePath = Paths.get(serverFolderPath, fileName);

        try {
            Files.write(filePath, lineToWrite.getBytes());

            System.out.println("Line of text successfully written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 
