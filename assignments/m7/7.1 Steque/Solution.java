import java.util.Scanner;
class Node {
        private int value;
        private Node friend;
        Node(final int v, final Node node) {
            this.value = v;
            this.friend = node;
        }
        public int getItem() {
            return this.value;
        }
        public void setItem(final int value) {
            this.value = value;
        }
        public Node getFriend() {
            return this.friend;
        }
        public void setNext(final Node node) {
            this.friend = node;
        }
        public String toString() {
            return value + "";
        }
    }
class Steque {
    private Node head;
    private Node tail;
    private int size;
    Steque() {
        head = null;
        tail = null;
        size = 0;
    }
    public void push(final int element) {
        Node oldhead = head;
        head = new Node(element, oldhead);
        if (oldhead == null) {
            tail = head;
        }
    }
    public void pop() {
        if (head != null && tail != null) {
            if (head.getFriend() == null && tail.getFriend() == null) {
                head = null;
                tail = head;
                size--;
            } else if (head != null) {
                head = head.getFriend();
                size--;
            }
        }
    }
    public void enqueue(final int element) {
        if (tail != null) {
            Node oldtail = tail;
            tail = new Node(element, null);
            oldtail.setNext(tail);
        } else if (head == null && tail == null) {
            head = new Node(element, null);
            tail = head;
        }
        size++;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (size == 0) {
            sb.append("Steque is empty.");
            return sb.toString();
        } else {
            Node temp = head;
            while (temp != null) {
            sb.append(temp + ", ");
            temp = temp.getFriend();
            }
        return sb.toString().substring(0, sb.length() - 2);
        }
    }
}
public final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n > 0) {
        Steque steque = new Steque();
        while (sc.hasNext()) {
        String[] line = sc.nextLine().split(" ");
        switch (line[0]) {
            case "push":
            steque.push(Integer.parseInt(line[1]));
            System.out.println(steque);
            break;
            case "pop":
            steque.pop();
            System.out.println(steque);
            break;
            case "enqueue":
            steque.enqueue(Integer.parseInt(line[1]));
            System.out.println(steque);
            break;
            default:
            steque = new Steque();
            System.out.println();
            break;
        }
        n--;
        }
    }
}
}
