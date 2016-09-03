package main.com.chaoscube.algos.indie;

import java.util.Iterator;

/**
 * Created by tom on 02/09/16.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    Item[] a = (Item[]) new Object[1]; // Array for items
    int N = 0; // Item count

    private void resize(int max) {
        // Resize array by size max
        Item[] temp = (Item[]) new Object[max];

        for (int i=0; i < N; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public void push(Item item) {
        // Add item to stack
        if (N == a.length) {
            resize(2*a.length);
        }

        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null; //allow tidy up for later GC

        if (N > 0 && N == a.length/4) {
            resize(a.length/2);
        }

        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
            // should throw UnsupportedOperationException
        }
    }
}
