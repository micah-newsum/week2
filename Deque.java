import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<T> {
        protected Node<T> prev;
        protected Node<T> next;
        protected T item;
    }

    public Deque() {
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

        // adding item to empty deque
        if (this.first == null && this.last == null) {
            this.first = newFirst;
            this.last = this.first;
        } else {
            Node<Item> oldFirst = this.first;
            newFirst.next = oldFirst;
            oldFirst.prev = newFirst;
            this.first = newFirst;
        }

        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<Item> newLast = new Node<>();
        newLast.item = item;

        // adding item to empty deque
        if (this.first == null && this.last == null) {
            this.last = newLast;
            this.first = this.last;
        } else {
            Node<Item> oldLast = this.last;
            oldLast.next = newLast;
            newLast.prev = oldLast;
            this.last = newLast;
        }

        size++;
    }

    public Item removeFirst() {
        if (this.first == null) {
            throw new NoSuchElementException();
        }

        Node<Item> oldFirst = this.first;
        this.first = oldFirst.next;
        size--;
        return oldFirst.item;
    }

    public Item removeLast() {
        if (this.last == null) {
            throw new NoSuchElementException();
        }

        Node<Item> oldLast = this.last;
        this.last = oldLast.prev;
        size--;
        return oldLast.item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator(this.first);
    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current;

        private DequeIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
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

        stringDeque = new Deque<>();
        stringDeque.addFirst("Hello");
        stringDeque.addLast("World");
        stringDeque.addLast("My");
        stringDeque.addLast("Name");
        stringDeque.addLast("is");
        stringDeque.addLast("Micah");
        Iterator<String> i = stringDeque.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}