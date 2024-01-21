package zadanie1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> maxFuture = executor.submit(new MaxCallable(array));
        Future<Integer> minFuture = executor.submit(new MinCallable(array));

        System.out.println("Максимум: " + maxFuture.get());
        System.out.println("Минимум: " + minFuture.get());

        executor.shutdown();
    }
}