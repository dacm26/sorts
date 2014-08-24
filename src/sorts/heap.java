/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Arrays;
import java.util.Random;
import static sorts.quick.sort;

/**
 *
 * @author Daniel
 */
public class heap {

    private static final int LENGTH = 1000000;

    public static void main(String[] args) {
        Integer[] arr = new Integer[LENGTH];
        Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = generator.nextInt(LENGTH);
        }
        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        long gg = (end - start) / 1000;
        System.out.println(gg/1000 );

    }

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k, N);
        }
        while (N > 1) {
            swap(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    private static void sink(Comparable[] array, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(array, j, j + 1)) {
                j++;
            }
            if (!less(array, k, j)) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] array, int i, int j) {
        return array[i - 1].compareTo(array[j - 1]) < 0;
    }

    private static void swap(Object[] array, int i, int j) {
        Object swap = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = swap;
    }

    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
        /*
         Si da positivo, significa que a es mayor
         si da negativo, significa que b es mayor
         Si da , son iguales
         */
    }

}
