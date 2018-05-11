import java.util.Arrays;


/**
 * Created by sg on 04.05.18.
 */
public class RemoveDuplicates_26
{
    int currentStart;
    int finalLen;


    public RemoveDuplicates_26()
    {
        currentStart = 0;
        finalLen = -1;
    }

    public void shiftLeft( int[] nums, int index )
    {
        for ( int j = index + 1; j < finalLen; j++ ) {
            nums[ j - 1 ] = nums[ j ];
        }
        finalLen--;
    }

    public int removeDuplicates( int[] nums )
    {
        finalLen = nums.length;

        while ( currentStart < finalLen - 1 ) {
            int currentlyChecked = nums[ currentStart ];
            try {
                int duplIndex = Arrays.binarySearch( nums, currentStart + 1, finalLen, currentlyChecked );
                while ( duplIndex >= 0 ) {
                    shiftLeft( nums, duplIndex );
                    // continue looking because binary search can return anything
                    duplIndex = Arrays.binarySearch( nums, currentStart + 1, finalLen, currentlyChecked );
                }
            } catch ( IllegalArgumentException e ) {
                //  can happen due to second binary search
                // TODO: remove this
                return finalLen;
            }
            currentStart++;
        }

        return finalLen;
    }

    public int removeDuplicatesRecursive( int[] nums )
    {
        if ( finalLen == -1 ) { // first recursion
            finalLen = nums.length;
        }

        if ( currentStart >= finalLen - 1 ) {
            return finalLen;
        }

        int currentlyChecked = nums[ currentStart ];
        try {
            int duplIndex = Arrays.binarySearch( nums, currentStart + 1, finalLen, currentlyChecked );
            while ( duplIndex >= 0 ) {
                shiftLeft( nums, duplIndex );
                // continue looking because binary search can return anything
                duplIndex = Arrays.binarySearch( nums, currentStart + 1, finalLen, currentlyChecked );
            }
        } catch ( IllegalArgumentException e ) {
            //  can happen
            return finalLen;
        }
        currentStart++;

        return removeDuplicatesRecursive( nums );
    }

    public static void main( String[] args )
    {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int len = new RemoveDuplicates_26().removeDuplicates( nums );
        for ( int i = 0; i < len; i++ ) {
            System.out.print( nums[ i ] + " " );
        }
    }
}
