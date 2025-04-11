import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> vector = new ArrayList<E>();

    /**
     * Metodo para agregar y ordenar un paciente nuevo por prioridad
     */
    public void add(E pacient) {

        if (vector.isEmpty()) {
            vector.add(null); 
        }

        vector.add(pacient); 
        int position = vector.size() - 1;

        //Comparar con el padre
        while (position > 1 && pacient.compareTo(vector.get(position / 2)) < 0) {
            E parent = vector.get(position / 2);
            vector.set(position / 2, pacient);
            vector.set(position, parent);
            position = position / 2;
        }
    }

    /**
     * Metodo que saca el paciente con mayor prioridad de la cola
     * @return siguiente paciente a tratar
     */
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
}
