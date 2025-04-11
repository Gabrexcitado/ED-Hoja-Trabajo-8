import java.util.Scanner;

/**
 * Programa de utilizacion de dos colas de prioridad para la simulacion de una sala de emergencia de un hospital
 * @Author Gabriel Hidalgo 24939
 * Creacion: 08-04-2025
 * Ultima modificacion: 10-04-2025
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IPriorityQueue<Pacient> queue;

        //Menu de seleccion de la cola de prioridad
        System.out.print("\nSimulador de sala de emergencia\n" + 
        "-----------------------------------\n"+ 
        "1. VectorHeap\n" +
        "2. PriorityQueue\n\n" +
        "Escoja la implementacion que desea utilizar: ");

        String input = sc.nextLine();
        if(input.equals("1")){
            queue = Converter.loadPacients("pacientes.txt", 1); //VectorHeap
        }else if(input.equals("2")){
            queue = Converter.loadPacients("pacientes.txt", 2); //PriorityQueue
        }else{
            System.out.println("\n<<<Opcion no valida, se usara VectorHeap por defecto>>>\n"); //default
            queue = Converter.loadPacients("pacientes.txt", 1);
        }
        System.out.println("Cola de prioridad cargada con exito...\n");

        boolean exit = false;
        while(!exit){

            System.out.print("\n/////////////////////////---MENU---/////////////////////////\n\n" + 
            "1. Agregar paciente\n" +
            "2. Atender paciente\n" +
            "0. Salir\n\n" + 
            "Elige una opcion: ");
            
            input = sc.nextLine();
            switch(input){
                //Agregar paciente 
                case "1":
                    System.out.print("Ingrese el nombre del paciente: ");
                    String name = sc.nextLine();
                    System.out.print("Ingrese el sintoma del paciente: ");
                    String syntom = sc.nextLine();
                    System.out.print("Ingrese la prioridad del paciente: ");
                    String priority = sc.nextLine();
                    System.out.print("Ingrese la hora de llegada del paciente (HH:mm): ");
                    String arrivalTime = sc.nextLine();

                    Pacient pacient = new Pacient(name, syntom, priority, arrivalTime);
                    queue.add(pacient);
                    break;

                //Mostrar siguiente paciente
                case "2":
                    Pacient next = queue.poll();
                    if(next != null){
                        System.out.println(next.toString());
                    }else{
                        System.out.println("No hay mas pacientes por el momento");
                    }
                    break;
                
                //Salir del programa
                case "0":
                    System.out.println("\nSaliendo del programa...");
                    exit = true;
                    Converter.savePacients(queue, "pacientes.txt"); //Guardar la cola en el txt
                    sc.close();
                    break;

                //Si la opcion no es valida
                default:
                    System.out.println(">>>OPCION NO VALIDA<<<\n");
                    break;
            }

        }     
    }
}
