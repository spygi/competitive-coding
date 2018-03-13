package Chapter2;

import java.util.*;


/**
 * Created by sg on 07.03.18.
 */
public class Question1
{
    static List<Integer> removeDuplicatesUsingJavaCollectionAndAdditionalSpace( List<Integer> list )
    {
        // Space O(n), Time O(n)
        Set<Integer> set = new HashSet<>();
        List<Integer> newList = new LinkedList<>();
        for ( Integer integer : list ) {
            if ( !set.contains( integer ) ) {
                newList.add( integer );
                set.add( integer );
            }
        }
        return newList;
    }

    static List<Integer> removeDuplicatesInPlaceUsingJavaCollectionAndAdditionalSpace( List<Integer> list )
    {
        // Space O(n), Time O(n)
        Set<Integer> set = new HashSet<>();
        int temp;
        for ( int i = 0; i < list.size(); i++ ) {
            temp = list.get( i );
            if ( set.contains( temp ) ) {
                list.remove( i ); // you can't do this with a fail-fast iterator (as the ones in Collections): throws a ConcurrentModificationException
                i--;
            } else {
                set.add( temp );
            }
        }

        return list;
    }

    static SinglyLinkedList<Integer> removeDuplicatesFromCustomListImplementation( SinglyLinkedList<Integer> list )
    {
        SinglyLinkedList.Node current = list.root;
        SinglyLinkedList.Node runner;
        while ( current != null ) {
            runner = current.next;
            while ( runner != null ) {
                if ( runner.content == current.content ) {
                    current.next = runner.next; // just "skip" it
                }
                runner = runner.next;
            }
            current = current.next;
        }
        return list;
    }

    public static void main( String[] args )
    {
        List<Integer> list = new LinkedList<Integer>() {
            {
                add( 2 );
                add( 1 );
                add( 1 );
                add( 1 );
                add( 1 );
                add( 7 );
            }
        };
        //        System.out.println( removeDuplicatesInPlaceUsingJavaCollectionAndAdditionalSpace( list ) );

        SinglyLinkedList<Integer> customList = new SinglyLinkedList<>();
        customList.add( 2 );
        customList.add( 1 );
        customList.add( 1 );
        customList.add( 1 );
        customList.add( 0 );
        customList.add( 7 );
        removeDuplicatesFromCustomListImplementation( customList );
        customList.printAll();
    }
}
