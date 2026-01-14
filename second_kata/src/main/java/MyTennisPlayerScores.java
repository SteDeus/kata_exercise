import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyTennisPlayerScores {
    public static final Map<Integer, String> SCORE_MAP;

    static {
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(0, "Love");
        tempMap.put(1, "Fifteen");
        tempMap.put(2, "Thirty");
        tempMap.put(3, "Forty");
        SCORE_MAP = Collections.unmodifiableMap(tempMap);
    }
}