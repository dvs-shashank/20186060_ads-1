import java.util.Scanner;

/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner yuvraj = new Scanner(System.in);
		Insertion insert = new Insertion();
		while (yuvraj.hasNext()) {
			//Tournament tornyobj = new Tournament();
			String tableAsAString = yuvraj.nextLine();
			String[] stringArr = tableAsAString.split(",");
			insert.addTeam(new Team(stringArr[0],
			                              Integer.parseInt(stringArr[1]), Integer.parseInt(stringArr[2]),
			                              Integer.parseInt(stringArr[2 + 1])));
		}
		insert.sort();
		System.out.println(insert);
	}
}