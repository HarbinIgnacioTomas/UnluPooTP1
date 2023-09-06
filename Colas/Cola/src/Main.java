import ar.unlu.poo.cola.Cola;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.printf("El menu se encuentra diseñado con Strings pero la cola permite utilizar cualquier tipo de objeto.\n\n\n");

        Cola c=new Cola();
        Scanner dato=new Scanner(System.in);
        Integer op=1;
        Integer pos;
        Object elem;
        String elemento;

        while (op!=0){

            System.out.printf("\n---MENU---\n");
            System.out.printf("Opcion 1: encolar\n");
            System.out.printf("Opcion 2: desencolar\n");
            System.out.printf("Opcion 3: recuperar base\n");
            System.out.printf("Opcion 4: consultar si la calo es vacia\n");
            System.out.printf("Opcion 5: mostrar cola\n");
            System.out.printf("Opcion 0: salir\n");
            System.out.printf("Opcion: ");

            op=dato.nextInt();
            dato.nextLine();

            switch (op){
                case 1: System.out.printf("Ingrese elemento a encolar: ");
                    elemento=dato.nextLine();
                    c.encolar(elemento); break;
                case 2: elem=c.desencolar(); break;
                case 3: elem=c.recuperar();break;
                case 4: c.esVacia();break;
                case 5: c.mostrarCola();
                case 0: break;
                default: System.out.printf("Opcion invalida\n");
            }

        }

    }
}