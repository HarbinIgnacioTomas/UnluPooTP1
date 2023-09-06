import ar.unlu.poo.ej8.Contrasenia;
import ar.unlu.poo.ej8.UtilidadesContrsenia;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UtilidadesContrsenia util=new UtilidadesContrsenia();
        Contrasenia contrasenia=new Contrasenia();
        util.mostrarContrasenia(contrasenia);

        Integer primera=0;
        Integer opcion=1;
        Integer num;
        Scanner dato=new Scanner(System.in);

        while (opcion!=0){
            System.out.printf("\nOpcion 1: regenerar y cambiar longitud\n");
            System.out.printf("Opcion 2: regenerar contrasenia fuerte\n");
            System.out.printf("Opcion 3: generar contrasenias por cantidad\n");
            System.out.printf("Opcion 0: salir\n");
            System.out.printf("\nOpcion: ");

            opcion= dato.nextInt();

            switch (opcion){
                case 1: dato.nextLine();
                        System.out.printf("Ingrese nueva longitud: ");
                        num=dato.nextInt();
                        if (num<1){
                            System.out.printf("Valor no valido\n"); break;
                        }
                        util.reGenerar(contrasenia, num);
                        util.mostrarContrasenia(contrasenia); break;
                case 2: util.hacerFuerte(contrasenia);
                        break;
                case 3: Integer lon; Integer cant_contra;
                        dato.nextLine();
                        System.out.printf("Ingrese cantidad de contrasenias a generar: ");
                        cant_contra= dato.nextInt();
                        if (cant_contra<1){
                            System.out.printf("Valor no valido\n"); break;
                        }
                        dato.nextLine();
                        System.out.printf("Ingrese longitud de las contrasenias: ");
                        lon=dato.nextInt();
                        dato.nextLine();
                        if (lon<1){
                            System.out.printf("Valor no valido\n"); break;
                        }
                        util.generarPorCantidad(cant_contra, lon);
                        break;
                case 0: break;
                default: System.out.printf("Opcion no valida\n"); break;
            }
        }
    }
}