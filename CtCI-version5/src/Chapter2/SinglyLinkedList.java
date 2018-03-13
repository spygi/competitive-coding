package Chapter2;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


/**
 * Created by sg on 07.03.18.
 */
public class SinglyLinkedList<K>
{
    Node<K> last;
    Node<K> root;


    static class Node<K>
    {
        K       content;
        Node<K> next;


        public Node( K content, Node<K> next )
        {
            this.content = content;
            this.next = next;
        }
    }


    public void add( K content )
    {
        Node<K> node = new Node<>( content, null );
        if ( root == null ) {
            root = node;
            last = root;
        } else {
            last.next = node;
            last = node;
        }
    }

    public K get( int index )
    {
        Node<K> node = root;
        for ( int i = 0; i < index; i++ ) {
            node = node.next;
        }
        return node.content;
    }

    public void printAll()
    {
        Node<K> current = this.root;
        while ( current != null ) {
            System.out.println( current.content );
            current = current.next;
        }
    }
}
