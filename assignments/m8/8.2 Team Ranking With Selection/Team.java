/**
 * Class for Team.
 */
class Team implements Comparable {
	/**
	 * wins variable.
	 */
	private int wins;
	/**
	 * loss variable.
	 */
	private int loss;
	/**
	 * draws variable.
	 */
	private int draws;
	/**
	 * teamName variable.
	 */
	private String teamName;
	/**
	 *time complexity 1.
	 * Constructs the object.
	 */
	Team(String teamName, int wins, int loss, int draws) {
		this.wins = wins;
		this.loss = loss;
		this.draws = draws;
		this.teamName = teamName;
	}
	/**
	 * Gets the team.
	 *
	 *time complexity 1.
	 * @return     The team.
	 */
	public String getTeam() {
		return this.teamName;
	}
	/**
	 * Gets the wins.
	 *
	 *time complexity 1.
	 *
	 * @return     The wins.
	 */
	public int getWins() {
		return this.wins;
	}
	/**
	 * Gets the losses.
	 * 
	 * time complexity 1.
	 *
	 * @return     The losses.
	 */
	public int getLosses() {
		return this.loss;
	}
	/**
	 * Gets the draws.
	 *
	 *time complexity 1.
	 *
	 * @return     The draws.
	 */
	public int getDraws() {
		return this.draws;
	}
	/**
	 * less than comparision.
	 *
	 *time complexity 1.
	 *
	 * @param      other  The other
	 *
	 * @return     less teams.
	 */
	public boolean less(final Team other) {
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
		Team other = (Team) object;
        if (this.getWins() > other.getWins()) {
            return +1;
        } else if (this.getWins() < other.getWins()) {
            return -1;
        }
        if (this.getLosses() > other.getLosses()) {
            return -1;
        } else if (this.getLosses() < other.getLosses()) {
            return +1;
        }
        if (this.getDraws() > other.getDraws()) {
            return +1;
        } else if (this.getDraws() < other.getDraws()) {
            return -1;
        }
        return 0;
    }
}