class GameStateDeuce implements GameState {
    private final MyTennisGame2 game;
    private final String namePlayer1;
    private final String namePlayer2;

    GameStateDeuce(MyTennisGame2 game, String namePlayer1, String namePlayer2) {
        this.game = game;
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public void player1Scores() {
        game.setGameState(new GameStateAdvantage(game, namePlayer1, namePlayer2, namePlayer1));
    }

    public void player2Scores() {
        game.setGameState(new GameStateAdvantage(game, namePlayer1, namePlayer2, namePlayer2));
    }

    public String asString() {
        return "Deuce";
    }
}
