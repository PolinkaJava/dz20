package zadanie2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int[] array3 = new int[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array1[i] = scanner.nextInt();
        }
        System.arraycopy(array1, 0, array2, 0, size);
        System.arraycopy(array1, 0, array3, 0, size);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new SortRunnable(array1, new InsertionSort()));
        executor.execute(new SortRunnable(array2, new SelectionSort()));
        executor.execute(new SortRunnable(array3, new BubbleSort()));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1000, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(1000, TimeUnit.SECONDS))
                    System.err.println("Пул потоков не завершился");
            }
        } catch (InterruptedException ie) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }}}




