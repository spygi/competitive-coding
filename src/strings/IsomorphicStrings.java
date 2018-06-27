package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<String, String> dictS = new HashMap<>(); // could use a bidirectional map instead
        Map<String, String> dictT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String currT = t.charAt(i) + ""; // works since s and t are guaranteed to have the same length
            String currS = s.charAt(i) + "";

            String existingMapping1 = dictS.putIfAbsent(currS, currT);
            String existingMapping2 = dictT.putIfAbsent(currT, currS);

            if (existingMapping1 != null && !existingMapping1.isEmpty() && !existingMapping1.equals(currT))
                return false;

            if (existingMapping2 != null && !existingMapping2.isEmpty() && !existingMapping2.equals(currS))
                return false; // invariant: No two characters may map to the same character
        }

        return true;
    }

    /**
     * Works by mapping characters to indices for both strings.
     * If a new mapping is being created: put returns null, otherwise the index where it was created which should be the same.
     */
    public static boolean isIsomorphic1(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(Integer i = 0; i < s1.length(); i++) {
            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic1("egg", "add"));
        System.out.println(isIsomorphic1("foo", "bar"));
        System.out.println(isIsomorphic1("aa", "ab"));
        System.out.println(isIsomorphic1("ab", "aa"));
    }
}
