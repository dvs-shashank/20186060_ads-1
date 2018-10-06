class Insertion {
	/**
	 * Students variable.
	 */
	Student[] students;
	/**
	 * size variable.
	 */
	int size;
	/**
	 *
	 *time complexity 1.
	 *
	 * Constructs the object.
	 */
	Insertion() {
		size = 0;
		students = new Student[100];
	}
	/**
	 *
	 *time complexity 1.
	 *
	 * Adds a Student.
	 *
	 * @param      Student  The Student
	 */
	public void addStudents(final Student std) {
		students[size++] = std;
	}
	/**
	 * Gets the team.
	 *
	 * time complexity 1.
	 *
	 * @param      index  The index
	 *
	 * @return     The team.
	 */
	public Student getStudent(final int index) {
		return students[index];
	}
	/**
	 *time complexity 1.
	 *
	 * sorting mechanism.
	 */
	public void sort() {
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (students[j].less(students[j - 1])) {
					exch(students, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
	/**
	 * swap objects.
	 *
	 * time complexity 1.
	 *
	 * @param      team  The team
	 * @param      i     index
	 * @param      j     index
	 */
	public void exch(final Student[] student, final int i, final int j) {
		Student temp = students[i];
		students[i] = students[j];
		students[j] = temp;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 *time complexity n.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			String cat = students[i].getCategory();
			if (Solution.qstud > 0) {
				if (cat.equals("SC")) {
					if (Solution.sc > 0) {
						Solution.sc--;
						s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
						s += "\n";

					} else {
						s += "\n";
						break;
					}
					cat = students[i].getCategory();
					s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
				}

				if (cat.equals("ST")) {
					if (Solution.st > 0) {
						Solution.st--;
						s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
						s += "\n";

					} else {
						s += "\n";
						break;
					}
					cat = students[i].getCategory();
					s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
				}

				if (cat.equals("BC")) {
					if (Solution.bc > 0) {
						Solution.bc--;
						s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
						s += "\n";

					} else {
						s += "\n";
						break;
					}
					cat = students[i].getCategory();
					s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
				}

			}

			if (cat.equals("Open")) {
				if (Solution.open > 0) {
					Solution.open--;
					s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
					s += "\n";

				} else {
					s += "\n";
					break;
				}
				cat = students[i].getCategory();
				s += students[i].getStudent() + "," + students[i].getTotalMarks() + "," + cat;
			}
		}


		return s;
	}
}