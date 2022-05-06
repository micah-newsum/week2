import java.util.Iterator;

/**
 * 
 */
public class Deque<Item> implements Iterable<Item> {

    // construct an empty deque
    public Deque() {}

    // is the deque empty?
    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    public Item removeFirst() {
        return null;
    }

    public Item removeLast() {
        return null;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        
    }
}