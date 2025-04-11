import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> vector = new ArrayList<E>();

    /**
     * Metodo para agregar y ordenar un paciente nuevo por prioridad
     */
    @Override
    public void add(E data) {

        if (vector.isEmpty()) {
            vector.add(null); 
        }

        vector.add(data); 
        int position = vector.size() - 1;

        //Comparar con el padre
        while (position > 1 && data.compareTo(vector.get(position / 2)) < 0) {
            E parent = vector.get(position / 2);
            vector.set(position / 2, data);
            vector.set(position, parent);
            position = position / 2;
        }
    }

    /**
     * Metodo que saca el paciente con mayor prioridad de la cola
     * @return siguiente paciente a tratar
     */
    @Override
    public E poll() {
        if (vector.isEmpty() || vector.size() == 1) {
            return null; 
        }

        E toReturn = vector.get(1); 
        E toReplace = vector.remove(vector.size() - 1); 

        if (vector.size() == 1) {
            return toReturn; 
        }

        //Elemento más a la derecha va a la raíz
        vector.set(1, toReplace);
        int position = 1;

        while (position * 2 < vector.size()) {
            int leftChildPos = position * 2;
            int rightChildPos = position * 2 + 1;

            E leftChild = vector.get(leftChildPos);
            E rightChild = (rightChildPos < vector.size()) ? vector.get(rightChildPos) : null;

            //No hay derecho o izquierdo es mayor
            if (rightChild == null || leftChild.compareTo(rightChild) < 0) {
                //Comparar con la raiz
                if (leftChild.compareTo(toReplace) < 0) {
                    vector.set(position, leftChild);
                    vector.set(leftChildPos, toReplace);
                    position = leftChildPos;
                } 
            } else {
                // Derecho es menor
                if (rightChild.compareTo(toReplace) < 0) {
                    vector.set(position, rightChild);
                    vector.set(rightChildPos, toReplace);
                    position = rightChildPos;
                }
            }
        }

        return toReturn;
    }

    /**
     * Metodo para verificar si la cola de prioridad esta vacia
     * @return true si la cola de prioridad esta vacia, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }
}
