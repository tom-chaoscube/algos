package main.com.chaoscube.algos.book;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

/**
 * Created by tom on 03/09/16.
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // top of stack
    private int N; // item count

    private class Node {
        //nested class to define nodes
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
        //Add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        //Create a stack and push/pop strings as directed on StdIn

        Stack<String> s = new Stack<String>();

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

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            //Throw unsupported operation exception
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
