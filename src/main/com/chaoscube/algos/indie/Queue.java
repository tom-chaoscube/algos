package main.com.chaoscube.algos.indie;

/**
 * Created by tom on 03/09/16.
 */
public class Queue<Item> {
    private Node first; // least recent item
    private Node last; // most recent item
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

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;

        if(isEmpty()) {
            last = null;
        }

        return item;
    }
}
