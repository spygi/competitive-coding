package arrays;

import java.util.*;

/**
 * Leetcode 220
 */
public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0 || nums == null || nums.length == 0)
            return false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long) (nums[i]) - (long) nums[j]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * HashMap method mapping indices to values for small k,
     * or values to indices for small t.
     */

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k == 0 || nums == null || nums.length == 0)
            return false;

        for (int i = 0; i < nums.length; i++) {
            if (twoSum(Arrays.copyOfRange(nums, i, Math.min(i + k, nums.length)), t))
                return true;
        }

        return false;
    }

    public static boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int small = 0, large = nums.length - 1;
        while (small < large) {
            if (Math.abs((long) nums[small] - (long) nums[large]) > target) {
                large--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647));
    }
}
