package eu.ase.multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // ExecutorService with fixed thread pool (e.g. 4 threads)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try (BufferedReader reader = new BufferedReader(new FileReader("myfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // For each line, create a LineProcessor Runnable and submit it
                executor.submit(new LineProcessor(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Shutdown the executor (no more tasks submitted)
        executor.shutdown();

        try {
            // Wait for all tasks to complete
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Some tasks did not finish in time!");
            } else {
                System.out.println("All tasks completed.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
