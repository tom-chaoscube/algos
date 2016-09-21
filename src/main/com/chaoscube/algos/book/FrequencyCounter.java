package main.com.chaoscube.algos.book;


import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import main.com.chaoscube.algos.ST;
import main.com.chaoscube.algos.week3.BST;

/**
 * Created by tom on 20/09/16.
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        int minlen = 8; //key length cut-off

        ST<String, Integer> st = new BST<String, Integer>();

        In in = new In("data/tale.txt");

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() < minlen) continue; //Ignore short keys
            if(!st.contains(word)) {
                st.put(word, 1);
            }
            else {
                st.put(word, st.get(word) + 1);
            }
        }

        //Find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        StdOut.println(max + " " + st.get(max));
    }
}
