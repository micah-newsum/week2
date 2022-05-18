import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeTest {

    @Test(expected = IllegalArgumentException.class)
    public void addFirstThrowsIllegalArgumentException() {
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLastThrowsIllegalArgumentException() {
        Deque<String> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstThrowsNoSuchElementException() {
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastThrowsNoSuchElementException() {
        Deque<String> deque = new Deque<>();
        deque.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void nextThrowsNoSuchElementException() {
        Deque<String> deque = new Deque<>();
        Iterator<String> i = deque.iterator();
        i.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrowsUnsupportedOperationException() {
        Deque<String> deque = new Deque<>();
        Iterator<String> i = deque.iterator();
        i.remove();;
    }

    @Test
    public void removeFirstTest() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("My");
        deque.addFirst("name");
        deque.addFirst("is");
        deque.addFirst("Micah");
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        assertEquals(0, deque.size());
    }

    @Test
    public void removeLastTest() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("My");
        deque.addFirst("name");
        deque.addFirst("is");
        deque.addFirst("Micah");
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        assertEquals(0, deque.size());
    }

    @Test
    public void testDequeIterator(){
        Deque<String> deque = new Deque<>();
        deque.addFirst("My");
        deque.addFirst("name");
        deque.addFirst("is");
        deque.addFirst("Micah");
        Iterator<String> i = deque.iterator();
        String s = "";
        while (i.hasNext()){
            s = s + i.next() + " ";
        }
        assertEquals("Micah is name My ", s);
    }
}
