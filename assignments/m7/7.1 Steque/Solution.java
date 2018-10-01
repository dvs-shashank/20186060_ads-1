import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
	/**
	 * value.
	 */
	private int value;
	/**
	 * next.
	 */
	private Node next;
	/**
	 * Constructs the object.
	 *
	 *time complexity 1.
	 *
	 * @param      value1  The value
	 * @param      node   The node
	 */
	Node(final int value1, final Node node) {
		this.value = value;
		this.next = node;
	}
	/**
	 * Gets the item.
	 *
	 * time complexity 1.
	 *
	 * @return     The item.
	 */
	public int getItem() {
		return this.value;
	}
	/**
	 * Sets the item.
	 *
	 * time complexity 1.
	 *
	 * @param      value  The value.
	 */
	public void setItem(final int value1) {
		this.value = value;
	}
	/**
	 * Gets the next.
	 *
	 * time complexity 1.
	 *
	 * @return     The next.
	 */
	public Node getNext() {
		return this.next;
	}
	/**
	 * Sets the next.
	 *
	 * time complexity 1.
	 *
	 * @param      node  The node
	 */
	public void setNext(final Node node) {
		this.next = node;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * time complexity 1.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return value + "";
	}
}
/**
 * Class for steque.
 */
class Steque {
	/**
	 * head
	 */
	private Node head;
	/**
	 * tail.
	 */
	private Node tail;
	/**
	 * size.
	 */
	private int size;
	/**
	 * Constructs the object.
	 *
	 * time complexity 1.
	 */
	Steque() {
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * push the element.
	 *
	 * time complexity 1.
	 *
	 * @param      element  The element
	 */
	public void push(final int element) {
		Node oldhead = head;
		head = new Node(element, oldhead);
		if (oldhead == null) {
			tail = head;
		}
		size++;
	}
	/**
	 * pop the element.
	 *
	 * time complexity 1.
	 */
	public void pop() {
		if (head != null && tail != null) {
			if (head.getNext() == null && tail.getNext() == null) {
				head = null;
				tail = head;
				size--;
			} else if (head != null) {
				head = head.getNext();
				size--;
			}
		}
	}
	/**
	 * enqueue elements.
	 *
	 * time complexity 1.
	 *
	 * @param      element  The element
	 */
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
	/**
	 * Returns a string representation of the object.
	 *
	 *
	 * time complexity n.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		if (size == 0) {
			sb.append("Steque is empty.");
			return sb.toString();
		} else {
			Node temp = head;
			while (temp != null) {
				sb.append(temp + ", ");
				temp = temp.getNext();
			}
			return sb.toString().substring(0, sb.length() - 2);
		}
	}
}
/**
 * class solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 *
	 * time complexity 1.
	 */
	private Solution() {
	}
	/**
	 * time  complexity n.
	 *
	 * @param      args  The arguments.
	 */
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

