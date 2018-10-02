class Insertion {
	Team[] teams;
	int size;
	Insertion() {
		size = 0;
		teams = new Team[100];
	}
	public void addTeam(final Team team) {
		teams[size++] = team;
	}
	public Team getTeam(final int index) {
		return teams[index];
	}
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
	public void exch(final Team[] team, final int i, final int j) {
		Team temp = teams[i];
		teams[i] = teams[j];
		teams[j] = temp;
	}
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