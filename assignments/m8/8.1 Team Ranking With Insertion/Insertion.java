class Insertion {
	/**
	 * teams variable.
	 */
	Team[] teams;
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
		teams = new Team[100];
	}
	/**
	 *
	 *time complexity 1.
	 *
	 * Adds a team.
	 *
	 * @param      team  The team
	 */
	public void addTeam(final Team team) {
		teams[size++] = team;
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
	public Team getTeam(final int index) {
		return teams[index];
	}
	/**
	 *time complexity 1.
	 *
	 * sorting mechanism.
	 */
	public void sort() {
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (teams[j].less(teams[j - 1])) {
					exch(teams, j, j - 1);
					//sir ni adgali ee line
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
	public void exch(final Team[] team, final int i, final int j) {
		Team temp = teams[i];
		teams[i] = teams[j];
		teams[j] = temp;
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
			s += teams[i].getTeam() + ",";
		}
		s += teams[i].getTeam();
		return s;
	}
}