import ar.unlu.poo.listaDeTareas.Tarea;
import ar.unlu.poo.listaDeTareas.UtilidadesTareas;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner dato=new Scanner(System.in);
        UtilidadesTareas util=new UtilidadesTareas();
        Integer opcion=1;
        String opciones = "123";
        String descripcion;
        String prioridad;
        String nombre;
        Integer valor;

        while (opcion!=0){
            System.out.printf("\n---MENU---\n");
            System.out.printf("Opcion 1: agregar tarea\n");
            System.out.printf("Opcion 2: consultar tarea\n");
            System.out.printf("Opcion 3: modificar tarea\n");
            System.out.printf("Opcion 4: consultar lista de tareas\n");
            System.out.printf("Opcion 5: marcar tarea completada\n");
            System.out.printf("Opcion 6: consultar recordatorios\n");
            System.out.printf("Opcion 7: consultar tareas no vencidas por fecha\n");
            System.out.printf("Opcion 8: consultar fechas no vencidas por prioridad\n");
            System.out.printf("Opcion 9: consultar colaboradores\n");
            System.out.printf("Opcion 10: probar ejercicio 5\n");
            System.out.printf("Opcion 0: salir\n");

            System.out.printf("Opcion: ");
            opcion=dato.nextInt();
            dato.nextLine();

            switch (opcion) {
                case 1:
                        Integer i;
                        Integer flag = 0;
                        System.out.printf("Ingrese descripcion: ");
                        descripcion = dato.nextLine();
                        System.out.printf("Ingrese fecha de vencimiento con el formato yyyy-MM-dd: ");
                        String fechaVen = dato.nextLine();
                        System.out.printf("Ingrese fecha de recordatorio con el formato yyyy-MM-dd: ");
                        String fechaRe = dato.nextLine();
                        System.out.printf("Ingrese prioridad (1 a 3): ");
                        prioridad = dato.nextLine();
                        while (flag == 0) {
                            if (prioridad.length() == 1 && (prioridad.charAt(0) == opciones.charAt(0) || prioridad.charAt(0) == opciones.charAt(1) || prioridad.charAt(0) == opciones.charAt(2))) {
                                flag = 1;
                            } else {
                                System.out.printf("Ingrese valor valido. Prioridad (1 a 3):");
                                prioridad = dato.nextLine();
                            }
                        }

                        Tarea tarea = util.agregarTarea(descripcion, fechaVen, fechaRe, prioridad);
                        if (tarea == null) {
                            break;
                        } else {
                            System.out.printf("Ingrese la cantidad de colaboradores de la tarea: ");
                            Integer cantColab = dato.nextInt();
                            dato.nextLine();
                            for (i = 0; i < cantColab; i++) {
                                System.out.printf("Colaborador %d:", i+1);
                                nombre = dato.nextLine();
                                util.agregarColaborador(tarea, nombre);
                            }
                        }
                        break;
                case 2: System.out.printf("Ingrese tarea a consultar: ");
                        util.mostrarTarea(dato.nextLine()); break;
                case 3: System.out.printf("Ingrese tarea a modificar: ");
                        valor=util.buscarTares(dato.nextLine());
                        if (valor==null){
                            System.out.printf("La tarea no existe\n"); break;
                        }
                        else {
                            System.out.printf("Ingrese nueva descripcion: ");
                            String descripcoin=dato.nextLine();
                            System.out.printf("Ingrese prioridad (1 a 3): ");
                            prioridad = dato.nextLine();
                            flag=0;
                            while (flag == 0) {
                                if (prioridad.length() == 1 && (prioridad.charAt(0) == opciones.charAt(0) || prioridad.charAt(0) == opciones.charAt(1) || prioridad.charAt(0) == opciones.charAt(2))) {
                                    flag = 1;
                                } else {
                                    System.out.printf("Ingrese valor valido. Prioridad (1 a 3):");
                                    prioridad = dato.nextLine();
                                }
                            }
                            util.modificarTarea(valor, descripcoin, prioridad); break;
                        }
                case 4: util.mostrarListaDeTareas(); break;
                case 5: System.out.printf("Ingrese tarea a marcar como completa: ");
                        descripcion=dato.nextLine();
                        System.out.printf("Ingrese nombre del colaborador que la completo: ");
                        nombre=dato.nextLine();
                        valor=util.completarTarea(descripcion,nombre);
                        if (valor==0){
                            System.out.printf("Tarea completada\n"); break;
                        }
                        else if (valor==1){
                            System.out.printf("La tarea no existe\n"); break;
                        }
                        else if (valor==2){
                            System.out.printf("La tarea se encuentra vencida\n"); break;
                        }
                        else if (valor==3){
                            System.out.printf("Colaborador no encontrado\n"); break;
                        }
                case 6: util.mostrarRecordatorios(); break;
                case 7: util.mostrarPorFecha(); break;
                case 8: util.mostrarPorPrioridad(); break;
                case 9: System.out.printf("Ingrese colaborador a consultar: ");
                        nombre=dato.nextLine();
                        if (util.mostrarColaborador(nombre)==0){
                            System.out.printf("Colaborador no ecnontrado\n");
                        }
                case 10:UtilidadesTareas ej5=new UtilidadesTareas();
                        Tarea sup=ej5.agregarTarea("Ir al supermercado", "2023-10-06", "2023-10-06", "2");
                        ej5.agregarColaborador(sup,"Usuario");
                        ej5.completarTarea("Ir al supermercado","Usuario");
                        Tarea auto=ej5.agregarTarea("Consultar repuesto del auto", "2023-09-05", "2023-09-05", "3");
                        ej5.agregarColaborador(auto,"Usuario");
                        ej5.forzarEstado(auto);
                        Tarea cine=ej5.agregarTarea("Ir al cine a ver la nueva pelicula de Marvel", "2023-09-05", "2023-09-05", "1");
                        ej5.agregarColaborador(cine, "Usuario");
                        ej5.mostrarTarea("Ir al supermercado");
                        ej5.mostrarTarea("Consultar repuesto del auto");
                        ej5.mostrarTarea("Ir al cine a ver la nueva pelicula de Marvel");
                        break;
                case 0: break;
                default: System.out.printf("Opcion no valida\n");
            }
        }
    }
}