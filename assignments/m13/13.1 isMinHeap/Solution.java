import java.util.Scanner;
/**
 * List of minimum priorities.
 *
 * @param      <Yuvi>  The yuvi
 */
class MinPriorityQueue<Yuvi extends Comparable<Yuvi>> {
    /**
     * Generic array.
     */
    private Yuvi[] array;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr.
     */
    MinPriorityQueue(final Yuvi[] arr) {
        this.array = arr;
    }
    /**
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap() {
        for (int i = 0; i < this.array.length - 1; i++) {
            if (less(i + 1, i)) {
                return true;
            }
        }
        return false;
    }
    /**
     * less function.
     *
     * @param      firstOne  The first one
     * @param      rendodi   The rendodi
     *
     * @return     true if first one is less than the other, else false.
     */
    public boolean less(final int firstOne, final int rendodi) {
        return array[firstOne].compareTo(array[rendodi]) < 0;
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
        //default constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner yuvraj = new Scanner(System.in);
        String dataType = yuvraj.nextLine();
        int testCases = Integer.parseInt(yuvraj.nextLine());
        switch (dataType) {
        case "String":
            int count = 0;
            while (count < testCases) {
                String input = yuvraj.nextLine();
                String[] tokens = input.split(",");
                if (tokens.length != 0) {
                    String[] strTokens = new String[tokens.length];
                    for (int len = 0; len < tokens.length; len++) {
                        strTokens[len] = tokens[len];
                    }
                    MinPriorityQueue<String> minimum
                    = new MinPriorityQueue<String>(strTokens);
                    System.out.println(minimum.isMinHeap());
                } else {
                    System.out.println(false);
                    break;
                }
                count++;
            }
            break;
        case "Integer":
            count = 0;
            while (count < testCases) {
                String input = yuvraj.nextLine();
                String[] tokens = input.split(",");
                if (tokens.length > 0) {
                    Integer[] intTokens = new Integer[tokens.length];
                    for (int i = 0; i < tokens.length; i++) {
                        intTokens[i] = Integer.parseInt(tokens[i]);
                    }
                    MinPriorityQueue<Integer> minimum = new MinPriorityQueue<Integer>(intTokens);
                    System.out.println(minimum.isMinHeap());
                } else {
                    System.out.println(false);
                }
                count++;
            }
            break;
        case "Float":
            count = 0;
            while (count < testCases) {
                String input = yuvraj.nextLine();
                String[] tokens = input.split(",");
                if (tokens.length > 0) {
                    Float[] floatTokens = new Float[tokens.length];
                    for (int i = 0; i < tokens.length; i++ ) {
                        floatTokens[i] = Float.parseFloat(tokens[i]);
                    }
                    MinPriorityQueue<Float> minimum = new MinPriorityQueue<Float>(floatTokens);
                } else {
                    System.out.println(false);
                }
                count++;
            }
            break;
        case "Double":
            count = 0;
            while (count < testCases) {
                String input = yuvraj.nextLine();
                String[] tokens = input.split(",");
                if (tokens.length > 0) {
                    Double[] doubleTokens = new Double[tokens.length];
                    for (int i = 0; i < tokens.length; i++ ) {
                        doubleTokens[i] = Double.parseDouble(tokens[i]);
                    }
                    MinPriorityQueue<Double> minimum = new MinPriorityQueue<Double>(doubleTokens);
                } else {
                    System.out.println(false);
                }
                count++;
            }
            break;
        default:
            break;
        }
    }
}
