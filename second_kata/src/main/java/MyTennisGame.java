
public class MyTennisGame implements TennisGame {

    private final MyTennisPlayer player1;
    private final MyTennisPlayer player2;

    public MyTennisGame(String player1Name, String player2Name) {
        this.player1 = new MyTennisPlayer(player1Name);
        this.player2 = new MyTennisPlayer(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            this.player1.wonPoint();
        } else {
            this.player2.wonPoint();
        }
    }
    
    public String getScore() {
        final int player1Score = player1.getScore();
        final int player2Score = player2.getScore();
        final int scoreDifference = Math.abs(player1Score - player2Score);
        
        if ((player1Score < 4 && player2Score < 4) && player1Score + player2Score < 6) {
            return MyTennisPlayerScores.SCORE_MAP.get(player1Score) + "-" + (scoreDifference == 0 ? "All" : MyTennisPlayerScores.SCORE_MAP.get(player2Score));
        } else {
            final String winningPlayerName = getWinningPlayerName(player1Score, player2Score);
            return MyTennisGameStateScores.SCORE_DIFFERENCE_MAP.getOrDefault(scoreDifference, "Win for ") + winningPlayerName;
        }
    }
    
    private String getWinningPlayerName(int player1Score, int player2Score) {
        String winningPlayerName = "";
        if (player1Score > player2Score) {
            winningPlayerName = player1.getName();
        }
        if (player1Score < player2Score) {
            winningPlayerName = player2.getName();
        }
        
        return winningPlayerName;
    }
}
