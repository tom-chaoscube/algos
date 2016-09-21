package main.com.chaoscube.algos.book;

import main.com.chaoscube.algos.week2.indie2.MaxPQ;
import edu.princeton.cs.algorithms.Transaction;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by tom on 12/09/16.
 */
public class TopM {

    public void topMTest(String[] args) {
        //Print M top lines in the input stream
        // int M = Integer.parseInt(args[0]);
        int M = 5; //hard code for test ;)

        In in = new In("data/tinyBatch.txt");

        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M+1);
        while(in.hasNextLine()){
            //create an entry from the next line and put on the PQ
            pq.insert(new Transaction(in.readLine()));

            if(pq.size() > M) {
                pq.delMax();
            }
        }

        Stack<Transaction> stack = new Stack<Transaction>();
        while(!pq.isEmpty()) {
            stack.push(pq.delMax());
        }

        for(Transaction t : stack) StdOut.println(t);

    }
}
