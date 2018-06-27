package strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 402.
 *
 * My solution is too slow.
 * Nice solution https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack
 * using a stack.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        int n = num.length(), l = n - k; // invariant n >= k
        if (l == 0) { // covers also num == null || num.isEmpty() due to the invariant
            return "0";
        } else if (k == 0) {
            return num;
        }

        List<String> sol = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sol.add(num.charAt(i) + "");

            if (sol.size() > l) {
                // remove left most out of order digit
                for (int j = 0; j < l; j++) { // this is the slow part
                    if (sol.get(j).compareTo(sol.get(j + 1)) > 0) {
                        sol.remove(j);
                        break;
                    }
                }
                if (sol.size() > l) {
                    // or the last one if the list is in order, which is the max then
                    sol.remove(l);
                }
            }
        }

        trimLeadingZeros(sol);

        String s = String.join("", sol);
        return s.isEmpty()? "0": s;
    }

    /**
     * Trim leading zeros.
     * <p>
     * Instead of this one could use Integer.valueOf(String.join("", sol), 10).toString()
     * but this overflows on the test cases.
     */
    public static void trimLeadingZeros(List<String> sol) {
        // instead of this to trim one could use
        while (!sol.isEmpty() && sol.get(0).equals("0")) {
            sol.remove(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }
}
