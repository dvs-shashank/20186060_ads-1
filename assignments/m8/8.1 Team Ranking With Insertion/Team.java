/**
 * Class for Team.
 */
class Team implements Comparable {
	private int wins;
	private int loss;
	private int draws;
	private String teamName;
	/**
	 * Constructs the object.
	 */
	Team(String teamName, int wins, int loss, int draws) {
		this.wins = wins;
		this.loss = loss;
		this.draws = draws;
		this.teamName = teamName;
	}
	public String getTeam() {
		return this.teamName;
	}
	public int getWins() {
		return this.wins;
	}
	public int getLosses() {
		return this.loss;
	}
	public int getDraws() {
		return this.draws;
	}
	public boolean less(final Team other) {
		return this.compareTo(other) > 0;
	}
	
	public int compareTo(final Object object) {
		//@Override
		Team other = (Team) object;
		if (this.getWins() > other.getWins()) {
			return 1;
		} else if(this.getWins() < other.getWins()) {
			return -1;
		}
		if (this.getLosses() > other.getLosses()) {
			return 1;
		} else if(this.getLosses() < other.getLosses()) {
			return -1;
		}
		if (this.getDraws() > other.getDraws()) {
			return 1;
		} else if(this.getDraws() < other.getDraws()) {
			return -1;
		}
		return 0;
	}
}