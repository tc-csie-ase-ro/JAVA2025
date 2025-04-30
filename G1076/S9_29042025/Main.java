import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NTHREADS = 4;
    public static void main(String[] args) {

        int arrDim = 40_000_000;

        // create an array of 40_000_000 elements
        int[] arr = new int[arrDim];

        // this will be used for the total sum
        Long sum = 0L;

        // this initializes the array with values from 1 to 40_000_000
        for (int i = 0; i < arrDim; i++) {
            arr[i] = i + 1;
        }

        // used for sectioning the array
        int startIndex = 0;
        int stopIndex = 0;

        // used for benchmarking
        long startTime = 0;
        long stopTime = 0;

        Long[] sumArr = new Long[NTHREADS];

        // 1. Sequential

        sum = 0L;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < arrDim; i++) {
            sum += arr[i];
        }
        stopTime = System.currentTimeMillis();
        System.out.println("1. Sequential time = " + (stopTime - startTime) + ", sum = " + sum);

        // 2. Multi-threading standard

        sum = 0L;
        startTime = System.currentTimeMillis();

        Thread[] threadArr = new Thread[NTHREADS];
        MyMultiThreadArray[] runnableThreadArr = new MyMultiThreadArray[NTHREADS];

        for (int i = 0; i < NTHREADS; i++) {

            // when i is 0 this will be from 0 to 9_999_999
            // when i is 1 this will be 10_000_000 to 19_999_999
            // ...

            startIndex = i * (arrDim / NTHREADS);
            stopIndex = (i + 1) * (arrDim / NTHREADS) - 1;

            sumArr[i] = 0L;
            runnableThreadArr[i] = new MyMultiThreadArray(arr, startIndex, stopIndex);
            threadArr[i] = new Thread(runnableThreadArr[i]);
        }

        for (int i = 0; i < NTHREADS; i++) {
            threadArr[i].start();
        }

        for (int i = 0; i < NTHREADS; i++) {
            try {
                threadArr[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < NTHREADS; i++) {
            sum += runnableThreadArr[i].getSum();
        }

        stopTime = System.currentTimeMillis();
        System.out.println("2. Multi-threading standard time = " + (stopTime - startTime) + ", sum = " + sum);

        // 3. Multi-threading executor-service
        sum = 0L;
        startTime = System.currentTimeMillis();

        ExecutorService execThreadPool = Executors.newFixedThreadPool(NTHREADS);
        MyMultiThreadArray[] workerTask = new MyMultiThreadArray[NTHREADS];

        for (int i = 0; i < NTHREADS; i++) {

            startIndex = i * (arrDim / NTHREADS);
            stopIndex = (i + 1) * (arrDim / NTHREADS) - 1;

            sumArr[i] = 0L;
            workerTask[i] = new MyMultiThreadArray(arr, startIndex, stopIndex);
            execThreadPool.execute(workerTask[i]);
        }

        execThreadPool.shutdown();

        try {
            execThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < NTHREADS; i++) {
            sum += workerTask[i].getSum();
        }

        stopTime = System.currentTimeMillis();

        System.out.printf("3. Multi-threading with Executor-Service time = " + (stopTime - startTime) + ", sum = " + sum);
    }
}
