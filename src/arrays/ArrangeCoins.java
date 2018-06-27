package arrays;

/**
 * Leetcode 441
 */
public class ArrangeCoins {
    // Iterative beats 29%
    public int arrangeCoins(int n) {
        if (n == 0)
            return 0;

        int i = 0;
        while (n > 0) {
            i++;
            n -= i;
        }

        return n == 0 ? i : i - 1;
    }

    /**
     * Numeric beats 43%
     *
     * Uses the sum of arithmetic series formula.
     */
    public int arrangeCoins2(int n) {
        // 8.0 is needed for big n: converts to float to avoid overflowing (long would be better here?)
        // we take only the positive sqrt from the quadratic solution
        // (int) just truncates the decimal part

        return (int)((-1 + Math.sqrt(1+8.0*n))/2);
    }
}
