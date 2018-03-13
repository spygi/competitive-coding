package Chapter1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by sg on 06.03.18.
 */
public class Question6
{
    static boolean isRotation( String str1, String str2 )
    {
        if ( str1.length() != str2.length() ) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        Arrays.sort( chars1 );
        char[] chars2 = str2.toCharArray();
        Arrays.sort( chars2 );

        return new String( chars1 ).equals( new String( chars2 ) );
    }


    public static class Pair
    {
        String str1;
        String str2;


        Pair( String str1, String str2 )
        {
            this.str1 = str1;
            this.str2 = str2;
        }
    }


    public static void main( String[] args )
    {
        List<Pair> pairs = new ArrayList<Pair>() {
            {
                add( new Pair( "", "" ) );
                add( new Pair( "", " " ) );
                add( new Pair( " ", "" ) );
                add( new Pair( "a", "a" ) );
                add( new Pair( "ab", "b" ) );
                add( new Pair( "hello", "lohel" ) );
                add( new Pair( "hello world", " worldhello" ) );
            }
        };

        for ( Pair pair : pairs ) {
            System.out.println( isRotation( pair.str1, pair.str2 ) );
        }
    }
}
