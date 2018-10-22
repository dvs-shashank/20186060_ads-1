import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner yuvi = new Scanner(System.in);
        int n = Integer.parseInt(yuvi.nextLine());
        MinPQ<Float> minarr = new MinPQ<Float>(n);
        MaxPQ<Float> maxarr = new MaxPQ<Float>(n);
        Float median = 0.0f;
        for (int i = 0; i < n; i++) {
            Float val = yuvi.nextFloat();
            if (val > median) {
                minarr.insert(val);
            } else {
                maxarr.insert(val);
            }
            if (minarr.size() - maxarr.size() > 1) {
                maxarr.insert(minarr.delMin());
            }
            if (maxarr.size() - minarr.size() > 1) {
                minarr.insert(maxarr.delMax());
            }
            if (minarr.size() == maxarr.size()) {
                median = (minarr.min() + maxarr.max()) / 2;
                System.out.println(median);
            }
            if (maxarr.size() > minarr.size()) {
                median = maxarr.max();
                System.out.println(median);
            }
            if (minarr.size() > maxarr.size()) {
                median = minarr.min();
                System.out.println(median);
            }
        }
    }
}

