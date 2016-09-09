package main.com.chaoscube.algos.book;

import edu.princeton.cs.introcs.StdRandom;
import main.com.chaoscube.algos.Sort;

/**
 * Created by tom on 09/09/16.
 */
public class QuickSort extends Sort {
     public void sort(Comparable[] a) {
         StdRandom.shuffle(a); // Eliminate dependence on input
         sort(a, 0, a.length - 1);
     }

     private static void sort(Comparable[] a, int lo, int hi) {
         if (hi<=lo) return;
         int j = partition(a, lo, hi);
         sort(a, lo, j-1);
         sort(a,j+1, hi);
     }

     private static int partition(Comparable[] a, int lo, int hi){
         //Partition into a[lo..j-1] , a[j], a[j+1..hi] and return j
         int i = lo; //left scan index
         int j  = hi + 1; //right scan index

         Comparable v = a[lo]; //Partitioning item

         while(true) {
             while(less(a[++i], v)){
                 //scan from L to R until we find an item greater than v
                 if (i==hi) break;
             }
             while(less(v, a[--j])) {
                 //scan from R to L until we find an item less than v
                 if (j == lo) break;
             }

             if( i>= j) break; //indexes have crossed

             exch(a, i, j);
         }

         exch(a, lo, j); // Put partitioning item v into a[j]
         return j;
     }
}
