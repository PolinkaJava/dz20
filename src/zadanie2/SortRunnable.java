package zadanie2;
class SortRunnable implements Runnable {
    private final int[] array;
    private final SortAlgorithm algorithm;

    SortRunnable(int[] array, SortAlgorithm algorithm) {
        this.array = array;
        this.algorithm = algorithm;
    }

    @Override
    public void run() {
        algorithm.sort(array);
    }
}