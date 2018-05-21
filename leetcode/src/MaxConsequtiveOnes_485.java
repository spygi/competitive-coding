/**
 * Created by sg on 21.05.18.
 */
public class MaxConsequtiveOnes_485
{
    static int maxOnes( int[] nums )
    {
        int max = 0, currMax = 0;
        for ( int i : nums ) {
            if ( i == 1 ) {
                currMax++;
            } else {
                max = Math.max( currMax, max );
                currMax = 0;
            }
        }
        return Math.max( max, currMax );
    }

    public static void main( String[] args )
    {
        int[] input = { 1, 1, 0, 1, 1, 1 };
        System.out.println( maxOnes( input ) );
    }
}
