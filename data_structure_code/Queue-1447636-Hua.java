import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<Item> implements Iterable<Item> {
    int number;         // number of elements in the queue
    Node firstItem;    // beginning item of the queue
    Node lastItem;     // end item of the queue

    // helper linked list class
    private class Node {
        Item item;
        Node next;
    }

    /**
     * Initializes an empty queue.
     */
    public MyQueue() {
        firstItem = null;
        lastItem  = null;
        number = 0;
        assert check();
    }

    /**
     * Check if the queue is empty
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return firstItem == null;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return number;     
    }

    /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return firstItem.item;
    }

    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item) {
        Node oldlast = lastItem;
        lastItem = new Node();
        lastItem.item = item;
        lastItem.next = null;
        if (isEmpty()) firstItem = lastItem;
        else           oldlast.next = lastItem;
        number++;
        assert check();
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("There is nothing in the queue");
        Item item = firstItem.item;
        firstItem = firstItem.next;
        number--;
        if (isEmpty()) lastItem = null;
        assert check();
        return item;
    }

    /**
     * Returns a string representation of this queue.
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    } 

    // check internal invariants
    private boolean check() {
        if (number == 0) {
            if (firstItem != null) return false;
            if (lastItem  != null) return false;
        }
        else if (number == 1) {
            if (firstItem == null || lastItem == null) return false;
            if (firstItem != lastItem)                 return false;
            if (firstItem.next != null)            return false;
        }
        else {
            if (firstItem == lastItem)      return false;
            if (firstItem.next == null) return false;
            if (lastItem.next  != null) return false;

            int numberOfNodes = 0;
            for (Node x = firstItem; x != null; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != number) return false;

            Node lastNode = firstItem;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            if (lastItem != lastNode) return false;
        }

        return true;
    } 
 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        Node current = firstItem;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


    /**
     * testing the MyQueue data type.
     */
    public static void main(String[] args) {
        MyQueue<String> q = new MyQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left in the queue)");
    }
}