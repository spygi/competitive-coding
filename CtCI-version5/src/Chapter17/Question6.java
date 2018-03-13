package Chapter17;

import java.util.Arrays;


/**
 * Created by sg on 08.03.18.
 */
public class Question6
{
    /*
     * Uses sorting. Time: O(nlogn) due to sorting, Space: O(n)
     */
    static void minSorting( int[] input )
    {
        int minIndex = -1, maxIndex = -1;

        int[] copy = input.clone();
        Arrays.sort( copy );
        for ( int i = 0; i < copy.length; i++ ) {
            // we can break when i > length - i - 1; which gives an O(logn) loop
            if ( copy[ i ] != input[ i ] && minIndex == -1 ) {// it's unset
                minIndex = i;
            }
            if ( copy[ copy.length - i - 1 ] != input[ input.length - i - 1 ] && maxIndex == -1 ) {
                maxIndex = copy.length - i - 1;
            }
            if ( minIndex != -1 && maxIndex != -1 ) {
                // optimization
                break;
            }
        }
        System.out.println( minIndex + " " + maxIndex );
    }

    public static void main( String[] args )
    {
        minSorting( new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 } ); // inbetween
        minSorting( new int[] { 6, 5, 4, 7, 10 } ); // at the start
        minSorting( new int[] { 2, 5, 6, 10, 7 } ); // at the end
        minSorting( new int[] { 2, 6, 5, 7, 10 } ); // in the middle for odd number of elements
        minSorting( new int[] { 2, 4, 7, 5, 11, 12 } ); // in the middle for even number of elements
        minSorting( new int[] { 2, 5, 6, 7, 9 } ); // already sorted
        minSorting( new int[] { 11, 9, 6, 5, 1 } ); // sorted in reverse

        minSorting( new int[] { 2, 7, 7, 5, 7 } ); // with repetions middle to end
        minSorting( new int[] { 2, 7, 7, 7, 5 } );
        minSorting( new int[] { 7, 2, 6, 7, 8 } ); // with repetetions that are in place
        minSorting( new int[] { 7, 2, 7, 6, 8 } ); // with repetetions that are not in place

        // toptal
        minSorting( new int[] { 1, 5, 4, 9, 8, 7, 12, 13, 14 } ); // each index that is already in place counts as +1.
        // From the unsorted ones we need to find the #number of sets
        minSorting( new int[] { 5, 3, 4, 6, 9, 8, 7 } );
    }
}
