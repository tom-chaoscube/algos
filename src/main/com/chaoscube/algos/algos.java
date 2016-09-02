package main.com.chaoscube.algos;


import main.com.chaoscube.algos.indie3.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tom on 21/07/16.
 */
public class algos {

    public static void main(String[] args) {
        System.out.println("Hello Algos");

        Logger logger = LoggerFactory.getLogger("algosLogger");

        logger.info("Hello algos logger");

        BinarySearchTest(args);
    }

    public static void BinarySearchTest(String[] args) {
       BinarySearch.main(args);
    }
}
