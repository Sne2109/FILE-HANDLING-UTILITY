package codtech;

import java.io.*;
import java.nio.file.*;

public class SimpleFileOps {

    // Method to write content to a file
    public static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to append content to a file
    public static void appendToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.newLine();
            writer.write(content);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    // Method to modify file content by replacing oldText with newText
    public static void modifyFile(String filename, String oldText, String newText) {
        try {
            Path path = Paths.get(filename);
            String content = new String(Files.readAllBytes(path));
            content = content.replaceAll(oldText, newText);
            Files.write(path, content.getBytes());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate file operations
    public static void main(String[] args) {
        String fileName = "sample.txt";

        // Write to file
        writeFile(fileName, "Java is a high-level, object-oriented, platform-independent programming language developed by Sun Microsystems.");

        // Read file
        readFile(fileName);

        // Append content
        appendToFile(fileName, "Java code runs on any device with the Java Virtual Machine (JVM)..");

        // Modify file content
        modifyFile(fileName, "original", "updated");

        // Read again to verify changes
        readFile(fileName);
    }
}
