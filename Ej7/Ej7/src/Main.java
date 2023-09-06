import ar.unlu.poo.ej7.Formula;
import ar.unlu.poo.ej7.ListadoFormulas;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        ListadoFormulas lista=new ListadoFormulas();
        Integer opcion=1;
        Scanner dato=new Scanner(System.in);

        while (opcion!=0){
            System.out.printf("\n---MENU---\n");
            System.out.printf("Opcion 1: cargar nueva formula.\n");
            System.out.printf("Opcion 2: consultar formulas cargadas.\n");
            System.out.printf("Opcion 3: calcular raices.\n");
            System.out.printf("Opcion 4: evaluar Y en funcion de X.\n");
            System.out.printf("Opcion 0: salir\n");
            System.out.printf("\nOpcion: ");

            opcion= dato.nextInt();

            switch (opcion){
                case 1: lista.agregarFormula(); break;
                case 2: lista.mostrarListado(); break;
                case 3: lista.calcularRaices(); break;
                case 4: lista.evaluarFuncion(); break;

                case 0: break;
                default: System.out.printf("\nIngrese valor valido");
            }
        }
    }
}