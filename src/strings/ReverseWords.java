package strings;

import java.util.ArrayDeque;


/**
 * Leetcode 151 and EPI 6.6 (without using external methods)
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        s = s.trim();

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String word : s.split("\\s+")) {
            stack.push(word);
        }

        StringBuilder bob = new StringBuilder();
        if (!stack.isEmpty()) {
            bob.append(stack.pop());
        }
        while (!stack.isEmpty()) {
            bob.append(" ");
            bob.append(stack.pop());
        }

        return bob.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(""));
        System.out.println(reverseWords(null));
        System.out.println(reverseWords("    "));
        System.out.println(reverseWords("hello"));
        System.out.println(reverseWords("  hello "));
        System.out.println(reverseWords("  hello  world "));
    }
}
