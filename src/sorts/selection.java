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
public class selection {

    private static final int LENGTH = 1000;

    public static void main(String[] args) {
        int[] x = new int[LENGTH];
        Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            x[i] = generator.nextInt(LENGTH);
        }
        long start = System.nanoTime();
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] > x[j]) {
                    int temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        long gg = (end - start) / 1000;
        System.out.println(gg);

    }
}
