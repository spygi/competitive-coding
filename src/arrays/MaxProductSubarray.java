package arrays;

/**
 * Leetcode 152
 * Duplicates are allowed. Zeros as well.
 * <p>
 * Key observation: we need to keep current min *and* max because multiplying with a negative makes min greater than max.
 *
 * The fact that we just need the product makes these problems easier.
 * How to think: Simplify by considering only positive numbers. Then add 0s. Finally add negatives.
 */
public class MaxProductSubarray {
    public static int maxProduct(int A[]) {
        // store the result that is the max we have found so far
        int maxProd = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, currentMax = maxProd, currentMin = maxProd; i < A.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            currentMax = Math.max(A[i], currentMax * A[i]); // if current number is 0 this affects currentMax and currentMin.
            currentMin = Math.min(A[i], currentMin * A[i]);

            // the newly computed max value is a candidate for our global result
            maxProd = Math.max(maxProd, currentMax);
        }
        return maxProd;
    }

    public static void main(String[] args) {
//        System.out.println(maxProduct(new int[]{-3, -5, -7, 0, -1, -2}));
        System.out.println(maxProduct(new int[]{2, 3, 0, 5, 6}));
        System.out.println(maxProduct(new int[]{2, -3, -2, -6, 10}));
        System.out.println(maxProduct(new int[]{2, -3, -2, 0, -6, 10}));

    }
}
