/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class quick {

    private static final int LENGTH = 100000;

    /**
     *
     * @author Daniel
     */
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
        System.out.println(gg / 1000);

    }

    public static void sort(Comparable[] array) {
        Collections.shuffle(Arrays.asList(array));//desordemas la lista por si la lista viene casi ordenada u ordenada
        sort(array, 0, array.length - 1);//comenzamos a ordenar la lista
    }

    public static void sort(Comparable[] array, int l, int h) {
        if (h <= 0 || l < 0 || l >= h) {/*Si la lista esta vacia, hay que regresar*/

            return;
        }
        int j = quicksort(array, l, h);//distribuimos los elementos hacia la izq y derecha, en base a dos punteros
        sort(array, l, j - 1);//ordenamos la parte izq del arreglo
        sort(array, j + 1, h);//ordenamos la parte der del arreglo
    }

    private static int quicksort(Comparable[] array, int lo, int hi) {
        int i = lo;//puntero inicial que comienza con el primer elemento del arreglo
        int j = hi + 1;//puntero final que comienza en el ultimo elemento del arreglo
        Comparable v = array[lo];//almacena el pivote menor, para intercambiarlo si se encuentra otro elemento menor que el
        while (true) {//hasta que los punteros se encuentren terminara el while

            // compara si el siguiente elemento es menor al puntero menor, si encuentra uno menor almacena su posicion en el arreglo
            // , y sino sale del ciclo. Y si los punteros se encuentran termina el ciclo
            while (less(array[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            // compara si el elemento anterior es mayor al puntero menor, si encuentra uno mayor almacena su posicion en el arreglo
            // , y sino sale del ciclo. Y si los punteros se encuentran termina el ciclo
            while (less(v, array[--j])) {
                if (j == lo) {
                    break;
                }
            }
            //verifica que los punteros no se hayan cruzan, si se cruzan termina el ciclo
            if (i >= j) {
                break;
            }

            swap(array, i, j);//Intercambia los elementos de i a j, y j a i.
        }

        //Intercambia los elementos de i a j, y j a i.
        swap(array, lo, j);

        //retornamos el puntero que apunta al high del arreglo
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);//Si b es mayor que a, retorna
        /*
         Si da positivo, significa que a es mayor
         si da negativo, significa que b es mayor
         Si da , son iguales
         */
    }

    private static void swap(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
