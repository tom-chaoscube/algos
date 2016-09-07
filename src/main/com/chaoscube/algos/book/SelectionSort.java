package main.com.chaoscube.algos.book;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 07/09/16.
 */
public class SelectionSort extends Sort {

    public void sort(Comparable[] a) {
        // Sort a[] into increasing order

        int N = a.length;
        for(int i = 0; i < N; i++) {
            // Exchange a[i] with smallest entry in a[i+1..N]
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i, min);
        }
    }
}
