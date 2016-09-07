package main.com.chaoscube.algos.book;

/**
 * Created by tom on 02/09/16.
 */

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; //stack items
    private int N = 0;  // number of items

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    private void resize(int max) {
        // Move stack to a new array of size max
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i < N; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public void push(Item item) {
        // Add item to top of stack
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        // Remove item from top of stack
        Item item = a[--N];
        a[N] = null; //Tidy up for later GC

        if (N > 0 && N == a.length/4) {
            resize(a.length / 2);
        }

        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    { // LIFO iteration
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() {
            //should throw UnsupportedOperationException
        }
    }
}
