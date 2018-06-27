package strings;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Leetcode Problem 3
 * Solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class LongestSubstring {
    // fails at dvdf for example because duplicates appearing later are removed from the set
    public static int wrong(String s) {
        Set<String> unique = new LinkedHashSet<>();

        for (char c: s.toCharArray()) {
            unique.add(c + "");
        }

        String sub = String.join("", unique);
        int length = sub.length();
        for (int i = 0; i <= length/2; i++ ) {
            if (s.contains(sub.substring(i)) || s.contains(sub.substring(0, length - i))) {
                return length - i;
            }
        }

        return 0;
    }

    // n^2
    public static int better(String s) {
        Set<Character> unique = new HashSet<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            maxLength = Math.max(unique.size(), maxLength);
            unique =  new HashSet<>(); // HashSet does not implement removeAll?
            unique.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!unique.add(s.charAt(j))) {
                    break;
                }
                // else if j == s.length()-1 store the maxLength
            }
        }

        return Math.max(unique.size(), maxLength);
    }

    public static void main(String[] args) {
        System.out.println(better("abcabcbb"));
        System.out.println(better("bbbb"));
        System.out.println(better("dvdf"));
    }
}
