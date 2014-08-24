/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class insertion {

    private static final int LENGTH = 1000000;

    public static void main(String[] args) {
        int[] arr = new int[LENGTH];
        Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = generator.nextInt(LENGTH);
        }
        long start = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
        long end = System.nanoTime();
        long gg = (end - start) / 1000;
        gg/=1000;
        gg/=1000;
        System.out.println(gg);

    }
}
