package Chapter9;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sg on 07.03.18.
 */
public class Question1
{
    public static int countWaysDP( int n, int[] map )
    {
        if ( n < 0 ) {
            return 0;
        } else if ( n == 0 ) {
            return 1;
        } else if ( map[ n ] > 0 ) {
            // we have calculated already a value
            return map[ n ];
        } else {
            map[ n ] = countWaysDP( n - 1, map ) + countWaysDP( n - 2, map ) + countWaysDP( n - 3, map );
            return map[ n ];
        }
    }

    static int iterativeSteps( int n )
    {
        if ( n < 0 ) {
            return 0;
        } else if ( n == 0 ) {
            return 1; // ?
        } else if ( n == 1 ) {
            return 1;
        } else if ( n == 2 ) {
            return 2;
        }

        int k = 3;
        int[] steps = new int[ n + 1 ];
        steps[ 0 ] = 1;
        steps[ 1 ] = 1;
        steps[ 2 ] = 2;
        while ( k <= n ) {
            steps[ k ] = steps[ k - 1 ] + steps[ k - 2 ] + steps[ k - 3 ];
            k++;
        }
        return steps[ k - 1 ];
    }

    public static void main( String[] args )
    {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add( 0 );
                add( 1 );
                add( 2 );
                add( 3 );
                add( 4 );
                add( 5 );
            }
        };
        for ( Integer integer : list ) {
            //            System.out.println( iterativeSteps( integer ) );
            System.out.println( countWaysDP( integer, new int[7] ) );
        }
    }
}
