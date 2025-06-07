package eu.ase.multithreading;

public class LineProcessor implements Runnable {
    private final String line;

    public LineProcessor(String line) {
        this.line = line;
    }

    @Override
    public void run() {
        // Simulate processing (for example, count words)
        int wordCount = line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;

        // Print result with thread name
        System.out.printf("Thread %s processed line: \"%s\" | Word count: %d\n",
                Thread.currentThread().getName(), line, wordCount);

        // Simulate some time-consuming work (optional)
        try {
            Thread.sleep(100); // 100 ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
