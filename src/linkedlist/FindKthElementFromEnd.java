package linkedlist;

/**
 * As seen in Ctci, problem 2.2
 */
public class FindKthElementFromEnd {
    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.data + "";
        }
    }

    public static int K = 3; // what we are looking for

    /**
     * Recursive. Returns node in question. Uses static variable currentLevel to communicate the level to
     * the other recursion levels.
     */
    public static Node getKthElement(Node node) {
        if (node.next != null) {
            Node res = getKthElement(node.next);

            if (res != null) {
                // has been found already in a deeper level
                return res;
            }

            return K-- == 0 ? node : null;
        } else {
            // we found the end
            return K-- == 0 ? node : null;
        }
    }


    public static void main(String[] args) {
        Node n3 = new Node(3, null);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        System.out.println(getKthElement(n1));
    }
}
