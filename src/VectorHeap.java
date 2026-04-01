import java.util.ArrayList;

/**
 * Implementación de Priority Queue usando un heap.
 */
public class VectorHeap<E extends Comparable<E>> implements MyPriorityQueue<E> {

    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;

        E min = data.get(0);
        E last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            percolateDown(0);
        }

        return min;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void percolateDown(int index) {
        int size = data.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && data.get(left).compareTo(data.get(smallest)) < 0)
                smallest = left;

            if (right < size && data.get(right).compareTo(data.get(smallest)) < 0)
                smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}