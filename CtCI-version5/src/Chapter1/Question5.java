package Chapter1;

import java.nio.CharBuffer;


/**
 * Created by sg on 06.03.18.
 */
public class Question5
{
    static String compress( String str )
    {
        if ( str.isEmpty() ) {
            return str;
        }

        StringBuffer bob = new StringBuffer();
        char currentChar = str.charAt( 0 );
        int currentCounter = 1;
        bob.append( currentChar );

        for ( int i = 1; i < str.length(); i++ ) {
            char tempChar = str.charAt( i );
            if ( currentChar != tempChar ) {
                // new character is encountered
                bob.append( currentCounter );
                bob.append( tempChar );

                currentChar = tempChar;
                currentCounter = 1;
            } else {
                currentCounter++;
            }
        }
        bob.append( currentCounter );

        return bob.length() < str.length() ? bob.toString() : str;
    }

    public static void main( String[] args )
    {
        String[] strings = new String[] { "", " ", "a", "aa", "aa ", "aa bbb", "aaabbccccc" };
        for ( String string : strings ) {
            System.out.println( compress( string ) );
        }
    }
}
