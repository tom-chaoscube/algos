package main.com.chaoscube.algos;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import main.com.chaoscube.algos.book.SelectionSort;

/**
 * Created by tom on 07/09/16.
 */
public class Sort {
    public void sort(Comparable[] a) { System.out.println("Not implemented");}

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        //Print the array on single line
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }

        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //Test array entries are in-order
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }

        return true;
    }

    public void sortTest(String [] args) {
        In in = new In("data/words3.txt");
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
