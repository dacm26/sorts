/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Random;

/**
 *
 * @author Daniel
 */
public class bubble {

    private static final int LENGTH = 1000000;

    public static void main(String[] args) {
        int[] array = new int[LENGTH];
        Random generator = new Random();
        for (int i = 0; i < LENGTH; i++) {
            array[i] = generator.nextInt(LENGTH);
        }
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int t = array[j];
                    array[j] = array[i];
                    array[i] = t;
                }
            }
        }
        long end = System.nanoTime();
        long gg = (end - start)/1000;
        gg=gg/1000;
        gg=gg/1000;
        System.out.println(gg);
    }
}
