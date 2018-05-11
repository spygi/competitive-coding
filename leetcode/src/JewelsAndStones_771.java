import java.util.HashSet;
import java.util.Set;


/**
 * Created by sg on 11.05.18.
 */
public class JewelsAndStones_771
{
    public JewelsAndStones_771()
    {
    }

    public int numJewelsInStones( String J, String S )
    {
        Set<Character> jewels = new HashSet<>();
        for ( int i = 0; i < J.length(); i++ ) {
            jewels.add( J.charAt( i ) ); // J has discrete chars
        }
        return Math.toIntExact( S.chars().filter( c -> jewels.contains( (char)c ) ).count() ); // won't overflow because J and S are of most 50 characters
    }

    public static void main( String[] args )
    {
        System.out.println( new JewelsAndStones_771().numJewelsInStones( "z", "Z" ) );
    }
}
