import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    public Deque() {}

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

        Node node = new Node();
        node.item = item;

        // adding item to empty deque
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node node = new Node();
        node.item = item;

        // adding item to empty deque
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public Item removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node node = head;
        head = head.next;
        size--;
        return node.item;
    }

    public Item removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        Item item = tail.item;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator(head);
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current;

        private DequeIterator(Node head) {
            current = head;
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
        stringDeque.addLast("my");
        stringDeque.addLast("name");
        stringDeque.addLast("is");
        stringDeque.addLast("Micah");
        Iterator<String> i = stringDeque.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        i.remove();
    }
}