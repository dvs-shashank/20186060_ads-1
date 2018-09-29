import java.util.Scanner;
import java.util.*;
class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
        public int getData() {
            return this.data;
        }
        public Node getnext() {
            return this.next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

    }
class LinkedList {
    private int size = 0;
    private Node head;
    private Node tail;

    public int getSize() {
        return this.size;
    }
    public void add(int data) {
        if (size == 0) {
            head = new Node(data);
            tail = head;
            head.setNext(null);
            size++;
        } else {
            Node temp = new Node(data);
            temp.setNext(null);
            tail.setNext(temp);
            tail = temp;
            size++;
        }
    }
     
}
class AddLargeNumbers {
    static int a = 0; 
    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        int count = 0;
        while (count < number.length()) {
            int j = count;
            String s = number.substring(j, j + 1);
            int k = Integer.parseInt(s);
            list.add(k);
            count++;
        }
        a = list.getSize();
        return list;
    }
    public String toString() {
        System.out.println("hi");
        String str = "";
        int count = 0;
        while (count < a) {
            count++;
        }
        return "hiii";
    }
    

    public static String digitsToNumber(LinkedList list) {
        return null;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return null;
    }
    
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
