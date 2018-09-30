import java.util.Scanner;
public final class Solution {
    private Solution() {
    }
   
    public static void main(final String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                d.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "pushRight":
                d.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "isEmpty":
                System.out.println(d.isEmpty());
                break;
            case "popLeft":
                d.popLeft();
                break;
            case "popRight":
                d.popRight();
                break;
            default:
                break;
            }
        }
    }
}
class Deque<yuvraj> {

    private int size;
    private LinkedList<yuvraj> linkedQueue;

    Deque() {
        linkedQueue = new LinkedList<yuvraj>();
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
   
    public int size() {
        return size;
    }
   
    public void pushLeft(final yuvraj item) {
        linkedQueue.addAtStart(item);
        size++;
        linkedQueue.print();
    }
   
    public void pushRight(final yuvraj item) {
        linkedQueue.addAtEnd(item);
        size++;
        linkedQueue.print();
    }
   
    public void popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        size--;
        linkedQueue.removeAtStart();
        if (linkedQueue.getSize() == 0) {
            System.out.println("[]");
            return;
        }
        linkedQueue.print();
    }   
    public void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        size--;
        linkedQueue.removeAtEnd();
        if (linkedQueue.getSize() == 0) {
            System.out.println("[]");
            return;
        }
        linkedQueue.print();
    }
}