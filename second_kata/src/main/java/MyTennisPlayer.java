
public class MyTennisPlayer {
    private final String name;

    private int score;

    public MyTennisPlayer(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    void wonPoint(String playerName) {
        this.score++;
    }
}
