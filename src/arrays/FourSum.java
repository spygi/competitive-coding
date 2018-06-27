package arrays;

import java.util.*;

/**
 * Leetcode 18.
 * Accepted but 350ms runtime..
 */
class CustomArrayList<Integer> extends ArrayList<Integer> {
    /**
     * We use a Set to filter duplicate lists. Another way to detect duplicate lists would be to ensure that a list we insert
     * is always in-order or use a non-mutable key/hash for it.
     * <p>
     * ArrayList uses the AbstractList's implementations for equals and hashcode.
     * In them a list is equal to another if it contains the same elements in the same order.
     * <p>
     * In this problem we don't care about the order of the elements. Why not use a set then?
     * Because we could have duplicate elements (which the Set would eliminate)!
     * <p>
     * Set<List<Integer>> s = new HashSet<>();
     * s.add(Arrays.asList(new Integer[]{1,2,3}));
     * s.add(Arrays.asList(new Integer[]{2,3,1})); // returns true where it should be false
     */
    @Override
    public int hashCode() {
        Iterator<Integer> itThis = this.iterator();
        Set<Integer> setThis = new HashSet<>();
        while (itThis.hasNext()) {
            setThis.add(itThis.next());
        }

        return setThis.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        Iterator<Integer> itThis = this.iterator();
        Iterator<Integer> itOther = ((CustomArrayList) o).iterator(); // ListIterator<?> e2 = ((List<?>) o).listIterator();
        Set<Integer> setThis = new HashSet<>();
        Set<Integer> setOther = new HashSet<>();
        while (itThis.hasNext()) {
            setThis.add(itThis.next());
            setOther.add(itOther.next());
        }

        return setThis.equals(setOther);
    }
}

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // removing duplicates here would alter the possible outcomes by reusing a number.
        List<Integer> sortedCopy = new ArrayList<>(nums.length); // new ArrayList(Arrays.asList(nums)) does not work
        for (int i = 0; i < nums.length; i++) {
            sortedCopy.add(nums[i]);
        }
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]) // heuristic: avoid calculating the same sets for the same numbers
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> numCopy = new ArrayList(sortedCopy);
                Integer numJ = numCopy.remove(j); // remove first the later element in order not to mess the order of the list
                Integer numI = numCopy.remove(i);
                for (List<Integer> l : twoSum(numCopy, target - numI - numJ)) {
                    l.add(numI);
                    l.add(numJ);
                    res.add(l);
                }
            }
        }

        // convert to list for the problem
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(res);
        return result;
    }

    public static List<List<Integer>> twoSum(List<Integer> nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int small = 0, large = nums.size() - 1;
        while (small < large) {
            if (nums.get(small) + nums.get(large) > target) {
                large--;
            } else if (nums.get(small) + nums.get(large) < target) {
                small++;
            } else {
                List<Integer> r = new CustomArrayList<>(); // 2 are added now and 2 are the ones we removed before
                r.add(nums.get(small));
                r.add(nums.get(large));

                res.add(r);
                // keep looking in case there are more - filter out duplicates at the end
                // we could increase small or decrease large, it doesn't really matter
                small++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
