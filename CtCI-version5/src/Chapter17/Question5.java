package Chapter17;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by sg on 08.03.18.
 */
public class Question5 {
    static void masterMind(String guess, String solution) {
        int hits = 0, nearHits = 0;
        if (guess == null || solution == null || guess.length() != solution.length()) {
            return;
        }

        char tempChar;
        Map<Character, Integer> nearHitsFrequency = new HashMap<>();
        /*
         * Find hits and create frequency map for near-hits.
         * Time: O(n), Space: O(n)
         */
        for (int i = 0; i < solution.length(); i++) {
            tempChar = guess.charAt(i);
            if (tempChar == solution.charAt(i)) {
                hits++;
            } else {
                // put it in the possible near-hits only if it's not a hit
                // because: "a hit can't be considered a near-hit"
                nearHitsFrequency.merge(solution.charAt(i), 1, Integer::sum);
            }
        }

        /*
         * Find near-hits. Time O(n)
         */
        for (int i = 0; i < guess.length(); i++) {
            tempChar = guess.charAt(i);
            if (nearHitsFrequency.getOrDefault(tempChar, 0) > 0) {
                nearHits++;
                nearHitsFrequency.put(tempChar, nearHitsFrequency.get(tempChar) - 1);
            }
        }

        System.out.println(hits + " " + nearHits);
    }

    public static void main(String[] args) {
        String solution = "RGBYRB";
        String guess = "GGRRBR";
        masterMind(guess, solution);
    }
}
