        import Chapter1.Question1;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by sg on 05.03.18.
 */

public class Test1
{
    static String[]  testStrings     = new String[] { "", "a", "abc", "aca" };   // weird unicode stuff, not characters etc?
    static boolean[] expectedResults = new boolean[] { true, true, true, false };


    @Test
    public void testWithDataStructure()
    {
        for ( int i = 0; i < testStrings.length; i++ ) {
            assertEquals( Question1.checkUniquenessWithDataStructure( testStrings[ i ] ), expectedResults[ i ] );
        }
    }

    @Test
    public void testWithoutDataStructure()
    {
        for ( int i = 0; i < testStrings.length; i++ ) {
            assertEquals( Question1.checkUniquenessWithoutDataStructure( testStrings[ i ] ), expectedResults[ i ] );
        }
    }
}
