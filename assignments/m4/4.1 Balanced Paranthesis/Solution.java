import java.util.Scanner;
/**
 * class for Solution.
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
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        Balanceparenthesis balance = new Balanceparenthesis();
        while (size > 0) {
            String input = sc.next();
            if (balance.checkParanthesis(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            size--;
        }
    }
}
