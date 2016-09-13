package main.com.chaoscube.algos.week2.indie;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by tom on 12/09/16.
 */
public class WeightedQuickUnionUF {
    private int[] id; // links to parent (site indexed)
    private int[] sz; // size of component (site indexed)
    private int count; // number of components

    public WeightedQuickUnionUF(int N) {
        count = N;

        id =  new int[N];
        for (int i=0; i<N; i++) {
            //Initially everything links to self
            id[i] = i;
        }

        sz = new int[N];
        for (int i=0; i<N; i++) {
            //Initially all components are single node trees
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        //traverse to root
        while(p != id[p]) {
            p = id[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i==j) {
            return;
        }
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }

    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn

        In in = new In("data/largeUF.txt");

        int N = in.readInt();

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();

            if (uf.connected(p,q)) {
                continue;
            }

            uf.union(p, q);

            StdOut.println(p + " " + q);
        }

        StdOut.println(uf.count() + " components");
    }

}
