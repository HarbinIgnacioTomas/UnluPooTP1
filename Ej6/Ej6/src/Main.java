import ar.unlu.poo.tp1ej6.Biblioteca;
import ar.unlu.poo.tp1ej6.Comparador;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Biblioteca bib=new Biblioteca();
        Scanner dato=new Scanner(System.in);
        Integer opcion=1;

        while (opcion!=0){
            System.out.printf("---MENU---\n");
            System.out.printf("Opcion 1: cargar libro.\n");
            System.out.printf("Opcion 2: cargar prestamo.\n");
            System.out.printf("Opcion 3: cargar devolucion.\n");
            System.out.printf("Opcion 4: consultar libro por titulo o autor.\n");
            System.out.printf("Opcion 5: consultar cantidad de prestamos actuales.\n");
            System.out.printf("Opcion 6: consultar cantidad de prestamos historicos.\n");
            System.out.printf("Opcion 7: consultar listado de libros.\n");
            System.out.printf("Opcion 8: utilizar clase comparador para cantidad de paginas.\n");
            System.out.printf("Opcion 0: salir.\n");

            System.out.printf("\nIngrese opcion: ");
            opcion=dato.nextInt();

            switch (opcion){
                case 1: bib.agregarLibro(); break;
                case 2: bib.prestar(); break;
                case 3: bib.devolucion(); break;
                case 4: bib.mostrarLibro(); break;
                case 5: bib.prestamosActuales(); break;
                case 6: bib.historiaPrestamos(); break;
                case 7: bib.mostrarListado(); break;
                case 8: Comparador comp=new Comparador();
                        comp.cargarComparacion(); break;
            }
            dato.nextLine();
        }
    }
}