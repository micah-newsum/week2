import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
