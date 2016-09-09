package main.com.chaoscube.algos.indie2;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 08/09/16.
 */
public class MergeSort extends Sort {
    private static Comparable[] aux;

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;

        for (int k=lo; k<=hi; k++){
            aux[k] = a[k]; // Copy a to aux
        }

        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                //LHS is empty
                a[k] = aux[j++];
            }
            else if (j > hi) {
                // RHS is empty
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i])) {
                // RHS is less than LHS
                a[k] = aux[j++];
            }
            else {
                //RHS is greater than or equal to LHS
                a[k] = aux[i++];
            }
        }

    }

    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];

        sort(a, 0, a.length -1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) { return; }
        int mid = lo + (hi-lo)/2;

        sort(a, lo, mid); // sort LHS
        sort(a, mid+1, hi); // sort RHS
        merge(a,lo,mid,hi);
    }
}
