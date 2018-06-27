package unclassified;

import java.util.Arrays;

/**
 * 17.6 in Ctci
 */
public class ShortestSequenceToSorted {
    public static void main(String[] args) {
        System.out.println(almostSorted(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}));
        System.out.println(almostSorted(new int[]{1, 5, 4}));
        System.out.println(almostSorted(new int[]{5, 4}));
        System.out.println(almostSorted(new int[]{0, 1, 4, 5, 4, 6, 8}));
    }

    public static String almostSorted(int[] input) {
        int[] tmp = input.clone();
        Arrays.sort(input); // nlogn

        int minIndex = -1, maxIndex = input.length;
        // n complexity
        for (int i = 0; (i < input.length) && (minIndex == -1 || maxIndex == input.length); i++) {
            if (input[i] != tmp[i] && minIndex == -1) {
                minIndex = i;
            }
            if (input[input.length - i - 1] != tmp[input.length - i - 1] && maxIndex == input.length) {
                maxIndex = input.length - i - 1;
            }
        }
        return minIndex + " " + maxIndex;
    }

}
