class Selection {
	/**
	 * team variable.
	 */
    private Team[] teams;
    /**
     * size is of type int.
     */
    private int size;
    /**
     * Time complexity is 1.
     * Constructs the object.
     */
    Selection() {
        teams = new Team[100];
        size = 0;
    }
    /**
     * Adds a Team.
     * Time complexity is 1.
     * @param      t     t is of type Team.
     */
    public void addTeam(final Team t) {
		teams[size++] = t;
    }
    /**
     * Gets the Team.
     * Time complexity is 1.
     * @param      index  The index
     *
     * @return     The Team.
     */
    public Team getTeam(final int index) {
        return teams[index];
    }
    /**
     * Time complexity is N^2.
     * sort method is used to sort.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (teams[j].less(teams[min])) {
                    min = j;
                }
            }
            exch(teams, i, min);
        }
    }
    /**
     * exch is a method to swap.
     * Time complexity is N.
     * @param      a     a is of type Team.
     * @param      i     i is of type int.
     * @param      j     j is of type int.
     */
    public void exch(final Team[] a, final int i, final int j) {
        Team temp = teams[i];
        teams[i] = teams[j];
        teams[j] = temp;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is N.
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
        s += teams[i].getTeam() + ",";
        }
        s += teams[i].getTeam();
        return s;
    }
}