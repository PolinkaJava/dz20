package zadanie1;

import java.util.Arrays;
import java.util.concurrent.Callable;

class MaxCallable implements Callable<Integer> {
    private final int[] array;

    MaxCallable(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() {
        return Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
    }
}

