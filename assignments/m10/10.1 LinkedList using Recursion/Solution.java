import java.util.Scanner;
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * head.
     */
    private Node head;
    /**
     * size.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item.
         */
        private int item;
        /**
         * next.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      itemm  The itemm
         * @param      nodee  The nodee
         */
        Node(final int itemm, final Node nodee) {
            this.item = itemm;
            this.next = nodee;
        }
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.size = 0;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * inserts at position.
     *
     * @param      node1    The node 1
     * @param      count    The count
     * @param      element  The element
     *
     * @return     node.
     */
    public Node insert(final Node node1,
                       final int count, final int element) {
        if (count == 0) {
            return new Node(element, node1);
        }
        node1.next = insert(node1.next, count - 1, element);
        size++;
        return node1;
    }
    /**
     * insert at.
     *
     * @param      pos    The position
     * @param      item1  The item 1
     */
    public void insertAt(final int pos,
                         final int item1) {
        head = insert(head, pos, item1);
    }
    /**
     * reverse.
     *
     * @param      node  The node
     *
     * @return     reverseNode.
     */
    public Node reverse(final Node node) {
        if  (node == null || node.next == null) {
            return node;
        }
        Node afterold = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return afterold;
    }
    /**
     * reverse.
     */
    public void reverse() {
        head = reverse(head);
    }
    /**
     * displaying.
     *
     * @return     String.
     */
    public String display() {
        Node pathaNode = head;
        String str = "";
        while (pathaNode != null) {
            str += pathaNode.item + ", ";
            pathaNode = pathaNode.next;
        }
        return str.substring(0, str.length() - 2);
    }
}
/**
 * class Solution.
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
        Scanner yuvraj = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (yuvraj.hasNext()) {
            String[] tokens = yuvraj.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0) {
                    System.out.println(
                        "Can't insert at this position.");
                } else if (Integer.parseInt(tokens[1]) 
                    > list.getSize() + 1) {
                    System.out.println(
                        "Can't insert at this position.");
                } else {
                    list.insertAt(Integer.parseInt(tokens[1]),
                                  Integer.parseInt(tokens[2]));
                    System.out.println(list.display());
                }
                break;
            case "reverse":
                if (list.getSize() == 0) {
                    System.out.println("No elements to reverse.");
                    return;
                }
                list.reverse();
                System.out.println(list.display());
                break;
            default:
                break;
            }
        }
    }
}
