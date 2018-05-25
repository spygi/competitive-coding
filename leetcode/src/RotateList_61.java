import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sg on 25.05.18.
 */
public class RotateList_61
{
    public static class ListNode
    {
        int      val;
        ListNode next;


        public ListNode( int x )
        {
            val = x;
        }
    }


    static ListNode rotateRight( ListNode head, int k )
    {
        if ( head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        List<ListNode> list = new ArrayList<>();
        list.add( head );
        while ( current.next != null ) {
            current = current.next;
            list.add( current );
        }

        current.next = head; // make a palindrome
        list.get( list.size()-1 - (k % list.size() )).next = null; // fix the end
        return list.get( list.size()-1 - ((k-1) % list.size()) ); // return the new head
    }

    public static void main( String[] args )
    {
        ListNode head = new ListNode( 1 );
        ListNode node1 = new ListNode( 2 );
        head.next = node1;

        rotateRight(head,1);
    }
}