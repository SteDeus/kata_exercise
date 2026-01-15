
public class MyTennisGame implements TennisGame {

    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage ";
    private static final String WIN_FOR = "Win for ";
    private static final String ALL = "All";
    private static final String SCORE_SEPARATOR = "-";

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
            return MyTennisPlayerScores.getDescription(player1Score) + SCORE_SEPARATOR + (scoreDifference == 0 ? ALL : MyTennisPlayerScores.getDescription(player2Score));
        } else {
            final String winningPlayerName = getWinningPlayerName(player1Score, player2Score);
            return getGameStateScore(scoreDifference) + winningPlayerName;
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

    private String getGameStateScore(int scoreDifference) {
        switch (scoreDifference) {
            case 0: return DEUCE;
            case 1: return ADVANTAGE;
            default: return WIN_FOR;
        }
    }
}
