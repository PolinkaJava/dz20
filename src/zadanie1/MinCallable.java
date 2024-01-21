package zadanie1;

import java.util.Arrays;
import java.util.concurrent.Callable;

class MinCallable implements Callable<Integer> {
    private final int[] array;

    MinCallable(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() {
        return Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
    }
}