import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by zhangsimonz on 22/10/2015.
 */
public class Heap {

    ArrayList<Integer> items = new ArrayList<>();

    public Heap(ArrayList<Integer> items) {
        this.items = items;
    }

    public Heap() {
        items = new ArrayList<>();
    }

    private void ReheapUp(){
        int walker =items.size() - 1;

        while(walker > 0){
            int parentIndex = (walker - 1) / 2;
            int item = items.get(walker);
            int parent = items.get(parentIndex);

            if(item > parent){
                // swap
                items.set(walker, parent);
                items.set(parentIndex, item);
                // move the walker by one level
                walker = parentIndex;
            }else{
                break;
            }
        }
    }

    private void ReheapDown(){
        int walker = 0;
        int leftChild = 2 * walker + 1;

        while (leftChild < items.size()){
            int max = leftChild, rightChild = leftChild + 1;
            if(rightChild < items.size()){
                if (items.get(rightChild).compareTo(items.get(leftChild)) > 0){
                    // swap
                    int temp = items.get(walker);
                    items.set(walker, items.get(max));
                    items.set(max, temp);
                    walker = max;
                    leftChild = 2 * walker + 1;
                }
            }else{
                break;
            }
        }
    }

    public int delete() throws NoSuchElementException{
        if (items.size() == 0){
            throw new NoSuchElementException();
        }
        if (items.size() == 1){
            return items.remove(0);
        }

        int hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        ReheapDown();

        return hold;
    }
}
