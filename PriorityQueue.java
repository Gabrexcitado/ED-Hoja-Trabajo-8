/**
 * Clase que hace una cola de prioridad con la clase PriorityQueue de Java
 */
public class PriorityQueue<E> implements IPriorityQueue<E> {
    private java.util.PriorityQueue<E> queue = new java.util.PriorityQueue<>();

    /**
     * Metodo para agregar y ordenar un paciente nuevo por prioridad
     * @param data paciente a agregar
     */
    @Override
    public void add(E data) {
        queue.add(data);
    }

    /**
     * Metodo para sacar el paciente con mayor prioridad de la cola
     * @return siguiente paciente a tratar
     */
    @Override
    public E poll() {
        return queue.poll();
    }
    
    /**
     * Metodo que verifica si la cola de prioridad esta vacia
     * @return true si la cola de prioridad esta vacia, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
