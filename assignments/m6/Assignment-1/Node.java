/**
 * Class for node.
 */
class Node {
    int data;
    Node next;
    /**
     * Constructs the object.
     *
     * @param      data  The data
     */
    Node(int data) {
        this.data = data;
    }
    
    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public int getData() {
        return this.data;
    }
    /**
     * address.
     *
     * @return     next object address.
     */
    public Node getnext() {
        return this.next;
    }
    /**
     * Sets the next.
     *
     * @param      next  The next
     */
    public void setNext(Node next) {
        this.next = next;
    }

}