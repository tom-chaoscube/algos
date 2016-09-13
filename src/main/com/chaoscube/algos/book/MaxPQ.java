package main.com.chaoscube.algos.book;

/**
 * Created by tom on 12/09/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v){
        // Add item to end and swim up
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // Max key is top of heap
        exch(1, N--); // Swap last key to top
        pq[N+1] = null; // Clean up for GC
        sink(1); // Sink new top to it's correct position
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        //Search up the heap looking if k is greater than parent key
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k <= N) {
            int j = 2*k;
            if (j<N && less(j, j+1)) {
                j++;
            }

            if (!less(k, j)) {
                //Position already found
                break;
            }

            exch(k,j);
            k = j;
        }
    }
}
