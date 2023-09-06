

import ar.unlu.poo.listaDoblementeEnlazada.ListaDoblementeEnlazada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.printf("El menu se encuentra diseñado con Strings pero la lista permite utilizar cualquier tipo de objeto.\n\n\n");

        ListaDoblementeEnlazada l=new ListaDoblementeEnlazada();
        Scanner dato=new Scanner(System.in);
        Integer op=1;
        Integer pos;
        String elemento;

        while (op!=0){

            System.out.printf("\n---MENU---\n");
            System.out.printf("Opcion 1: agregar elemento\n");
            System.out.printf("Opcion 2: buscar elemento\n");
            System.out.printf("Opcion 3: insertar elemento\n");
            System.out.printf("Opcion 4: eliminar elemento\n");
            System.out.printf("Opcion 5: recuperar elemento\n");
            System.out.printf("Opcion 6: consultar si la lista es vacia\n");
            System.out.printf("Opcion 7: mostrar lista\n");
            System.out.printf("Opcion 0: salir\n");
            System.out.printf("Opcion: ");

            op=dato.nextInt();
            dato.nextLine();

            switch (op){
                case 1: System.out.printf("Ingrese elemento a agregar: ");
                    elemento=dato.nextLine();
                    l.agregar(elemento); break;
                case 2: System.out.printf("Ingrese elemento a buscar: ");
                    elemento=dato.nextLine();
                    l.buscar(elemento); break;
                case 3: System.out.printf("Ingrese elemento a insertar: ");
                    elemento=dato.nextLine();
                    System.out.printf("Ingrese posicion: ");
                    pos=dato.nextInt();
                    dato.nextLine();
                    l.insertar(elemento,pos-1);
                    break;
                case 4: System.out.printf("Ingrese posicion de elemetno a eliminar: ");
                    pos=dato.nextInt();
                    dato.nextLine();
                    l.eliminar(pos);break;
                case 5: System.out.printf("Ingrese posicion de elemento a recuperar: ");
                    pos=dato.nextInt();
                    dato.nextLine();
                    l.recuperar(pos);
                    break;
                case 6: l.esVacia(); break;
                case 7: System.out.printf(""+l+"\n");
                case 0: break;
                default: System.out.printf("Opcion invalida\n");
            }

        }

    }
}