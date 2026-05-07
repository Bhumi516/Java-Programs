// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 6: Implementation of different I/O operations using I/O Streams
// Program 1: Read data from a sample.txt file located outside the program's directory
//
// HOW TO RUN:
//   Step 1: Create a file at C:\sample.txt (Windows) or /home/sample.txt (Linux/Mac)
//   Step 2: Add some text content to it
//   Step 3: Update the FILE_PATH variable below to match your file location
//   Step 4: javac ReadExternalFile.java
//   Step 5: java ReadExternalFile

import java.io.*;

public class ReadExternalFile {

    // Change this path to where your sample.txt is located
    static final String FILE_PATH = "C:\\sample.txt";   // Windows
    // static final String FILE_PATH = "/home/sample.txt"; // Linux / Mac

    public static void main(String[] args) {

        System.out.println("========== Reading External File ==========");
        System.out.println("File Path: " + FILE_PATH);
        System.out.println("-------------------------------------------\n");

        // -------- Method 1: FileInputStream (byte by byte) --------
        System.out.println("-- Method 1: FileInputStream (byte by byte) --");
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println("\n");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }

        // -------- Method 2: BufferedReader (line by line) --------
        System.out.println("-- Method 2: BufferedReader (line by line) --");
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                System.out.println("Line " + lineCount + ": " + line);
            }
            System.out.println("\nTotal Lines Read: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }

        // -------- Method 3: File metadata --------
        System.out.println("\n-- Method 3: File Metadata --");
        File file = new File(FILE_PATH);
        if (file.exists()) {
            System.out.println("File Name    : " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size    : " + file.length() + " bytes");
            System.out.println("Can Read     : " + file.canRead());
            System.out.println("Can Write    : " + file.canWrite());
        } else {
            System.out.println("File does not exist at: " + FILE_PATH);
        }
    }
}
