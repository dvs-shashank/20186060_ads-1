import java.util.Scanner;

class LinkedList {    
    private Node head;
    private int size;
    private class Node {
        private int item;
        private Node next;
        Node(final int itemm, final Node nodee) {
            this.item = itemm;
            this.next = nodee;
        }
    }
    LinkedList() {
        this.size = 0;
    }
    public int getSize() {
        return this.size;
    }
    public Node insert(final Node node1, final int count, final int element) {
        if (count == 0) {
            return new Node(element, node1);
        }
        node1.next = insert(node1.next, count - 1, element);
        size++;
        return node1;
    }
   
    public void insertAt(final int pos, final int item1) {
        head = insert(head, pos, item1);
    }
  
    public Node reverse(final Node node) {
        if  (node == null || node.next == null) {
            return node;
        }
        Node afterold = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return afterold;
    }
   
    public void reverse() {
        head = reverse(head);
    }
   
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

public final class Solution {
    
    private Solution() {
    }

    public static void main(final String[] args) {
        Scanner yuvraj = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (yuvraj.hasNext()) {
            String[] tokens = yuvraj.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0) {
                    System.out.println("Cant insert at this position.");
                } else if (Integer.parseInt(tokens[1]) > list.getSize() + 1) {
                    System.out.println("Cant insert at this position.");
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
