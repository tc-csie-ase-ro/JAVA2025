public class MyMultiThreadArray implements Runnable {

    private int[] arr;

    private int startIndex;
    private int stopIndex;

    private Long sum;

    public MyMultiThreadArray(int[] arr, int startIndex, int stopIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }


    @Override
    public void run() {
        long s = 0;
        for (int i = startIndex; i <= stopIndex; i++) {
            s += this.arr[i];
        }
        this.sum = s;
    }

    public Long getSum() {
        return sum;
    }
}
