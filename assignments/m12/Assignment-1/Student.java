/**
 * Class for student.
 */
class Student {
    /**
     * magic number.
     */
    public int SEVEN = 6;
    /**
     * Constructs the object.
     */
    Student() {

    }
    /**
     * stdName variable.
     */
    private String stdName;
    /**
     * loss variable.
     */
    private String dob;
    /**
     * sub1Marks variable.
     */
    private int sub1Marks;
    /**
     * sub2Marks variable.
     */
    private int sub2Marks;
    /**
     * sub3Marks.
     */
    private int sub3Marks;
    /**
     * totalMarks.
     */
    private int totalMarks;
    /**
     * reservation.
     */
    private String reservation;


    /**
     * Constructs the object.
     *
     * time complexity 1.
     *
     * @param      studName     The stud name
     * @param      dateOfBirth  The date of birth
     * @param      marks1       The marks 1
     * @param      marks2       The marks 2
     * @param      marks3       The marks 3
     * @param      totMarks     The total marks
     * @param      category     The category
     */
    Student(final String studName, final String dateOfBirth, final int marks1,
            final int marks2, final int marks3,
            final int totMarks, final String category) {
        this.stdName = studName;
        this.dob = dateOfBirth;
        this.sub1Marks = marks1;
        this.sub2Marks = marks2;
        this.sub3Marks = marks3;
        this.totalMarks = totMarks;
        this.reservation = category;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return this.reservation;
    }
    /**
     * Gets the student.
     *
     * @return     The student.
     */
    public String getStudent() {
        return this.stdName;
    }
    /**
     * Gets the total marks.
     *
     * @return     The total marks.
     */
    public int getTotalMarks() {
        return this.totalMarks;
    }
    /**
     * Gets the sub 3 marks.
     *
     * @return     The sub 3 marks.
     */
    public int getSub3Marks() {
        return this.sub3Marks;
    }
    /**
     * Gets the sub 2 marks.
     *
     * @return     The sub 2 marks.
     */
    public int getSub2Marks() {
        return this.sub2Marks;
    }
    /**
     * Gets the dob.
     *
     * @return     The dob.
     */
    public String getDob() {
        return this.dob;
    }
    /**
     * less than comparision.
     *
     *time complexity 1.
     *
     * @param      other  The other
     *
     * @return     true if less, else false.
     */
    public boolean less(final Student other) {
        return this.compareTo(other) > 0;
    }
    /**
     * comparing objects.
     *
     *time complexity 1.
     *
     * @param      object  The object
     *
     * @return     integer value based on values we get.
     */
    public int compareTo(final Object object) {
        //@Override
        Student other = (Student) object;
        if (this.getTotalMarks() > other.getTotalMarks()) {
            return +1;
        } else if (this.getTotalMarks() < other.getTotalMarks()) {
            return -1;
        }
        if (this.getSub3Marks() > other.getSub3Marks()) {
            return -1;
        } else if (this.getSub3Marks() < other.getSub3Marks()) {
            return +1;
        }
        if (this.getSub2Marks() > other.getSub2Marks()) {
            return +1;
        } else if (this.getSub2Marks() < other.getSub2Marks()) {
            return -1;
        } 
        if (Integer.parseInt(this.dob.substring(SEVEN))
            > Integer.parseInt(other.dob.substring(SEVEN))) {
            return +1;
        } else if (Integer.parseInt(this.dob.substring(SEVEN))
            < Integer.parseInt(other.dob.substring(SEVEN))) {
            return -1;
        }
        return 0;
    }
}
