import java.util.Scanner;
/**
 * Class for merge.
 */
class Merge {
    /**
     * constant.
     */
    private final int x = 7;
    /**
     * Constructs the object.
     */
    Merge() {
    }
    /**
     * { merge function }.
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low    The low
     * @param      mid    The middle
     * @param      high   The high
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
                      final int low, final int mid, final int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, low, high);
    }
    /**
     * { sort }.
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
                     final int low, final int high) {
        if (high <= low + x) {
            insertionSort(aux, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, high);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, low, mid, high);
    }
    /**
     * sort function.
     *
     * @param      a     { comparable array. }.
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort alg.
     *
     * @param      a     { parameter_description }
     * @param      low   The low
     * @param      high  The high
     */
    public void insertionSort(final Comparable[] a,
                              final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * exchange.
     *
     * @param      a     { comparable obj }.
     * @param      i     { comparable obj }.
     * @param      j     { int }.
     */
    public void exch(final Comparable[] a,
                     final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * less function.
     *
     * @param      i     { comparable obj }.
     * @param      j     { comparable obj }.
     *
     * @return     true/false.
     */
    public boolean less(final Comparable i, final Comparable j) {
        return i.compareTo(j) < 0;
    }
    /**
     * Determines if sorted.
     *
     * @param      a     comparable array.
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted.
     *
     * @param      a     { comparable array. }.
     * @param      low   The low
     * @param      high  The high
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
                            final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      array  The array
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}
/**
 * class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner yuvraj = new Scanner(System.in);
        Merge mergeobj = new Merge();
        while (yuvraj.hasNext()) {
            String[] tokens = yuvraj.nextLine().split(",");
            mergeobj.sort(tokens);
            System.out.println(mergeobj.toString(tokens));
            System.out.println();
        }
    }
}
