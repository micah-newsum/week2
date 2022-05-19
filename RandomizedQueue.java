import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Object[] queue;
    private int size;

    public RandomizedQueue() {
        this.queue = new Object[10];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {

    }

    public Item dequeue() {

    }

    // return a random item, but do not remove it
    public Item sample() {

    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator(this.queue);
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Object[] queue;
        
        private RandomizedQueueIterator(Object[] queue) {
            // copy conents of queue to iterator's queue
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
