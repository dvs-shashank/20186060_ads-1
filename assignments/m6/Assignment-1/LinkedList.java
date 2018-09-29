/**
 * List of linkeds.
 */
class LinkedList {
    private int size = 0;
    private Node head;
    private Node tail;
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    public Node getHead() {
        return head;
    }
    /**
     * add data into list.
     *
     * @param      data  The data
     */
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