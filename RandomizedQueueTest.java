import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

public class RandomizedQueueTest {

    @Test
    public void testEnqueue() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Hello");
        assertTrue(true);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void testDequeue() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Hello");
        assertEquals("Hello", queue.dequeue());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testSample() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Hello");
        assertNotNull(queue.sample());
    }

    @Test
    public void testIterator() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("my");
        queue.enqueue("name");
        queue.enqueue("is");
        queue.enqueue("Micah");

        Iterator<String> i = queue.iterator();
        short count = 0;
        while (i.hasNext()) {
            i.next();
            count++;
        }
        assertEquals(6, count);
    }

    @Test
    public void testLargeQueue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        int size = 100;
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < size; i++) {
            queue.dequeue();
        }
        
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}