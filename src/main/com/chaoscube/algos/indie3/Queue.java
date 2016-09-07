package main.com.chaoscube.algos.indie3;

/**
 * Created by tom on 05/09/16.
 */
public class Queue<Item> {
    private Node first; // Least recently added item
    private Node last; // Most recently added item
    private int N; // Item count

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
