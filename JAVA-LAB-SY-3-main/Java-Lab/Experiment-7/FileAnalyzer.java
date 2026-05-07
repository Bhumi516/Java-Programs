// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 6: Implementation of different I/O operations using I/O Streams
// Program 3: Read a text file and compute:
//            - Total number of vowels
//            - Total number of words
//            - Number of times character 'a' appears
//
// HOW TO RUN:
//   Step 1: Create a file named "input.txt" in the same directory as this program
//   Step 2: Add some text content to input.txt
//   Step 3: javac FileAnalyzer.java
//   Step 4: java FileAnalyzer
//
// NOTE: A sample input.txt will be created automatically if it doesn't exist.

import java.io.*;

public class FileAnalyzer {

    static final String FILE_NAME = "input.txt";

    // Create a sample input.txt if it doesn't exist
    static void createSampleFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                bw.write("Atharv Kate is a Java programmer.");
                bw.newLine();
                bw.write("Java is an amazing and powerful programming language.");
                bw.newLine();
                bw.write("Always practice coding to improve your skills.");
                bw.newLine();
                bw.write("A good programmer writes clean and readable code.");
                System.out.println("Sample \"" + FILE_NAME + "\" created.\n");
            } catch (IOException e) {
                System.out.println("Error creating sample file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        // Create sample file if needed
        createSampleFile();

        int vowelCount  = 0;
        int wordCount   = 0;
        int aCount      = 0;   // count of 'a' (both upper and lower)
        int lineCount   = 0;
        int charCount   = 0;

        System.out.println("========== File Analysis ==========");
        System.out.println("File: " + FILE_NAME);
        System.out.println("-----------------------------------\n");

        System.out.println("-- File Contents --");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;
                System.out.println(line);

                // Count words (split by whitespace)
                if (!line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }

                // Count vowels and character 'a'
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    charCount++;

                    // Count vowels (case-insensitive)
                    char lower = Character.toLowerCase(ch);
                    if (lower == 'a' || lower == 'e' || lower == 'i'
                            || lower == 'o' || lower == 'u') {
                        vowelCount++;
                    }

                    // Count 'a' (both 'a' and 'A')
                    if (ch == 'a' || ch == 'A') {
                        aCount++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
            return;
        }

        // Display results
        System.out.println("\n-----------------------------------");
        System.out.println("========== Analysis Results ==========");
        System.out.println("Total Lines              : " + lineCount);
        System.out.println("Total Characters         : " + charCount);
        System.out.println("Total Words              : " + wordCount);
        System.out.println("Total Vowels             : " + vowelCount);
        System.out.println("Occurrences of 'a' / 'A' : " + aCount);
        System.out.println("======================================");
    }
}
