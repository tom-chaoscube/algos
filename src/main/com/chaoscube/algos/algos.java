package main.com.chaoscube.algos;


import edu.princeton.cs.introcs.StdIn;
import main.com.chaoscube.algos.indie.WeightedQuickUnionUF;
import main.com.chaoscube.algos.indie.Stack;
import main.com.chaoscu2be.algos.book.BinarySearch;

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

        UnionFindTest(args);
    }

    public static void BinarySearchTest(String[] args) {
       BinarySearch.main(args);
    }

    public static void StackTest(String[] args) {
        Stack.main(args);
    }

    public static void UnionFindTest(String[] args) { WeightedQuickUnionUF.main(args); }
}
