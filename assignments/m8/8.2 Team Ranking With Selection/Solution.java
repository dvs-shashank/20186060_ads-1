import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     *time complexity 1.
     *
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     *
     *time complexity n.
     *
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner yuvraj = new Scanner(System.in);
        Selection select = new Selection();
        while (yuvraj.hasNext()) {
            //Tournament tornyobj = new Tournament();
            String tableAsAString = yuvraj.nextLine();
            String[] stringArr = tableAsAString.split(",");
            select.addTeam(new Team(stringArr[0],
                                    Integer.parseInt(stringArr[1]),
                                    Integer.parseInt(stringArr[2]),
                                    Integer.parseInt(stringArr[1 + 1 + 1])));
        }
        select.sort();
        System.out.println(select);
    }
}
