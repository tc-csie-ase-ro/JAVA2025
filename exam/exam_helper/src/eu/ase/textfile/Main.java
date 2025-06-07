package eu.ase.textfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("myfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read line: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();


        // save all content in a string
        try (BufferedReader reader = new BufferedReader(new FileReader("myfile.txt"))) {
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                System.out.println("Read line: " + line);
                builder.append(line);
                builder.append(System.lineSeparator()); // add new line
            }
            String content = builder.toString();
            System.out.printf("Content:\n%s\n", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
