import ar.unlu.poo.ej9.Fecha;
import ar.unlu.poo.ej9.UtilidadesFechas;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        UtilidadesFechas util=new UtilidadesFechas();
        Integer opcion=1;
        Scanner dato=new Scanner(System.in);

        System.out.printf("Seleccione formato: \n");
        System.out.printf("0: dd-MM-yyyy\n1: MM-dd-yyyy\n");
        System.out.printf("Opcion: ");
        Integer op=dato.nextInt();
        dato.nextLine();
        while (op!=0 && op!=1){
            System.out.printf("Opcion invalida. Opcion: ");
            op= dato.nextInt();
            dato.nextLine();
        }
        System.out.printf("Ingrese fecha con el formato seleccionado: ");


        String fecha=dato.nextLine();
        Fecha f1;
        f1=util.cargarFecha(fecha, op);

        while (opcion!=0){
            System.out.printf("1: comparar fechas (anterior o posterior)\n");
            System.out.printf("2: comparar fechas (anterior, posterior o entre fechas)\n");
            System.out.printf("0: salir\n");
            System.out.printf("Opcion: ");

            opcion=dato.nextInt();

            switch (opcion){
                case 1: dato.nextLine();
                        System.out.printf("Seleccione formato: \n");
                        System.out.printf("0: dd-MM-yyyy\n1: MM-dd-yyyy\n");
                        System.out.printf("Opcion: ");
                        op=dato.nextInt();
                        dato.nextLine();
                        while (op!=0 && op!=1){
                            System.out.printf("Opcion invalida. Opcion: ");
                            op= dato.nextInt();
                            dato.nextLine();
                        }
                        System.out.printf("Ingrese fecha con el formato seleccionado: ");
                        fecha=dato.nextLine();
                        Fecha f2;
                        f2=util.cargarFecha(fecha, op);
                        if (util.compararFechas(f1, f2)==0){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("es menor a la fecha ");
                            util.mostrarFecha(f2);
                            System.out.printf("\n"); break;
                        }
                        else if (util.compararFechas(f1, f2)==1){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("es mayor a la fecha ");
                            util.mostrarFecha(f2);
                            System.out.printf("\n"); break;
                        }
                        else {
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("es igual a la fecha ");
                            util.mostrarFecha(f2);
                            System.out.printf("\n");
                        } break;
                case 2: dato.nextLine();
                        System.out.printf("Primera fecha\n");
                        System.out.printf("Seleccione formato: \n");
                        System.out.printf("0: dd-MM-yyyy\n1: MM-dd-yyyy\n");
                        System.out.printf("Opcion: ");
                        op=dato.nextInt();
                        dato.nextLine();
                        while (op!=0 && op!=1){
                            System.out.printf("Opcion invalida. Opcion: ");
                            op= dato.nextInt();
                            dato.nextLine();
                        }
                        System.out.printf("Ingrese fecha con el formato seleccionado: ");
                        fecha=dato.nextLine();
                        Fecha f3;
                        f3=util.cargarFecha(fecha, op);
                        System.out.printf("Segunda fecha\n");
                        System.out.printf("Seleccione formato: \n");
                        System.out.printf("0: dd-MM-yyyy\n1: MM-dd-yyyy\n");
                        System.out.printf("Opcion: ");
                        op=dato.nextInt();
                        dato.nextLine();
                        while (op!=0 && op!=1){
                            System.out.printf("Opcion invalida. Opcion: ");
                            op= dato.nextInt();
                            dato.nextLine();
                        }
                        System.out.printf("Ingrese fecha con el formato seleccionado: ");
                        fecha=dato.nextLine();
                        Fecha f4;
                        f4=util.cargarFecha(fecha, op);
                        if (util.fechaEntre(f1, f3, f4)==0){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("Es anterior a las fechas ingresadas\n");
                            util.mostrarFecha(f3);
                            util.mostrarFecha(f4);
                        }
                        else if (util.fechaEntre(f1, f3, f4)==1){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("se encuentra entre las fechas ingresadas\n");
                            util.mostrarFecha(f3);
                            util.mostrarFecha(f4);
                        }
                        else if (util.fechaEntre(f1, f3, f4)==2){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("es igual a la fecha ");
                            util.mostrarFecha(f3);
                        }
                        else if (util.fechaEntre(f1, f3, f4)==3){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("es igual a la fecha ");
                            util.mostrarFecha(f4);
                        }
                        else if (util.fechaEntre(f1, f3, f4)==4){
                            System.out.printf("\nLa fecha ");
                            util.mostrarFecha(f1);
                            System.out.printf("es mayor a las fechas ");
                            util.mostrarFecha(f3);
                            util.mostrarFecha(f4);
                        } break;
                case 0: break;
                default: System.out.printf("Opcion no valida\n");
            }
        }
    }
}