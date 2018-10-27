import java.util.Scanner;
/**
 * Class for student.
 */
class Student implements Comparable {
    /**
     * rollNo variable.
     */
    private Integer rollNo;
    /**
     * name variable.
     */
    private String name;
    /**
     * marks variable.
     */
    private double marks;
    /**
     * Constructs the object.
     *
     * order of 1.
     *
     * @param      brollNo    The brollNo
     * @param      bname  The bname
     * @param      bmarks   The bmarks
     */
    Student(final Integer brollNo,
            final String bname, final double bmarks) {
        this.rollNo = brollNo;
        this.name = bname;
        this.marks = bmarks;
    }
    /**
     * Gets the rollNo.
     *
     * @return     The rollNo.
     */
    public int getrollNo() {
        return this.rollNo;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getname() {
        return this.name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getmarks() {
        return this.marks;
    }
    /**
     * compare to method that returns integer.
     *
     * @param      object  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object object) {
        Student that = (Student) object;
        return this.rollNo.compareTo(that.rollNo);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getname(); //getrollNo() + ", " + getname() + ", " + getmarks();
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public double output() {
        return this.marks;

    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * variable declaration.
     */
    private Node root;
    /**
     * Class for node.
     */
    private final class Node {
        /**
         * key.
         */
        private Integer key;
        /**
         * val variable.
         */
        private Student val;
        /**
         * left variable.
         */
        private Node left;
        /**
         * right variable.
         */
        private Node right;
        /**
         * size variable.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key1   The key 1
         * @param      val1   The value 1
         * @param      siize  The siize
         */
        private Node(final Integer key1, final Student val1, final int siize) {
            this.key = key1;
            this.val = val1;
            this.size = siize;
            left = null;
            right = null;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * size function.
     *
     * @return     { description_of_the_return_value }.
     */
    public int size() {
        return size(root);
    }
    /**
     * size function.
     *
     * @param      x     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }



    /**
     * get method.
     *time complexity is O(logN)
     * @param      key   The key
     *
     * @return  integer.
     */
    public Student get(final Integer key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return null;
    }
    /**
     * put method to insert the key, value.
     *time complexity is O(logN)
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final int key, final Student val) {
        root = put(root, key, val);
    }
    /**
     * overloaded constructor.
     * time complexity is O(logN)
     * @param      x   root node.
     * @param      key   The key.
     * @param      val   The value.
     *
     * @return root.
     */
    private Node put(final Node x, final Integer key, final Student val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        // int cmp = key;
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
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner yuvi = new Scanner(System.in);
        BinarySearchTree bstobj = new BinarySearchTree();
        int n1 = 0;
        int n2 = 0;
        int numInputs = Integer.parseInt(yuvi.nextLine());
        while (n1 < numInputs) {
            String[] tokens = yuvi.nextLine().split(",");
            Student stdobj = new Student(Integer.parseInt(tokens[0]),
                                         tokens[1],
                                         Double.parseDouble(tokens[2]));
            bstobj.put(Integer.parseInt(tokens[0]), stdobj);
            n1++;
        }
        int numOutputs = Integer.parseInt(yuvi.nextLine());
        while (n2 < numOutputs) {
            String[] outTokens = yuvi.nextLine().split(" ");
            switch (Integer.parseInt(outTokens[2])) {
            case 1:
                try {
                    System.out.println(bstobj.get(
                                           Integer.parseInt(outTokens[1])));
                } catch (Exception e) {
                    System.out.println("Student doesn't exists...");
                }
                break;
            case 2:
                try {
                    Student obj = bstobj.get(Integer.parseInt(outTokens[1]));
                    System.out.println(obj.output());
                    if (obj.equals(null)) {
                        System.out.println("Student doesn't exists...");
                    }
                } catch (Exception e) {
                    System.out.println("Student doesn't exists...");
                }
            default:
                break;
            }
            n2++;
        }
    }
}
