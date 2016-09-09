package main.com.chaoscube.algos.book;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 08/09/16.
 */
public class InsertionSort extends Sort {
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //Insert a[i] among a[i-1], a[i-2]..etc
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
