import java.util.Scanner;


class Node {
	public Book key;
	public int val;
	public Node left, right;
	//private int size;

	public Node(Book key, int val) {
		this.key = key;
		this.val = val;
		left = null;
		right = null;
		//this.size = size;
	}
}

class BinarySearchTree {
	//BookDetails dobj = new BookDetails();
	private Node root;

	BinarySearchTree() {
		root = null;
	}
	public Node root() {
		return root;
	}
	public int get(Book key) {
		//System.out.println("hello");
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else if (cmp == 0) {
				return x.val;
			}
		}
		return -1;
	}
	public void put(Book key, int val) {
		//System.out.println(key.getName()+"put 2 ints "+val);
		root = put(root, key, val);
	}
	private Node put(Node x, Book key, int val) {
		if (x == null) {
			return new Node(key, val);
			//break;
		}
		// System.out.println(key+" "+x.key);
		int cmp = key.compareTo(x.key);
		//System.out.println(cmp);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else if (cmp == 0) {
			x.val = val;
			//System.out.println("Replaced");
		}
		return x;
	}
}




/**
 * Class for book.
 */
class Book implements Comparable {
	/**
	 * name.
	 */
	private String name;
	/**
	 * author.
	 */
	private String author;
	/**
	 * price.
	 */
	private double price;
	// /**
	//  * value.
	//  */
	// private int value;
	/**
	 * Constructs the object.
	 *
	 * @param      naame  The naame
	 * @param      athor  The athor
	 * @param      amt    The amount
	 * @param      val    The value
	 */
	Book(final String naame, final String athor, final double amt) {
		this.name = naame;
		this.author = athor;
		this.price = amt;
		//this.value = val;
	}


	public int compareTo(Object object) {
		Book other = (Book) object;
		return this.name.compareTo(other.name);
	}


}


/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused constructor.
	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner yuvi = new Scanner(System.in);
		BinarySearchTree bstobj = new BinarySearchTree();
		while (yuvi.hasNext()) {
			String input = yuvi.nextLine();
			String[] tokens = input.split(",");
			switch (tokens[0]) {
			case "put":
				Book obj = new Book(tokens[1], tokens[2],
				                    Double.parseDouble(tokens[3]));
				bstobj.put(obj, Integer.parseInt(tokens[4]));



				break;

			case "get":
				obj = new Book(tokens[1], tokens[2],
				               Double.parseDouble(tokens[3]));
				if (bstobj.get(obj) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bstobj.get(obj));
                }

				System.out.println(bstobj.get(obj));
				break;

			default:
				break;
			}
		}
	}
}
