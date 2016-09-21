package main.com.chaoscube.algos.week2.indie4;

/**
 * Created by tom on 15/09/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    Key[] pq;
    int N=0;

    MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public void insert(Key v) {
        //Add to end of heap
        pq[++N] = v;
        //Swim key up to correct position
        swim(N);
    }

    public Key delMax(){
        //Max is top of heap
        Key max = pq[1];

        //Swap end of heap to top
        exch(1, N--);

        //Tidy up for GC
        pq[N+1] = null;

        //Sink new top to correct position
        sink(1);

        return max;
    }

    private void swim(int k){
        while (k/2 > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (k <= N) {
            int j = 2*k;
            if(k < N && less(j, j+1)) {
                j++;
            }

            if(!less(k, j)) {
                //found position
                break;
            }

            exch(k,j);
            k = j;
        }
    }
}
