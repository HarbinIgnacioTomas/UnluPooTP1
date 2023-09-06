import ar.unlu.poo.pila.Pila;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("El menu se encuentra diseñado con Strings pero la pila permite utilizar cualquier tipo de objeto.\n\n\n");

        Pila p=new Pila();
        Scanner dato=new Scanner(System.in);
        Integer op=1;
        Integer pos;
        Object elem;
        String elemento;

        while (op!=0){

            System.out.printf("\n---MENU---\n");
            System.out.printf("Opcion 1: apilar\n");
            System.out.printf("Opcion 2: desapilar\n");
            System.out.printf("Opcion 3: recuperar tope\n");
            System.out.printf("Opcion 4: consultar si la pila es vacia\n");
            System.out.printf("Opcion 5: mostrar pila\n");
            System.out.printf("Opcion 0: salir\n");
            System.out.printf("Opcion: ");

            op=dato.nextInt();
            dato.nextLine();

            switch (op){
                case 1: System.out.printf("Ingrese elemento a apilar: ");
                    elemento=dato.nextLine();
                    p.apilar(elemento); break;
                case 2: elem=p.desapilar(); break;
                case 3: elem=p.recuperar();break;
                case 4: p.esVacia();break;
                case 5: p.mostrarPila();
                case 0: break;
                default: System.out.printf("Opcion invalida\n");
            }

        }
    }
}