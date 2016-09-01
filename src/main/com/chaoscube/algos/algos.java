package main.com.chaoscube.algos;


import edu.princeton.cs.introcs.StdOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.princeton.cs.introcs.StdIn;

/**
 * Created by tom on 21/07/16.
 */
public class algos {

    public static void main(String[] args) {
        System.out.println("Hello Algos");

        Logger logger = LoggerFactory.getLogger("algosLogger");

        logger.info("Hello algos logger");

        int input = StdIn.readInt();
        StdOut.printf("Number input is: %d", input);
    }
}
