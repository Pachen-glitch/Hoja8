import java.util.ArrayList;

/**
 * Implementación de una cola de prioridad utilizando un Heap (montículo mínimo).
 * 
 * @param <E> Tipo de dato que extiende Comparable
 */
public class VectorHeap<E extends Comparable<E>> implements MyPriorityQueue<E> {

    private ArrayList<E> data;

    /**
     * Constructor que inicializa el heap vacío.
     */
    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Agrega un elemento al heap.
     * 
     * @param value elemento a agregar
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Remueve y retorna el elemento con mayor prioridad (menor valor).
     * 
     * @return elemento con mayor prioridad o null si está vacío
     */
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

    /**
     * Retorna el elemento con mayor prioridad sin removerlo.
     * 
     * @return elemento con mayor prioridad
     */
    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data.get(0);
    }

    /**
     * Retorna el tamaño del heap.
     * 
     * @return número de elementos
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Indica si el heap está vacío.
     * 
     * @return true si está vacío
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Ajusta el heap hacia arriba.
     */
    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    /**
     * Ajusta el heap hacia abajo.
     */
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

    /**
     * Intercambia dos elementos del heap.
     */
    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}