import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void testAddAndRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        heap.add(5);
        heap.add(1);
        heap.add(3);

        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(3), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
    }

    @Test
    public void testIsEmpty() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());

        heap.add(10);
        assertFalse(heap.isEmpty());
    }
}