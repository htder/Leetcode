import java.util.*;

class Program {
  public static String tournamentWinner(
    ArrayList<ArrayList<String>> competitions,
    ArrayList<Integer> results
  ) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int highestScore = 0;
    String team = "";

    for (int i = 0; i < competitions.size(); i++) {
      String homeTeam = competitions.get(i).get(0);
      String awayTeam = competitions.get(i).get(1);
      String winner = results.get(i) === 0 ? awayTeam : homeTeam;

      int newScore = 3;
      if (map.containsKey(winner)) {
        newScore = map.get(winner) + 3;
      }
      map.put(winner, newScore);

      if (newScore > highestScore) {
        highestScore = newScore;
        team = winner;
      }
    }
    return team;
  }
}
