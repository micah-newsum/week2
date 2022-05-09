import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item> {
        Node<Item> prev;
        Node<Item> next;
        Item item;

        Node() {
            this.prev = null;
            this.next = null;
            this.item = null;
        }
    }

    public Deque() {
        this.first = new Node<Item>();
        this.last = new Node<Item>();
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<Item> newFirst = new Node<>();
        newFirst.item = item;

        Node<Item> oldFirst = this.first;

        newFirst.next = oldFirst;
        oldFirst.prev = newFirst;
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
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        public boolean hasNext() {
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}