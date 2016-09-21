package main.com.chaoscube.algos;

/**
 * Created by tom on 20/09/16.
 */
abstract public class ST<Key, Value> {
    public abstract void put(Key k, Value v);
    public abstract Value get(Key k);
    //public abstract void delete(Key K);
    public abstract boolean contains(Key key);
    //public abstract boolean isEmpty();
    public abstract int size();

    public abstract Iterable<Key> keys();

    // Extended methods
    /*
    abstract Key min();
    abstract Key max();
    abstract Key floor(Key k);
    abstract Key ceiling(Key k);
    abstract int rank(Key k);
    abstract Key select(int k);
    abstract void deleteMin();
    abstract void deleteMax();
    abstract int size(Key lo, Key hi);
    abstract Iterable<Key> keys(Key lo, Key hi);
    */
}
