package arrays;

import java.util.PriorityQueue;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>(nums.length, (a, b) -> b.compareTo(a));
        for (int i : nums) {
            maxHeap.add(i + "");
        }

        StringBuilder bob = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            bob.append(maxHeap.poll());
        }

        return bob.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{}));
        System.out.println(largestNumber(null));
        System.out.println(largestNumber(new int[]{0}));
        System.out.println(largestNumber(new int[]{1}));
        System.out.println(largestNumber(new int[]{1, 0}));
        System.out.println(largestNumber(new int[]{1, 1}));
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
