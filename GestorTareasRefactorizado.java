package RepositorioParaGitHub;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorTareasRefactorizado {

    public static void mostrarMenu(){
        System.out.println("\n---DESPLIEGUE MENÚ---");
        System.out.println("1. Añadir tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Editar tarea");
        System.out.println("5. Salir");
    }

    public static void anadirTarea(ArrayList<String> tareas, Scanner sc){
        System.out.println("Añada la tarea que desee");
        tareas.add(sc.nextLine());
        System.out.println("Tarea añadida correctamente");
    }

    public static void mostrarTareas(ArrayList<String> tareas){
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista");
        } else {
            System.out.println("-----LISTA DE TAREAS----");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println("Tarea número " + (i + 1) + ": " + tareas.get(i));
            }
        }
    }

    public static void eliminarTareas(ArrayList<String> tareas, Scanner sc){
        System.out.println("Dime el número de la tarea que desea eliminar");
        int num = sc.nextInt();
        sc.nextLine();
        if (num < 1 || num > tareas.size()) {
            System.out.println("Error al introducir valor. El valor debe de ser un número de la lista de tareas");
        } else {
            tareas.remove(num - 1);
            System.out.println("La tarea ha sido eliminada");
        }
    }

    public static void editarTareas(ArrayList<String> tareas, Scanner sc){
        System.out.println("Qué tarea desea editar?");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("Por qué tarea desea modificar?");
        String nuevaTarea = sc.nextLine();

        if (num < 1 || num > tareas.size()) {
            System.out.println("Error al introducir valor. El valor debe de ser un número de la lista de tareas");
        } else {
            tareas.set(num - 1, nuevaTarea);
            System.out.println("La tarea ha sido editada");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<>();
        boolean salir = false;

        while (!salir){
            mostrarMenu();
            int tarea = sc.nextInt();
            sc.nextLine();

            switch (tarea) {
                case 1:
                    anadirTarea(tareas, sc);
                    break;
                case 2:
                    mostrarTareas(tareas);
                    break;
                case 3:
                    eliminarTareas(tareas, sc);
                    break;
                case 4:
                    editarTareas(tareas, sc);
                    break;
                case 5:
                    System.out.println("Gracias por usar el gestor de tareas");
                    salir = true;
                    break;
                default:
                    System.out.println("Ha ocurrido un error");
            }
        }
    }
}
