import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
