package main.com.chaoscube.algos.book;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 08/09/16.
 */
public class MergeSort extends Sort {

    private static Comparable[] aux;

    private  void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi]
        int i = lo;
        int j = mid+1;

        for(int k=lo; k<=hi; k++){
            //copy to aux array
            aux[k] = a[k];
        }

        for (int k=lo; k<=hi; k++){
            //merge back to a[lo..hi]
            if(i > mid)
                a[k] = aux[j++]; // LHS empty (take RHS)
            else if(j > hi)
                a[k] = aux[i++]; // RHS empty (take LHS)
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++]; // RHS is less than LHS (take RHS)
            else
                a[k] = aux[i++]; // RHS is greater than or equal to LHS (take LHS)
        }
    }


    public void sort(Comparable[] a){
        aux = new Comparable[a.length]; //Allocate space for aux array up front
        sort(a, 0, a.length -1);
    }

    private void sort(Comparable[] a, int lo, int hi){
        //Sort a[lo..hi]
        if(hi <= lo) {
            return;
        }

        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid); //Sort LHS
        sort(a, mid+1, hi); //Sort RHS
        merge(a, lo, mid, hi); //Merge results
    }
}
