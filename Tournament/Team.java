/**
 * Represents a team participating in a tournament.
 */
public class Team {
    private final String teamName;
    private int score;
    private static int teamCounter;

    /**
     * Creates a new Team with the given team name.
     *
     * @param teamName the name of the team
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.score = 0;
        teamCounter++;
    }

    /**
     * Returns the name of the team.
     *
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Returns the score of the team.
     *
     * @return the team score
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the number of teams created so far.
     *
     * @return the team counter
     */
    public static int getTeamCounter() {
        return teamCounter;
    }

    /**
     * Adds the given score to the team's current score.
     *
     * @param score the score to add
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * Returns a string representation of the team.
     *
     * @return a string representation of the team
     */
    @Override
    public String toString() {
        return "Team: " + teamName + ", Score: " + score;
    }
}
