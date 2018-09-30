import java.util.Scanner;
public final class Solution {
    private Solution() {
    }

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
class Queue {

    private int size;
    private Node queue;
    private Node head;
    class Node {
        private int data;
        private Node link;
        Node() {
            this.data = 0;
            this.link = null;
        }
        Node(final int data1) {
            this.data = data1;
            this.link = null;
        }
    }

    Queue() {
        queue = new Node();
        size = 0;
    }

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

    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}