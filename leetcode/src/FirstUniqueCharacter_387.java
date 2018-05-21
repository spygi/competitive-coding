import java.util.*;


/**
 * Created by sg on 21.05.18.
 */
public class FirstUniqueCharacter_387
{
    static int findFirstUnique( String s )
    {
        Set<String> occurencies = new HashSet<>();
        List<String> candidates = new LinkedList<>();

        String a;
        for ( int i = 0; i < s.length(); i++ ) {
            a = s.charAt( i ) + "";
            if ( !occurencies.contains( a ) ) {
                candidates.add( a );
                occurencies.add( a );
            } else {
                candidates.remove( a );
            }
        }

        if ( candidates.isEmpty() ) {
            return -1;
        }
        return s.indexOf( candidates.get( 0 ) );
    }

    static int findLeastOccurencies( String input )
    {
        Map<String, Integer> occurencies = new LinkedHashMap<>();

        String a;
        for ( int i = 0; i < input.length(); i++ ) {
            a = input.charAt( i ) + "";
            occurencies.put( a, occurencies.getOrDefault( a, 0 ) + 1 );
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>( occurencies.entrySet() );
        list.sort( Map.Entry.comparingByValue() );

        return input.indexOf( list.get( 0 ).getKey() );
    }

    public static void main( String[] args )
    {
        System.out.println( findFirstUnique( "" ) );
    }
}
