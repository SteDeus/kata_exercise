class GameStatePoints implements GameState {
    private int scorePlayer1, scorePlayer2;
    private final String[] desc = {"Love", "Fifteen", "Thirty", "Forty"};
    private final MyTennisGame2 game;
    private final String namePlayer1;
    private final String namePlayer2;

    GameStatePoints(MyTennisGame2 game, String namePlayer1, String namePlayer2, int scorePlayer1, int scorePlayer2) {
        this.game = game;
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    public void player1Scores() {
        scorePlayer1++;
        update();
    }

    public void player2Scores() {
        scorePlayer2++;
        update();
    }

    private void update() {
        if (scorePlayer1 == 3 && scorePlayer2 == 3) {
            game.setGameState(new GameStateDeuce(game, namePlayer1, namePlayer2));
        }
        if (scorePlayer1 > 3) {
            game.setGameState(new GameStateWin(namePlayer1));
        } else if (scorePlayer2 > 3) {
            game.setGameState(new GameStateWin(namePlayer2));
        }
    }

    public String asString() {
        return (scorePlayer1 == scorePlayer2) ? desc[scorePlayer1] + "-All" : desc[scorePlayer1] + "-" + desc[scorePlayer2];
    }
}