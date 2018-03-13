package Chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by sg on 06.03.18.
 */
public class Question4
{
    public static String encodeSpaces1( String text )
    {
        // text.chars() to get a stream from a String
        return text.replaceAll( " ", "%20" );
    }

    public static void main( String[] args )
    {
        String[] texts = new String[] { "", "a", " ", " b", "c ", " d ", "ed css" };
        for ( String text : texts ) {
            System.out.println( encodeSpaces1( text ) );
        }
        System.out.println( "%".toCharArray().length );
    }
}
