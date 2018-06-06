package unclassified;

import java.util.PriorityQueue;

/**
 * As seen in Ctci page 54 and EPI page 156.
 *
 * Numbers are generated randomly and stored in an expanding array.
 * How would you keep track of the median?
 */
public class FindMedian {

    /**
     * Uses one maxheap. Solves the problem for fixed array.
     * Space: O(n/2), time: O(n logn/2)
     *
     * Notes:
     * This solution can be adapted for streaming ints/consequent runs.
     * Similar to the topK algo in EPI page 150, where k=n/2.
     * It can be solved with a min heap too and reverting the if statement to insert a new head.
     *
     * Optimal solution uses 2 heaps, O(logn) time, found in EPI. For streaming ints you need O(n) space for the consequent runs.
     * Sorting first and then peeking the medium would be slightly worse O(nlogn)
     */
    public static double median(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(A.length / 2 + 1, (a, b) -> Integer.compare(b, a));

        for (int i = 0; i < A.length / 2 + 1; i++) {
            maxHeap.add(A[i]);
        }

        for (int i = A.length / 2 + 1; i < A.length; i++) { // can be written as a single loop
            if (A[i] < maxHeap.peek()) {
                maxHeap.add(A[i]);
                maxHeap.poll();
            }
        }

        return A.length % 2 == 0 ? (maxHeap.poll() + maxHeap.poll()) * 0.5 : maxHeap.poll();
    }

    public static void main(String[] args) {
        System.out.println(median(new int[]{2, 0, 3, 1}));
    }

}
