public enum MyTennisPlayerScores {
    LOVE(0, "Love"),
    FIFTEEN(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty");

    private final int value;
    private final String description;

    MyTennisPlayerScores(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static String getDescription(int points) {
        for (MyTennisPlayerScores s : values()) {
            if (s.value == points) return s.description;
        }
        return "Forty";
    }
}