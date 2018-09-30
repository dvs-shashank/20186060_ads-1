/**
 * List of linkeds.
 *
 * @param      <yuvraj>  The yuvraj
 */
class LinkedList<yuvraj> {
    Node head;
    int size;
    /**
     * Class for node.
     */
    class Node {
        yuvraj data;
        Node link;
        /**
         * Constructs the object.
         */
        Node() {
            this.data = null;
            this.link = null;
        }
        /**
         * Constructs the object.
         *
         * @param      data  The data
         */
        Node(yuvraj data) {
            this.data = data;
            this.link = null;
        }
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        size = 0;
    }
    /**
     * Adds an at end.
     *
     * @param      data  The data
     */
    public void addAtEnd(final yuvraj data) {
        Node newNode;
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }
        Node current;
        current = head;
        while (current.link != null) {
            current = current.link;
        }
        newNode = new Node(data);
        current.link = newNode;
        size++;
    }
    /**
     * Adds an at start.
     *
     * @param      data  The data
     */
    public void addAtStart(final yuvraj data) {
        Node newNode = new Node(data);
        newNode.link = head;
        head = newNode;
        size++;
    }

    public void addAtLocation(final int location, final yuvraj data) {
        if (location > size) {
            System.out.println("Invalid position Exception in add at location.");
            return;
        }
        Node newNode = new Node(data);
        int counter = 1;
        Node current = head;

        while (counter < location - 1) {
            current = current.link;
            counter++;
        }
        newNode.link = current.link;
        current.link = newNode;
        size++;

    }
    /**
     * Removes an at end.
     */
    public void removeAtEnd() {
        if (size == 0) {
            System.out.println("Deck is Empty");
            return;
        }
        Node current = head;
        int counter = 1;
        while (counter < size - 1) {
            current = current.link;
            counter++;
        }
        current.link = null;
        size--;
    }
    /**
     * Removes an at start.
     */
    public void removeAtStart() {
        if (size == 0) {
            System.out.println("Deck is Empty");
            return;
        }
        Node current = head;
        head = head.link;
        current.link = null;
        size--;
    }
    /**
     * Removes an at location.
     *
     * @param      location  The location
     */
    public void removeAtLocation(final int location) {
        if (size == 0) {
            System.out.println("Deck is Empty");
        }
        if (location == size) {
            removeAtEnd();
            size--;
            return;
        }
        if (location > size) {
            System.out.println("Invalid location");
            return;
        }
        Node current = head;
        int counter = 1;
        while (counter < location - 1) {
            current = current.link;
            counter++;
        }
        Node temp = current.link;
        current.link = temp.link;
        temp.link = null;
        size--;

    }
    /**
     * Removes an element.
     *
     * @param      element  The element
     */
    public void removeElement(final yuvraj element) {
        try {
            Node current = head;
            int counter = 1;
            while (current.data != element) {
                current = current.link;
            }
            removeAtLocation(counter);
        } catch (Exception yuvraj) {
            System.out.println("No element found for removeElement");
        }
    }
    /**
     * for printing brackets
     */
    public void print() {
        if (size == 0) {
            System.out.println("[]");
            return;
        }
        Node current = head;
        System.out.print("[");
        while (current.link != null) {
            System.out.print(current.data + ", ");
            current = current.link;
        }
        System.out.print(current.data + "]");
        System.out.println();
    }
 
    public String getList() {
        if (size == 0) {
            return "[]";
        }
        Node current = head;
        String str = "[";
        while (current.link != null) {
            str += current.data + ", ";
            current = current.link;
        }
        str += current.data + "]";
        return str;
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
     * Gets the object.
     *
     * @param      index  The index
     *
     * @return     The object.
     */
    public yuvraj getObject(final int index) {
        if (size == 0) {
            return head.data;
        }
        Node current = head;
        int counter = 0;
        while (counter < index) {
            current = current.link;
            counter++;
        }
        return current.data;
    }
}