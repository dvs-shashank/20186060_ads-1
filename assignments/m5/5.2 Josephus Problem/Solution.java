import java.util.Scanner;
/**
 * class solution.
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
        Scanner scan = new Scanner(System.in);
        Queue queueObj = new Queue();
        int noOfInputs = Integer.parseInt(scan.nextLine());
        for (int index1 = 0; index1 < noOfInputs; index1++) {
            String[] tokens = scan.nextLine().split(" ");
            int number = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);

            for (int index = 0; index < number; index++) {
                queueObj.enQueue(index);
            }

            while (!queueObj.isEmpty() && number != 1) {
                for (int i = 1; i < position; i++) {
                    queueObj.enQueue(queueObj.deQueue());
                }
                System.out.print(queueObj.deQueue() + " ");
                number--;
            }
            System.out.print(queueObj.deQueue());
            System.out.println();
        }
    }
}
/**
 * class queue.
 */
class Queue {
    /**
     * size.
     */
    private int size;
    /**
     * queue node.
     */
    private Node queue;
    /**
     * head node.
     */
    private Node head;
    /**
     * nested class node.
     */
    class Node {
        /**
         * data.
         */
        private int data;
        /**
         * link.
         */
        private Node link;
        /**
         * Constructs the object.
         */
        Node() {
            this.data = 0;
            this.link = null;
        }
        /**
         * Constructs the object.
         *
         * @param      data1  The data 1
         */
        Node(final int data1) {
            this.data = data1;
            this.link = null;
        }
    }
    /**
     * Constructs the object.
     */
    Queue() {
        queue = new Node();
        size = 0;
    }
    /**
     * enqueing the data.
     *
     * @param      data  The data
     */
    public void enQueue(final int data) {
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }
        Node start = new Node(data);
        start.link = head;
        head = start;
        size++;
        return;
    }
    /**
     * dequeuing the data.
     *
     * @return     data.
     */
    public int deQueue() {
        Node current = head;
        if (size == 1) {
            size--;
            int n = head.data;
            head = null;
            return current.data;
        }

        int counter = 1;
        while (counter < size - 1) {
            counter++;
            current = current.link;
        }
        int data = current.link.data;
        current.link = null;
        size--;
        return data;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
}
