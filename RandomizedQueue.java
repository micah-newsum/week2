import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }

        items[size] = item;
        size++;
        if (size == items.length) {
            Item[] newItems = (Item[]) new Object[items.length * 2];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    public Item dequeue() {
        if (size == 0) { throw new NoSuchElementException(); }

        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = items[--size];

        if (size <= items.length / 4) {
            Item[] newItems = (Item[]) new Object[items.length / 2];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        return item;
    }

    // return a random item, but do not remove it
    public Item sample() {
        if (size == 0) { throw new NoSuchElementException(); }
        return items[StdRandom.uniform(size)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private final int[] indices = new int[size];
        private int currentIndex = 0;

        private RandomizedQueueIterator() {
            for (int i = 0; i < size; i++) {
                indices[i] = i;
            }

            StdRandom.shuffle(indices);
        }

        public boolean hasNext() {
            return currentIndex < indices.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            return items[indices[currentIndex++]];
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("my");
        queue.enqueue("name");
        queue.enqueue("is");
        queue.enqueue("Micah");
        
        Iterator<String> i = queue.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.sample());
        i.remove();
    }
}
