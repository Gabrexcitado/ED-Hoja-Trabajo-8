/**
 * Clase que representa un paciente.
 */
public class Pacient implements Comparable<Pacient> {
    private String name;
    private String syntom;
    private String priority;

    /**
     * Constructor de la clase Pacient.
     * @param name nombre del paciente
     * @param syntom sintoma del paciente
     * @param priority prioridad de atencion
     */
    public Pacient(String name, String syntom, String priority) {
        this.name = name;
        this.syntom = syntom;
        this.priority = priority;
    }

    /**
     * metodo que retorna la prioridad para la comparacion de pacientes
     * @return prioridad de atencion
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Metodo que retorna la ficha del paciente
     * @return ficha del paciente
     */
    public String toString() {
        return "Paciente: " + name + " Con:" + syntom + "[" +  priority + "]";
    }

    /**
     * Metodo que compara dos pacientes por su prioridad de atencion.
     * @param pacient paciente ingresado
     * @return comparacion entre prioridades
     */
    public int compareTo(Pacient pacient) {
        return this.priority.compareTo(pacient.getPriority());
    }
}
