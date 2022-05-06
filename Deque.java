import java.util.Iterator;

/**
 * Doubly Linked List would allow for adding items at front and end of list in constnt time.
 * It would also allow for constant time removal from the front and back of list.
 * The Deque would also be initialized in constant time.
 * The size operation could provide constant time by keeping an instance variable that tracks
 * items that are added and removed.
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
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Item> {
        public boolean hasNext() {return false;}

        public void remove() {throw new UnsupportedOperationException();}

        public Item next() {return null;}
    }

    public static void main(String[] args) {
        
    }
}