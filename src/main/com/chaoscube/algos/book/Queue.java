package main.com.chaoscube.algos.book;

/**
 * Created by tom on 03/09/16.
 */
public class Queue<Item> {
    private Node first; //least recently added
    private Node last; //most recently added
    private int N; //number of items

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

    public void enqueue(Item item){
        //Add item to end of the list
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        //Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }

        return item;
    }
}
