class LinkedList<Koushal> {
    Node head;
    int size;
    class Node {
        Koushal data;
        Node link;

        Node() {
            this.data = null;
            this.link = null;
        }

        Node(Koushal data) {
            this.data = data;
            this.link = null;
        }
    }

    LinkedList() {
        size = 0;
    }

    public void addAtEnd(final Koushal data) {
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

    public void addAtStart(final Koushal data) {
        Node newNode = new Node(data);
        newNode.link = head;
        head = newNode;
        size++;
    }

    public void addAtLocation(final int location, final Koushal data) {
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
            System.out.println("Invalid location ");
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

    public void removeElement(final Koushal element) {
        try {
            Node current = head;
            int counter = 1;
            while (current.data != element) {
                current = current.link;
            }
            removeAtLocation(counter);
        } catch (Exception e) {
            System.out.println("No element found for removeElement");
        }
    }

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

    public int getSize() {
        return this.size;
    }

    public Koushal getObject(final int index) {
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