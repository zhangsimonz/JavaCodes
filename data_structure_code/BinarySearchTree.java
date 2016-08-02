import java.util.ArrayList;
import java.util.Random;

/**
 * binary search tree assignment
 */
public class BinarySearchTree {

    // the root of a tree
    Node root;

    /**
     * adding nodes to a tree
     * @param key is the key value
     * @param data is the data stored, initially it is set to string type
     *             but it will be the value of the key since we cannot manually input 1000 string data
     */
    public void addNode(int key, String data){
        Node newNode = new Node(key, data);

        if(root == null){
            root = newNode;
        }else{
            Node currentNode = root;
            Node parent;

            while (true){
                parent = currentNode;
                // if the key value is smaller than the root then add the Node to the left child position
                if(key < currentNode.key){
                    currentNode = currentNode.leftChild;
                    //
                    if(currentNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                // if key greater then add the Node to the right
                }else{
                    currentNode = currentNode.rightChild;

                    if(currentNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key){
        Node currentNode = root;
        // search the tree as long as the key is not equal to the key provided in the argument
        while(currentNode.key != key){
            // if the key is less or greater than the key provided then the next node will be assigned to the current node and keep searching
            if(key < currentNode.key){
                currentNode = currentNode.leftChild;
            }else{
                currentNode = currentNode.rightChild;
            }
            // return null if no Node has been found
            if(currentNode == null){
                return null;
            }
        }
        return currentNode;
    }

    /*
    public boolean delete(Node currentNode, int dltKey){
        if(root == null){
            return false;
        }else if(dltKey < root.key){

        }
    }
    */

    /**
     * postOrder traversal read of the tree
     * @param currentNode is the current root pass to the traverse read
     */
    public void postOrder(Node currentNode){
        if(currentNode != null){
            postOrder(currentNode.leftChild);
            postOrder(currentNode.rightChild);
            System.out.println(currentNode);
        }
    }

    public void inOrder(Node currentNode){
        if(currentNode != null){
            postOrder(currentNode.leftChild);
            System.out.println(currentNode);
            postOrder(currentNode.rightChild);
        }
    }

    public void preOrder(Node currentNode){
        if(currentNode != null){
            System.out.println(currentNode);
            postOrder(currentNode.leftChild);
            postOrder(currentNode.rightChild);
        }
    }

    public static void main(String[] args){
        BinarySearchTree aTree = new BinarySearchTree();

        // random class is used to add random numbers to the tree
        Random rng = new Random(); // Ideally just create one instance globally
        // Note: use LinkedHashSet to maintain insertion order
        ArrayList<Integer> generated = new ArrayList<>();
        while (generated.size() < 1000)
        {
            Integer next = rng.nextInt(1000) + 1;
            // only adding values to the arraylist if not a repeated value
            if(!generated.contains(next)) {
                generated.add(next);
            }
        }
        // adding nodes to the tree
        for(int i = 0; i < 1000; i++) {
            aTree.addNode(generated.get(i), generated.get(i).toString());
        }

        aTree.inOrder(aTree.root);

        System.out.println("Search for 12");
        System.out.println(aTree.find(12));
    }

}

/**
 * the node object class to be used within a tree
 */
class Node{
    int key;
    String data;

    Node leftChild;
    Node rightChild;

    Node(int key, String data){
        this.key = key;
        this.data = data;
    }

    // just the customised format of printing Nodes.
    public String toString(){
        return data + ", key value: " + key;
    }
}
