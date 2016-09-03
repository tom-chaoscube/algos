package main.com.chaoscube.algos.indie;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by tom on 03/09/16.
 */
public class Stack<Item> {
    private Node first; //top of stack
    private int N; // item count

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        //Create a stack and push/pop strings as directed on StdIn

        main.com.chaoscube.algos.book.Stack<String> s = new main.com.chaoscube.algos.book.Stack<String>();

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }

            StdOut.println("(" + s.size() + " left on stack)");
        }
    }
}
