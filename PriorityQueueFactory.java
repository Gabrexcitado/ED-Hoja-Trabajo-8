/**
 * Clase que crea las colas de prioridad
 */
public class PriorityQueueFactory {
    
    public static <E extends Comparable<E>>IPriorityQueue<E> factory(int type){
        if(type == 1){
            return new VectorHeap<E>();
        }else if(type == 2){
            return new PriorityQueue<E>();
        }else{
            return null;
        }
    }
}
