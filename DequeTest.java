import org.junit.Test;
import static org.junit.Assert.assertEquals;
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
        i.remove();
    }

    @Test
    public void isEmptyReturnsTrue() {
        Deque<String> deque = new Deque<>();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalse() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("item");
        assertFalse(deque.isEmpty());
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
    public void testDequeIterator() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("My");
        deque.addFirst("name");
        deque.addFirst("is");
        deque.addFirst("Micah");
        Iterator<String> i = deque.iterator();
        String s = "";
        while (i.hasNext()) {
            s = s + i.next() + " ";
        }
        assertEquals("Micah is name My ", s);
    }

    @Test
    public void submissionRemoveFirstError() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.removeFirst();
        deque.addLast(3);
        deque.removeFirst();
    }

    @Test
    public void submissionIsEmptyTest() {
        Deque<Integer> deque = new Deque<>();
        deque.isEmpty();
        deque.isEmpty();
        deque.isEmpty();
        deque.isEmpty();
        deque.addLast(5);
        deque.removeFirst();
        deque.isEmpty();
        deque.isEmpty();
        deque.isEmpty();
        deque.addLast(10);
        deque.removeFirst();
    }

    @Test
    public void randomCallsToApi() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.removeLast();    
        deque.addLast(3);
        deque.removeFirst();     
        deque.isEmpty();        
        deque.size();            
        deque.addLast(7);
        deque.removeFirst();
    }

    @Test
    public void iteratorTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        Iterator<Integer> iterator = deque.iterator();
        int size = 0;
        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }
        assertEquals(1, size);
        
        deque.removeFirst(); 
        iterator = deque.iterator();     
        size = 0;
        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }

        assertEquals(0, size);
        
        deque.addLast(3);
        iterator = deque.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }
        assertEquals(1, size);
    }
}
