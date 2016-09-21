package main.com.chaoscube.algos;


import edu.princeton.cs.introcs.StdIn;
import main.com.chaoscube.algos.book.FrequencyCounter;
import main.com.chaoscube.algos.book.HeapSort;
import main.com.chaoscube.algos.book.TopM;
import main.com.chaoscube.algos.indie4.QuickSort;
import main.com.chaoscube.algos.indie2.MergeSort;
import main.com.chaoscube.algos.indie.ShellSort;
import main.com.chaoscube.algos.indie3.InsertionSort;
import main.com.chaoscube.algos.indie4.SelectionSort;
import main.com.chaoscube.algos.week2.indie.WeightedQuickUnionUF;
import main.com.chaoscube.algos.indie.Stack;
import main.com.chaoscube.algos.book.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;

/**
 * Created by tom on 21/07/16.
 */
public class algos {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Algos");

        Logger logger = LoggerFactory.getLogger("algosLogger");

        logger.info("Hello algos logger");

        //BinarySearchTest(args);
        //UnionFindTest(args);
        //SelectionSortTest(args);
        //InsertionSortTest(args);
        //ShellSortTest(args);
        //MergeSortTest(args);
        //QuickSortTest(args);
        //HeapSortTest(args);
        //TopMTest(args);
        STTest(args);
    }

    public static void BinarySearchTest(String[] args) {
       BinarySearch.main(args);
    }

    public static void StackTest(String[] args) {
        Stack.main(args);
    }

    public static void UnionFindTest(String[] args) { WeightedQuickUnionUF.main(args); }

    public static void SelectionSortTest(String[] args) {
        SelectionSort sorter = new SelectionSort();
        sorter.sortTest(args);
    }

    public static void InsertionSortTest(String[] args) {
        InsertionSort sorter = new InsertionSort();
        sorter.sortTest(args);
    }

    public static void ShellSortTest(String[] args) {
        ShellSort sorter = new ShellSort();
        sorter.sortTest(args);
    }

    public static void MergeSortTest(String[] args) {
        MergeSort sorter = new MergeSort();
        sorter.sortTest(args);
    }

    public static void QuickSortTest(String[] args){
        QuickSort sorter = new QuickSort();
        sorter.sortTest(args);
    }

    public static void HeapSortTest(String[] args) {
        HeapSort sorter = new HeapSort();
        sorter.sortTest(args);
    }

    public static void TopMTest(String[] args){
        //MaxPQ test
        TopM topm = new TopM();
        topm.topMTest(args);
    }

    public static void STTest(String[] args){
        FrequencyCounter fqc = new FrequencyCounter();
        fqc.main(args);
    }
}
