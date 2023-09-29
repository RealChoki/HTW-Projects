import java.util.Arrays;

/**
 * Represents a tournament with multiple teams.
 */
public class Tournament {
    private int gameCount;
    private Team[] teams;

    /**
     * Creates a new tournament with the specified number of teams.
     * If the number of teams is less than 2, it defaults to 2.
     *
     * @param teamsAmount the number of teams in the tournament
     */
    public Tournament(int teamsAmount) {
        if (teamsAmount < 2) {
            teamsAmount = 2;
        }
        teams = new Team[teamsAmount];
        gameCount = 0;
    }

    /**
     * Returns the array of teams in the tournament.
     *
     * @return the teams in the tournament
     */
    public Team[] getTeams() {
        return teams;
    }

    /**
     * Returns the number of games played in the tournament.
     *
     * @return the game count
     */
    public int getGameCount() {
        return gameCount;
    }

    /**
     * Registers a team in the tournament.
     * If all spots are filled, the team is not registered.
     *
     * @param team the team to register
     */
    public void registerTeam(Team team) {
        for (int i = 0; i < teams.length; i++) {
            if (teams[i] == null) {
                teams[i] = team;
                break;
            }
        }
    }

    /**
     * Checks if the tournament is ready to start.
     * Returns true if all spots in the tournament are filled with teams, false otherwise.
     *
     * @return true if the tournament is ready, false otherwise
     */
    public boolean isReady() {
        for (Team spot : teams) {
            if (spot == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Plays a game between two teams in the tournament.
     * The teams compete in at least three rounds, and the winning team gets points based on the random scores generated.
     * The game count is incremented after each game played.
     *
     * @param team1 the first team
     * @param team2 the second team
     */
    public void playGame(Team team1, Team team2) {
        System.out.println(team1.getTeamName() + " vs " + team2.getTeamName());
        int rounds = 3;
        for (int i = 0; i < rounds; i++) {
            int firstRandomScore = (int) (Math.random() * 10);
            int secondRandomScore = (int) (Math.random() * 10);

            if (firstRandomScore > secondRandomScore) {
                team1.addScore(firstRandomScore);
            } else if (secondRandomScore > firstRandomScore) {
                team2.addScore(secondRandomScore);
            } else {
                team1.addScore(firstRandomScore);
                team2.addScore(secondRandomScore);
            }
        }
        this.gameCount++;
    }

    /**
    * Plays the championship round of the tournament.
    * All teams in the tournament play against each other at least twice.
    * The winners of each game are displayed, and the final scores and overall winners are printed.
    */
    public void playChampionship() {
        for (int round = 0; round < 2; round++) {
            System.out.println("Round " + (round + 1) + ":");
            for (int i = 0; i < teams.length; i++) {
                for (int j = i + 1; j < teams.length; j++) {
                    playGame(teams[i], teams[j]);
    
                    if (teams[i].getScore() > teams[j].getScore()) {
                        System.out.println("The " + teams[i].getTeamName() + " won this round !!");
                    } else if (teams[j].getScore() > teams[i].getScore()) {
                        System.out.println("The " + teams[j].getTeamName() + " won this round !!");
                    } else {
                        System.out.println("It's a tie between " + teams[i].getTeamName() + " and " + teams[j].getTeamName());
                    }
                }
            }
        }
        System.out.println("Final scores:");
        printScore();
        System.out.println("The Overall Winner(s):");
        Team[] winners = getWinner();
        for (Team team : winners) {
            System.out.println(team.getTeamName());
        }
    }
    
    /**
    Prints the scores of the teams in the tournament.
    If no games have been played yet, it prints a message indicating that no games have taken place.
    Otherwise, it sorts the teams based on their scores in descending order using the bubble sort algorithm.
    It then prints the team names and their corresponding scores.
    */
    public void printScore() {
    if (gameCount == 0) {
        System.out.println("Bisher fand kein Spiel statt.");
        return;
    }

    Team[] sortedTeams = Arrays.copyOf(teams, teams.length);

    // Bubble sort
    for (int i = 0; i < sortedTeams.length - 1; i++) {
        for (int j = 0; j < sortedTeams.length - i - 1; j++) {
            if (sortedTeams[j].getScore() < sortedTeams[j + 1].getScore()) {
                // Swap teams
                Team temp = sortedTeams[j];
                sortedTeams[j] = sortedTeams[j + 1];
                sortedTeams[j + 1] = temp;
            }
        }
    }

    for (Team team : sortedTeams) {
        System.out.println(team.getTeamName() + ": " + team.getScore());
    }
}

    /**
    Determines the winner(s) of the tournament based on the scores.
    If no games have been played yet, it returns an empty array of teams.
    Otherwise, it finds the highest score and counts the number of teams with that score.
    It then creates an array of the winner(s) and returns it.
    @return an array of teams representing the winner(s) of the tournament
    */
    public Team[] getWinner() {
        if (getGameCount() == 0) {
            return new Team[0];
        } else {
            int highScore = 0;
            int winnerCount = 0;
            for (int i = 0; i < teams.length; i++) {
                int score = teams[i].getScore();

                if (score >= highScore) {
                    highScore = score;
                }
            }

            for (int i = 0; i < teams.length; i++) {
                if (teams[i].getScore() >= highScore) {
                    winnerCount++;
                }
            }
            
            Team[] winner = new Team[winnerCount];
            int index = 0;
            
            for (int i = 0; i < teams.length; i++) {
                if (teams[i].getScore() >= highScore) {
                    winner[index] = teams[i];
                    index++;
                }
            }
            
            return winner;
        }
    }
    /**
    The main method to start the tournament.
    Creates a new tournament with a specified number of teams and registers them.
    If the tournament is ready, the championship is played and the results are displayed.
    Finally, the scores and winners of the tournament are printed.
    */
    public static void main(String[] args){
        Tournament tournament = new Tournament(4);

        Team team1 = new Team("Straw Hats");
        Team team2 = new Team("Blackbeards");
        Team team3 = new Team("Marines");
        Team team4 = new Team("Yonkos");

        tournament.registerTeam(team1);
        tournament.registerTeam(team2);
        tournament.registerTeam(team3);
        tournament.registerTeam(team4);

        if (tournament.isReady()) {
            tournament.playChampionship();
        }
    }
}
