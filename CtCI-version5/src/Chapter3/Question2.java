package Chapter3;

/**
 * TODO
 * Created by sg on 08.03.18.
 */
public class Question2
{
    static class Node<K>
    {
        K       content;
        Node<K> under;


        public Node( K content )
        {
            this.content = content;
        }
    }

    static class Stack<K>
    {
        Node<K> top;
        K       min;


        void push( K value )
        {
            Node<K> node = new Node<>( value );
            node.under = top;
            top = node;
        }

        K pop()
        {
            if ( this.top == null ) {
                return null;
            }
            K value = this.top.content;
            this.top = this.top.under;
            return value;
        }
    }


    public static void main( String[] args )
    {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
        stack.push( 2 );
        stack.pop();
        stack.push( 2 );
        stack.push( 3 );
        stack.pop();
        stack.push( 3 );
        stack.push( 5 );
        stack.push( 7 );
        stack.pop();
    }
}
