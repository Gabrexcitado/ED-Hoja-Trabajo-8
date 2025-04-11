/**
 * Programa de utilizacion de dos colas de prioridad para la simulacion de una sala de emergencia de un hospital
 * @Author Gabriel Hidalgo 24939
 * Creacion: 08-04-2025
 * Ultima modificacion: 10-04-2025
 */
public class Main {
    public static void main(String[] args) {
        IPriorityQueue<Pacient> vectorHeap = Converter.loadPacients("pacientes.txt", 1);
        IPriorityQueue<Pacient> priorityQueue = Converter.loadPacients("pacientes.txt", 2);

        System.out.print("\nSimulador de sala de emergencia\n" + 
        "-----------------------------------\n"+ 
        "1. VectorHeap\n" +
        "2. PriorityQueue\n\n" +
        "Escoja la implementacion que desea utilizar: ");

        String option = 

       
}
}
