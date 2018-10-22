import java.util.Scanner;

/**
 * Class for node.
 */

class Node {
    /**
     * { var_description }.
     */
    private Book key;
    /**
     * { var_description }.
     */
    public int val;
    /**
     * { item_description }.
     */
    public Node left;
    /**
     * { var_description }.
     */
    public Node right;
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return this.key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public int getVal() {
        return this.val;
    }
    /**
     * Constructs the object.
     *
     * @param      keey   The key
     * @param      vaal   The value
     */
    Node(final Book keey, final int vaal) {
        this.key = keey;
        this.val = vaal;
        left = null;
        right = null;
        //this.size = size;
    }
}

/**
 * Class for binary search tree.
 */

class BinarySearchTree {
    //BookDetails dobj = new BookDetails();

    /**
     * { var_description }.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public Node root() {
        return root;
    }
    /**
     * getter.
     *
     * @param      key   The key.
     *
     * @return     { description_of_the_return_value }.
     */
    public int get(final Book key) {
        //System.out.println("hello");
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.getKey());
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.getVal();
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final int val) {
        //System.out.println(key.getName()+"put 2 ints "+val);
        root = put(root, key, val);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }.
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }.
     */
    private Node put(final Node x, final Book key, final int val) {
        if (x == null) {
            return new Node(key, val);
            //break;
        }
        // System.out.println(key+" "+x.key);
        int cmp = key.compareTo(x.getKey());
        //System.out.println(cmp);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
            //System.out.println("Replaced");
        }
        return x;
    }
}




/**
 * Class for book.
 */
class Book implements Comparable {
    /**
     * name.
     */
    private String name;
    /**
     * author.
     */
    private String author;
    /**
     * price.
     */
    private double price;
    // /**
    //  * value.
    //  */
    // private int value;
    /**
     * Constructs the object.
     *
     * @param      naame  The naame
     * @param      athor  The athor
     * @param      amt    The amount
     */
    Book(final String naame, final String athor, final double amt) {
        this.name = naame;
        this.author = athor;
        this.price = amt;
        //this.value = val;
    }

    /**
     * { function_description }.
     *
     * @param      object  The object.
     *
     * @return     { description_of_the_return_value }.
     */
    public int compareTo(final Object object) {
        Book other = (Book) object;
        return this.name.compareTo(other.name);
    }


}


/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner yuvi = new Scanner(System.in);
        BinarySearchTree bstobj = new BinarySearchTree();
        while (yuvi.hasNext()) {
            String input = yuvi.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
            case "put":
                Book obj = new Book(tokens[1], tokens[2],
                                    Double.parseDouble(tokens[2 + 1]));
                bstobj.put(obj, Integer.parseInt(tokens[2 + 2]));
                break;

            case "get":
                obj = new Book(tokens[1], tokens[2],
                               Double.parseDouble(tokens[2 + 1]));
                if (bstobj.get(obj) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bstobj.get(obj));
                }

                //System.out.println(bstobj.get(obj));
                break;

            default:
                break;
            }
        }
    }
}
