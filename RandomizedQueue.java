import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;
    private int head;
    private int tail;
    private int capacity;

    public RandomizedQueue() {
        this.capacity = 10;
        this.items = (Item[]) new Object[1];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
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
            Item[] newItems = (Item[]) new Object[size * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = this.items[i];
            }
            items = newItems;
        }
    }

    public Item dequeue() {
        if (size == 0) { throw new NoSuchElementException(); }

        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = items[--size];
        return item;
    }

    // return a random item, but do not remove it
    public Item sample() {
        return (Item) items[0];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<Item>();
    }

    private class RandomizedQueueIterator<Item> implements Iterator<Item> {
        private Object[] iteratorItems;
        
        private RandomizedQueueIterator() {
            // copy conents of queue to iterator's queue
            iteratorItems = new Object[tail - head];
            int iteratorIndex = 0;
            for (int i = head; i <= tail; i++) {
                iteratorItems[iteratorIndex] = items[i];
                iteratorIndex++;
            }
        }

        public boolean hasNext() {

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {

        }
    }

    public static void main(String[] args) {

    }
}
