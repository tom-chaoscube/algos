package main.com.chaoscube.algos.indie4;

import edu.princeton.cs.introcs.StdRandom;
import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 09/09/16.
 */
public class QuickSort extends Sort {

    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) { return; }

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo; // L scan index
        int j = hi + 1; // R scan index
        Comparable v = a[lo]; //partition item

        while(true) {
            while(less(a[++i], v)) { if (i == hi) break; }
            while(less(v, a[--j])) { if (j == lo) break; }

            if (i >= j) { break; } //indexes crossed

            exch(a,i, j);
        }

        exch(a, lo, j);
        return j;
    }

}
