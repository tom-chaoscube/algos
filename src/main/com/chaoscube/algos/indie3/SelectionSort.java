package main.com.chaoscube.algos.indie3;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 07/09/16.
 */
public class SelectionSort extends Sort {

    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i=0; i<N; i++) {
            int min = i;
            for (int j=i+1; j<N; j++){
                if(less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i, min);
        }
    }
}
