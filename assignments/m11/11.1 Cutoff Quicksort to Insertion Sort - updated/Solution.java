import java.util.Scanner;
/**
 * Class for sorting.
 */
class Sorting {
    /**
     * Constructs the object.
     */
    Sorting() {

    }
    // time complexity for this method is O(N^2).
    /**
     * insertion.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */

    public void insertion(final Comparable[] array, final int low,
                          final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
    }
    /**
     * exchange.
     *
     * @param      array  The array
     * @param      j      { parameter_description }
     * @param      min    The minimum
     */
    // time complexity of this method is constant.

    public void exchange(final Comparable[] array, final int j, final int min) {
        Comparable temp = array[j];
        array[j] = array[min];
        array[min] = temp;
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      array  The array
     *
     * @return     String representation of the object.
     */
// time complexity of this method is O(N). It iterates through

    public String toString(final Comparable[] array) {
        String str = "[";
        for (int i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[array.length - 1] + "]";
        return str;
    }
    /**
     * sort.
     *
     * @param      array   The array
     * @param      low     The low
     * @param      high    The high
     * @param      cutOff  The cut off
     */
    // time complexity is O(log N)

    public void sort(final Comparable[] array, final int low,
                     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int key = partition(array, low, high);
        System.out.println(toString(array));
        sort(array, low, key - 1, cutOff);
        sort(array, key + 1, high, cutOff);
    }
    /**
     * { sort }.
     *
     * @param      array   The array
     * @param      cutOff  The cut off
     */
    //time complexity is constant

    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
    /**
     * { partition }.
     *
     * @param      arr   The arr
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { int }.
     */
    // time complexity is O(N)

    public int partition(final Comparable[] arr,
                         final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        return j;
    }
    /**
     * less.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { true/false }
     */
    // time complexity is constant.

    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}
/**
 * client program.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting sort = new Sorting();
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            int j = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                sort.sort(tokens, j);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}
