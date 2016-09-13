package main.com.chaoscube.algos.book;

import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 13/09/16.
 */
public class HeapSort extends Sort {

    public void sort(Comparable[] a){
        int N = a.length;
        for (int k=N/2; k>=1; k--) {
            sink(a, k, N);
        }

        while (N>1){
            heapExch(a, 1, N--);
            sink(a,1,N);
        }
    }

    private void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && heapLess(pq, j, j+1)) {
                j++;
            }

            if(!heapLess(pq, k, j)) {
                break;
            }

            heapExch(pq, k ,j);
            k = j;
        }
    }

    private boolean heapLess(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private void heapExch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
}
