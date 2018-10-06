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
	 * main method.
	 * 
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner yuvi = new Scanner(System.in);
		int qualifiedStudents = Integer.parseInt(yuvi.nextLine());
		int vacancies = Integer.parseInt(yuvi.nextLine());
		int unreservedVacancies = Integer.parseInt(yuvi.nextLine());
		int bcVacancies = Integer.parseInt(yuvi.nextLine());
		int scVacancies = Integer.parseInt(yuvi.nextLine());
		int stVacancies = Integer.parseInt(yuvi.nextLine());
		while(yuvi.hasNext()) {
			System.out.println(yuvi.nextLine());
		}
	}

}