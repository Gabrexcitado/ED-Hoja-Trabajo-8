public class PriorityQueue<E> implements IPriorityQueue<E> {
    private java.util.PriorityQueue<E> queue = new java.util.PriorityQueue<>();

    @Override
    public void add(E data) {
        queue.add(data);
    }

    @Override
    public E poll() {
        return queue.poll();
    }
    
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
