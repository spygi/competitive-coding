package Chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Question1
{
    public static boolean checkUniquenessWithDataStructure( String test )
    {
        Set<Character> characterSet = new HashSet<>();
        for ( int i = 0; i < test.length(); i++ ) {
            if ( !characterSet.add( test.charAt( i ) ) ) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkUniquenessWithoutDataStructure( String test )
    {
        for ( int i = 0; i < test.length(); i++ ) {
            for ( int j = i + 1; j < test.length(); j++ ) {
                if ( test.charAt( i ) == test.charAt( j ) ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main( String[] args )
    {

    }
}
