package zadanie2;

import java.util.Arrays;

class SelectionSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        System.out.println("Сортировка выбором: " + Arrays.toString(array));
    }
}
