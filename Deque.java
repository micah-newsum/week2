import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<T> {
        protected Node<T> prev;
        protected Node<T> next;
        protected T item;

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
        this.first = newFirst;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<Item> newLast = new Node<>();
        newLast.item = item;

        Node<Item> oldLast = this.last;
        oldLast.next = newLast;
        newLast.prev = oldLast;
        this.last = newLast;
        size++;
    }

    public Item removeFirst() {
        Node<Item> oldFirst = this.first;
        this.first = oldFirst.next;
        size--;
        return oldFirst.item;
    }

    public Item removeLast() {
        Node<Item> oldLast = this.last;
        this.last = oldLast.prev;
        size--;
        return oldLast.item;
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
        Deque<String> stringDeque = new Deque<>();
        stringDeque.addFirst("Hello");
        stringDeque.addLast("World");
        System.out.println(stringDeque.size());
        String first = stringDeque.removeFirst();
        System.out.println(first);
        System.out.println(stringDeque.size());
        String last = stringDeque.removeLast();
        System.out.println(last);
        System.out.println(stringDeque.size());
    }
}