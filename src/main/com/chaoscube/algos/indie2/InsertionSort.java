package main.com.chaoscube.algos.indie2;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 08/09/16.
 */
public class InsertionSort extends Sort {
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i=1; i<N; i++) {
            for(int j=i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
