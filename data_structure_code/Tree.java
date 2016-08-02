/**
 * Created by zhang on 2015/09/11.
 */
public class Tree{

    public class Node{
        // define a node
        int data;
        Node left;
        Node right;

        // create a Node
        public Node(){
            data = 0;
            left = null;
            right = null;
        }
        public Node(int d){
            data = d;
            left = null;
            right = null;
        }
        public Node(int d, Node l, Node r){
            data = d;
            left = l;
            right = r;
        }
        public Node getLeft(){
            return left;
        }
        public Node getRight(){
            return right;
        }
    }
    public class BinaryTree{
        Node head;

        public BinaryTree(){
            head = null;
        }

        /** since we are not worrying about custom binary tree creation, this method is going to create the tree directly without user input
         * the tree will be as below:
         *                N
         *           N         N
         *        N    N     N
         *      N  N N  N  N
         */

        public void Create(){
            Node Level3N1 = new Node(9);
            Node Level3N2 = new Node(8);
            Node Level3N3 = new Node(6);
            Node Level3N4 = new Node(14);
            Node Level3N5 = new Node(16);
            Node Level2N1 = new Node(5, Level3N1, Level3N2);
            Node Level2N2 = new Node(7, Level3N3, Level3N4);
            Node Level2N3 = new Node(10, Level3N5, null);
            Node Level1N1 = new Node(3, Level2N1, Level2N2);
            Node Level1N2 = new Node(2, Level2N3, null);

            head = new Node(1, Level1N1, Level1N2);
        }

        // counting both left hand side and right hand side with a while loop for each of them
        // starting from one since the root already gets one count
        public int Count(){
            Node left = head.getLeft();
            Node right = head.getRight();
            int count = 1;
            while (left != null){
                count++;
                left = left.getLeft();
                while (right != null){
                    count++;
                    left = left.getRight();
                }
            }
            while (right != null){
                count++;
                right = right.getLeft();
                while (right != null){
                    count++;
                    right = right.getRight();
                }
            }
            return count;
        }
        // counting height from 1 because root is already one level
        public int getHeight(){
            int height = 1;

            return height;
        }
    }
}
