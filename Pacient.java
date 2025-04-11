/**
 * Clase que representa un paciente.
 */
public class Pacient implements Comparable<Pacient> {
    private String name;
    private String syntom;
    private String priority;
    private String arrivalTime;

    /**
     * Constructor de la clase Pacient.
     * @param name nombre del paciente
     * @param syntom sintoma del paciente
     * @param priority prioridad de atencion
     */
    public Pacient(String name, String syntom, String priority, String arrivalTime) {
        this.name = name;
        this.syntom = syntom;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    /**
     * metodo que retorna la prioridad para la comparacion de pacientes
     * @return prioridad de atencion
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Metodo que retorna el nombre del paciente
     * @return nombre del paciente
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que retorna el sintoma del paciente
     * @return sintoma del paciente
     */
    public String getSyntom() {
        return syntom;
    }

    /**
     * Metodo que retorna la hora de llegada del paciente
     * @return hora de llegada del paciente
     */
    public String getArrivalTime() {
        return arrivalTime;
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
    @Override
    public int compareTo(Pacient other) {
        int result = this.priority.compareTo(other.getPriority());
        if(result == 0){
            return this.arrivalTime.compareTo(other.arrivalTime);
        }
        return result;
    }
}
