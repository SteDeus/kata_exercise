class GameStateWin implements GameState {
    private final String winner;

    GameStateWin(String winner) {
        this.winner = winner;
    }

    public void player1Scores() {} // Game over
    public void player2Scores() {}

    public String asString() {
        return "Win for " + winner;
    }
}
