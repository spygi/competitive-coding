package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class TreeTraversals {
    public static class Node {
        boolean visited = false;
        int content;
        Node leftChild;
        Node rightChild;


        public Node(int content) {
            this.content = content;
        }

        public List<Node> getChildren() {
            return new ArrayList<Node>() {
                {
                    if (leftChild != null) {
                        add(leftChild);
                    }
                    if (rightChild != null) {
                        add(rightChild);
                    }
                }
            };
        }
    }


    /**
     * Common DFS
     */
    public static void preOrder(Node root) {
        System.out.println(root.content); // visiting method
        root.visited = true; // required for graphs, not trees
        for (Node child : root.getChildren()) {
            // provided getChildren returns first left and then right
            if (child.visited) {
                return;
            }
            preOrder(child);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.content);
        }
    }

    /**
     * Iterative (uses queue)
     */
    public static void breadthSearch(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node currentNode;
        while (!q.isEmpty()) {
            currentNode = q.poll();
            System.out.println(currentNode.content);

            for (Node child : currentNode.getChildren()) {
                q.add(child);
            }
        }
    }

    /**
     * Prints each level of the tree in a new line, asked in an interview.
     */
    static void recursiveBreadthSearch(List<Node> level) {
        List<Node> nextLevel = new ArrayList<>();
        if (!level.isEmpty()) {
            for (Node node : level) {
                System.out.print(node.content + " ");
                nextLevel.addAll(node.getChildren()); // essentially using a queue here
            }
            System.out.println();
            recursiveBreadthSearch(nextLevel);
        }
    }

    public static void main(String[] args) {
        // Unbalanced tree that looks like this
        //     2
        //    3 5
        //    7
        //  1  0
        // 9 4 -1
        Node root = new Node(2);
        Node level1Left = new Node(3);
        Node level1Right = new Node(5);
        root.leftChild = level1Left;
        root.rightChild = level1Right;

        Node level2Left = new Node(7);
        level1Left.leftChild = level2Left;

        Node level3Left = new Node(1);
        Node level3Right = new Node(0);
        level2Left.leftChild = level3Left;
        level2Left.rightChild = level3Right;

        Node level4LeftLeft = new Node(9);
        Node level4Left = new Node(4);
        Node level4Right = new Node(-1);
        level3Left.leftChild = level4LeftLeft;
        level3Left.rightChild = level4Left;
        level3Right.rightChild = level4Right;

//        recursiveBreadthSearch(new ArrayList<Node>() {
//            {
//                add(root);
//            }
//        });
        postOrder(root);
    }
}
