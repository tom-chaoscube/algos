package main.com.chaoscube.algos.indie3;

/**
 * Created by tom on 05/09/16.
 */
public class Stack<Item> {
    private Node first; // Top of stack
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

    public void push(Item item) {
        Node oldfirst = first;
        Node first = new Node();
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
}
