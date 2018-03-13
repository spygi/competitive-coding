package Chapter17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by sg on 08.03.18.
 */
public class Question12
{
    /**
     * Same as Cimpress 3rd problem
     */
    static void compliments( int k, int[] A )
    {
        Set<Integer> map = new HashSet<>();
        for ( int i : A ) {
            if ( map.contains( k - i ) ) {
                System.out.println( i + " " + (k - i) );
                // if we need just the number we can hold the pairs in a data structure and count at the end
            }
            map.add( i );
        }
    }

    public static void main( String[] args )
    {
        compliments( 3, new int[] { 2, 1, 1, 0, 4, -1 } );
    }
}
