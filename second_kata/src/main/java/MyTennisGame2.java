public class MyTennisGame2 implements TennisGame {
    private GameState gameState;
    private final String namePlayer1;
    private final String namePlayer2;

    public MyTennisGame2(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
        this.gameState = new GameStatePoints(this, this.namePlayer1, this.namePlayer2, 0, 0);
    }

    void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.namePlayer1)) {
            gameState.player1Scores();
        }
        if (playerName.equals(this.namePlayer2)) {
            gameState.player2Scores();
        }
    }

    public String getScore() {
        return gameState.asString();
    }

}
