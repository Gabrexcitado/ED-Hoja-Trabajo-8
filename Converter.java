import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase encargada de la lectura y escritura del archivo 
 */
public class Converter {

    /**
     * Metodo que convierte el txt en Heap de priority
     * @param file archivo txt
     * @param QueueOption opcion de Heap de priority
     * @return heap de prioridad con los pacientes
     */
    public static IPriorityQueue<Pacient> loadPacients(String file, int QueueOption) {
        IPriorityQueue<Pacient> Heap = PriorityQueueFactory.factory(QueueOption);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                if (data.length == 4) {
                    String name = data[0].trim();
                    String syntoms = data[1].trim();
                    String priority = data[2].trim();
                    String arrivalTime = data[3].trim();

                    Pacient Pacient = new Pacient(name, syntoms, priority, arrivalTime);
                    Heap.add(Pacient);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return Heap;
    }

    /**
     * Guarda los pacientes en un archivo txt
     * @param heap Heap de prioridad con los pacientes
     * @param file archivo txt
     */
    public static void savePacients(IPriorityQueue<Pacient> heap, String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            while (!heap.isEmpty()) {
                Pacient p = heap.poll();
                if (p != null) { // Validación clave
                    bw.write(p.getName() + ", " + p.getSyntom() + ", " + p.getPriority() + ", " + p.getArrivalTime());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
    
}

