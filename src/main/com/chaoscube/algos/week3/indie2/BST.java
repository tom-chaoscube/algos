package main.com.chaoscube.algos.week3.indie2;

import edu.princeton.cs.algorithms.Queue;
import main.com.chaoscube.algos.ST;

/**
 * Created by tom on 21/09/16.
 */
public class BST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    Node root;

    private class Node {
        Key key;
        Value val;

        Node left;
        Node right;

        int N; //number of nodes in subtree rooted here

        public Node(Key key, Value val, int N) {
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }

   public int size() {
       return size(root);
   }

   private int size(Node x) {
       if (x ==null) {
           return 0;
       }
       else {
           return x.N;
       }
   }

   public Value get(Key key) {
       return get(root, key);
   }

   private Value get(Node x, Key key) {
       if (x == null) return null;

       int cmp = key.compareTo(x.key);

       if (cmp < 0) {
           return get(x.left, key);
       }
       else if (cmp > 0) {
           return get(x.right, key);
       }
       else {
           return x.val;
       }
   }

   public void put(Key key, Value value){
       put(root, key, value);
   }

   private Node put(Node x, Key key, Value val) {
       if (x==null){
           return new Node(key, val, 1);
       }

       int cmp = key.compareTo(x.key);

       if (cmp < 0) {
           return put(x.left, key, val);
       }
       else if (cmp > 0) {
           return put(x.right, key, val);
       }
       else {
           x.val = val;
       }

       x.N = size(x.left) + size(x.right) + 1;

       return x;
   }

   public Key min() {
       return min(root).key;
   }

   private Node min(Node x) {
       if (x.left == null) {
           return x;
       }
       else {
           return min(x.left);
       }
   }

   public Key max() {
       return max(root).key;
   }

   private Node max(Node x){
       if (x.right == null) {
           return x;
       }
       else {
           return max(x.right);
       }
   }

   public boolean contains(Key key) {
       return get(key) != null;
   }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <=0 && cmphi >=0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}