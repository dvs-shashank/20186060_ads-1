import java.util.Scanner;
/**
 * Class for cube sum.
 */
class RamanNum implements Comparable<RamanNum> {
    /**
     * variable declaration.
     */
    private final int sum;
    /**
     * variable declaration.
     */
    private final int number1;
    /**
     * variable declaration.
     */
    private final int number2;
    /**
     * Constructs the object.
     *
     * @param      i integer.
     * @param      j integer.
     */
    public RamanNum(final int i, final int j) {
        this.sum = i * i * i + j * j * j;
        this.number1 = i;
        this.number2 = j;
    }
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }
    /**
     * gets the number.
     *
     * @return number.
     */
    public int getNumber1() {
        return number1;
    }
    /**
     * gets the number.
     *
     * @return number.
     */
    public int getNumber2() {
        return number2;
    }
    /**
     * compare to method.
     *
     * @param      other  The other
     *
     * @return  integer.
     */
    public int compareTo(RamanNum other) {
        if (this.sum < other.sum) return -1;
        if (this.sum > other.sum) return +1;
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + "";
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
        //def const.
    }
    public static void main(final String[] args) {
        Scanner srh = new Scanner(System.in);
        int m = srh.nextInt();
        int n = srh.nextInt();
        MinPQ<RamanNum> pq = new MinPQ<RamanNum>();
        
    }
}