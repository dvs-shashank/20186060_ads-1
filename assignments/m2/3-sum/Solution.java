import java.util.Scanner;
import java.util.Arrays;
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
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int count = 0;
        int[] threesum = new int[size];
        for (int i = 0; i < size; i++) {
            threesum[i] = scan.nextInt();
        }
        Arrays.sort(threesum);
        for (int i = 0; i < size - 2; i++) {
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                if (threesum[i] + threesum[j]
                        + threesum[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (threesum[i] + threesum[j]
                           + threesum[k] < 0) {
                    j++;
                } else {
                    k--;
                }

            }
        }
        System.out.println(count);
    }
}
