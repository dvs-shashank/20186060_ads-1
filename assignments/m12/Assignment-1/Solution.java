import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	static int qstud;
	static int vacancy;
	static int open;
	static int bc;
	static int sc;
	static int st;
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
		qstud = qualifiedStudents;
		int vacancies = Integer.parseInt(yuvi.nextLine());
		vacancy = vacancies;
		int unreservedVacancies = Integer.parseInt(yuvi.nextLine());
		open = unreservedVacancies;
		int bcVacancies = Integer.parseInt(yuvi.nextLine());
		bc = bcVacancies;
		int scVacancies = Integer.parseInt(yuvi.nextLine());
		sc = scVacancies;
		int stVacancies = Integer.parseInt(yuvi.nextLine());
		st = stVacancies;
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