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
		Insertion insert = new Insertion();
		int qualifiedStudents = Integer.parseInt(yuvi.nextLine());
		int vacancies = Integer.parseInt(yuvi.nextLine());
		int unreservedVacancies = Integer.parseInt(yuvi.nextLine());
		int bcVacancies = Integer.parseInt(yuvi.nextLine());
		int scVacancies = Integer.parseInt(yuvi.nextLine());
		int stVacancies = Integer.parseInt(yuvi.nextLine());
		while (yuvi.hasNext()) {
			String studentInfo = yuvi.nextLine();
			String[] studentInfoArr = studentInfo.split(",");
			insert.addStudents(new Student(studentInfoArr[0],
			                        studentInfoArr[1],
			                        Integer.parseInt(studentInfoArr[2]),
			                        Integer.parseInt(studentInfoArr[3]),
			                        Integer.parseInt(studentInfoArr[4]),
			                        Integer.parseInt(studentInfoArr[5]),
			                        studentInfoArr[6]));
		}
		insert.sort();
        System.out.println(insert);
	}

}