import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


class StockMarket implements Comparable {
    /**
     * name.
     */
    private String name;

    StockMarket[] arr;

    private float valuel;

    int size;


    StockMarket(final String naam, float vaaaaaalue) {
        this.name = naam;
        arr = new StockMarket[1000];
        this.valuel = vaaaaaalue;
        //this.percentageshare = percent;
        size = 0;
    }

    public float getValue() {
        return this.valuel;
    }

    public void add(StockMarket smobj) {
        arr[size++] = smobj;
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(Object object) {
        StockMarket other = (StockMarket) object;
        return this.name.compareTo(other.name);
    }


}


class Node {
    public StockMarket key;
    public float val;
    public Node left, right;

    public Node(StockMarket key, float val) {
        this.key = key;
        this.val = val;
        left = null;
        right = null;
    }
}


class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        root = null;
    }
    public Node root() {
        return root;
    }
    public float get(StockMarket key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                //System.out.println(key.getName());
                x = x.left;
            } else if (cmp > 0) {
                //System.out.println(key.getName());
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return -1f;
    }
    public void put(StockMarket key, float val) {
        //System.out.println("Hi ra");
        root = put(root, key, val);
    }
    private Node put(Node x, StockMarket key, float val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
}


/**
* client program.
*
*  @author Robert Sedgewick
*  @author Kevin Wayne
*
*  @param <Key> the generic type of key on this priority queue
*/
class MinPQ<Key>  {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator
    /**
    * Initializes an empty priority queue with the given initial capacity.
    *
    * @param  initCapacity the initial capacity of this priority queue
    */
    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
    * Initializes an empty priority queue.
    */
    public MinPQ() {
        this(1);
    }
    /**
    * Initializes an empty priority queue with the given initial capacity,
    * using the given comparator.
    *
    * @param  initCapacity the initial capacity of this priority queue
    * @param  comparator the order in which to compare the keys
    */
    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
    * Initializes an empty priority queue using the given comparator.
    *
    * @param  comparator the order in which to compare the keys
    */
    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }
    /**
    * Initializes a priority queue from the array of keys.
    * <p>
    * Takes time proportional to the number of keys, using sink-based heap construction.
    *
    * @param  keys the array of keys
    */
    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
    }
    /**
    * Returns true if this priority queue is empty.
    *
    * @return {@code true} if this priority queue is empty;
    *         {@code false} otherwise
    */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
    * Returns the number of keys on this priority queue.
    *
    * @return the number of keys on this priority queue
    */
    public int size() {
        return n;
    }
    /**
    * Returns a smallest key on this priority queue.
    *
    * @return a smallest key on this priority queue
    * @throws NoSuchElementException if this priority queue is empty
    */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
    * Adds a new key to this priority queue.
    *
    * @param  x the key to add to this priority queue
    */
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);
        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
    }
    /**
    * Removes and returns a smallest key on this priority queue.
    *
    * @return a smallest key on this priority queue
    * @throws NoSuchElementException if this priority queue is empty
    */
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;   // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return min;
    }
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    //,Float.parseFloat(tokens[1])
    public void print(StockMarket obj, float vaaalue, BinarySearchTree bbst) {
        System.out.println(bbst.get(obj));
        //System.out.println(vaaalue);
    }
}
class MaxPQ<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator
    /**
    * Initializes an empty priority queue with the given initial capacity.
    *`
    * @param  initCapacity the initial capacity of this priority queue
    */
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
    * Initializes an empty priority queue.
    */
    public MaxPQ() {
        this(1);
    }
    /**
    * Initializes an empty priority queue with the given initial capacity,
    * using the given comparator.
    *
    * @param  initCapacity the initial capacity of this priority queue
    * @param  comparator the order in which to compare the keys
    */
    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
    * Initializes an empty priority queue using the given comparator.
    *
    * @param  comparator the order in which to compare the keys
    */
    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }
    /**
    * Initializes a priority queue from the array of keys.
    * Takes time proportional to the number of keys, using sink-based heap construction.
    *
    * @param  keys the array of keys
    */
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
    }
    /**
    * Returns true if this priority queue is empty.
    *
    * @return {@code true} if this priority queue is empty;
    *         {@code false} otherwise
    */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
    * Returns the number of keys on this priority queue.
    *
    * @return the number of keys on this priority queue
    */
    public int size() {
        return n;
    }
    /**
    * Returns a largest key on this priority queue.
    *
    * @return a largest key on this priority queue
    * @throws NoSuchElementException if this priority queue is empty
    */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
    * Adds a new key to this priority queue.
    *
    * @param  x the new key to add to this priority queue
    */
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);
        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
    }
    /**
    * Removes and returns a largest key on this priority queue.
    *
    * @return a largest key on this priority queue
    * @throws NoSuchElementException if this priority queue is empty
    */
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;   // to avoid loiteing and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    public void print(StockMarket obj, float vaalue, BinarySearchTree bbst) {
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(obj.getName());
        //     //delMax(obj);
        // }
        System.out.println(bbst.get(obj));
        System.out.println(obj.getName());
        System.out.println(obj.getValue());
        System.out.println();
    }


    // public String toString() {
    //     System.out.println("ochindi ikadiki");
    //     String str = "";
    //     for (int i = 0; i < n; i++) {
    //         str += pq[i];
    //     }
    //     return str;

    // }
}



public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        MinPQ<Float> minpq = new MinPQ<Float>(n);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(n);
        BinarySearchTree bst = new BinarySearchTree();
        int count = 1;
        while (count <= n * 6) {
            String inputs = scan.nextLine();
            String[] tokens = inputs.split(",");
            StockMarket sm = new StockMarket(tokens[0], Float.parseFloat(tokens[1]));
            //System.out.println(tokens[1]);
            bst.put(sm, Float.parseFloat(tokens[1]));
            float someThing = 0.0f;
            if (Float.parseFloat(tokens[1]) > someThing) {
                minpq.insert(Float.parseFloat(tokens[1]));
            } else {
                maxpq.insert(Float.parseFloat(tokens[1]));
            }
            if (count % 20 == 0) {
                maxpq.print(sm, Float.parseFloat(tokens[1]), bst);
                minpq.print(sm, Float.parseFloat(tokens[1]), bst);
            }
            count++;
        }
    }
}