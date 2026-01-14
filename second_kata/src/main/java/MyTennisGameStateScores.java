import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyTennisGameStateScores {
    public static final Map<Integer, String> SCORE_DIFFERENCE_MAP;

    static {
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(0, "Deuce");
        tempMap.put(1, "Advantage ");
        SCORE_DIFFERENCE_MAP = Collections.unmodifiableMap(tempMap);
    }
}