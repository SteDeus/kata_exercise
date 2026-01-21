class GameStateAdvantage implements GameState {
    private final MyTennisGame2 game;
    private final String namePlayer1;
    private final String namePlayer2;
    private final String leadingPlayer;

    GameStateAdvantage(MyTennisGame2 game, String namePlayer1, String namePlayer2, String leadingPlayer) {
        this.game = game;
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
        this.leadingPlayer = leadingPlayer;
    }

    public void player1Scores() {
        if (leadingPlayer.equals(namePlayer1)) {
            game.setGameState(new GameStateWin(namePlayer1));
        } else {
            game.setGameState(new GameStateDeuce(game, namePlayer1, namePlayer2));
        }
    }

    public void player2Scores() {
        if (leadingPlayer.equals(namePlayer2)) {
            game.setGameState(new GameStateWin(namePlayer2));
        } else {
            game.setGameState(new GameStateDeuce(game, namePlayer1, namePlayer2));
        }
    }

    public String asString() {
        return "Advantage " + leadingPlayer;
    }
}
