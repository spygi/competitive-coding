package Chapter9;

/**
 * Created by sg on 07.03.18.
 */
public class Question2
{
    static long calculatePaths( int x, int y )
    {
        if ( (x == 0 && y == 0) || x < 0 || y < 0 ) {
            return (long)0;
        } else if ( (x == 0 && y == 1) || (x == 1 && y == 0) ) {
            return (long)1;
        }

        return calculatePaths( x - 1, y ) + calculatePaths( x, y - 1 );
    }

    public static void main( String[] args )
    {
        System.out.println( calculatePaths( 2, 5 ) );
    }
}
