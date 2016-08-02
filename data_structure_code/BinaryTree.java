public class BinaryTree{
    Node head;
    /**
     * Created by zhang on 2015/09/11.
     */
    public class Node{
        // define a node
        char data;
        Node left;
        Node right;

        // create a Node
        public Node(){
            data = '\u0000';
            left = null;
            right = null;
        }
        public Node(char d){
            data = d;
            left = null;
            right = null;
        }
        public Node(char d, Node l, Node r){
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
    int count = 0; // initial count equals 1 as the root count for 1.
    int height = 0; // initial height equals 1 as the root count for 1 level.
    boolean levelCounted = false; // boolean variable to check if the same level is counted into height.

    public BinaryTree(){
        head = null;
    }

    /** since we are not worrying about custom binary tree creation, this method is going to create the tree directly without user input
     * the tree will be as below:
     *                *
     *           +         -
     *        +    *     /   c
     *      g  h r  b  a  k
     */

    public void Create(){
        Node Level3N1 = new Node('g');
        Node Level3N2 = new Node('h');
        Node Level3N3 = new Node('r');
        Node Level3N4 = new Node('b');
        Node Level3N5 = new Node('a');
        Node Level3N6 = new Node('k');
        Node Level2N1 = new Node('+', Level3N1, Level3N2);
        Node Level2N2 = new Node('*', Level3N3, Level3N4);
        Node Level2N3 = new Node('/', Level3N5, Level3N6);
        Node Level2N4 = new Node('c', null, null);
        Node Level1N1 = new Node('+', Level2N1, Level2N2);
        Node Level1N2 = new Node('-', Level2N3, Level2N4);

        head = new Node('*', Level1N1, Level1N2);
    }

    // starting from one since the root already gets one count
    public int Count(Node root){
        if (root != null){
            count ++;
            Count(root.getLeft());
            Count(root.getRight());
        }
        return count;
    }

    // counting height from 0 because root is already one level
    public int FindHeight(Node root){
        // when the method detect that the root is null
        // the height will stop increasing and jump out to return the height value
        if (root == null){
            height = -1;
        } else {
            // height will be increased by the maximum height
            height = Math.max(FindHeight(root.getLeft()), FindHeight(root.getRight())) + 1;
        }
        return height + 1;
    }

    // Determine if the tree is complete or nearly complete
    public boolean IsComplete(Node root){
        return Count(root) >= (Math.pow(2, (double) FindHeight(root)) - 1);
    }

    // Determine if the tree is balanced
    public boolean IsBalanced(Node root){
        return Math.abs(FindHeight(root.getLeft()) - FindHeight(root.getRight())) <= 1;
    }

    public void inOrder(Node root){
        if(root != null){
            postOrder(root.getLeft());
            System.out.print(root.data);
            postOrder(root.getRight());
        }
    }

    public void postOrder(Node root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.data);
        }
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data);
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    public static void main(String[] args){
        BinaryTree myTree = new BinaryTree();
        myTree.Create();
        System.out.println("There are " + myTree.Count(myTree.head) + " elements in the tree.");
        System.out.println("There are " + myTree.FindHeight(myTree.head) + " heights in the tree.");
        System.out.println(myTree.IsBalanced(myTree.head));
        System.out.println("PreOrder reading: ");
        myTree.preOrder(myTree.head);
        System.out.println(" ");
        System.out.println("PostOrder reading: ");
        myTree.postOrder(myTree.head);
        System.out.println(" ");
        System.out.println("InOrder reading: ");
        myTree.inOrder(myTree.head);
    }


}



