/**
 * Class for tournament.
 */
class Tournament implements Comparable {
	private int wins;
	private int loss;
	private int draws;
	private String teamName;
	/**
	 * Constructs the object.
	 */
	Tournament(String teamName, int wins, int loss, int draws) {
		this.wins = wins;
		this.loss = loss;
		this.draws = draws;
		this.teamName = teamName;
	}

	/**
	 * Calculates the leader board.
	 *
	 * @param      tableAsAString  The table as a string
	 */
	public void calculateLeaderBoard(final String tableAsAString) {
		//String[] tokens = tableAsAString.split(",");
		//System.out.println(tableAsAString);
	}
	public int compareTo(Object object) {
		//@Override
		return 0;
	}
}