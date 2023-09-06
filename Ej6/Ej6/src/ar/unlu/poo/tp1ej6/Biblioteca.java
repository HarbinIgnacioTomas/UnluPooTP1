package ar.unlu.poo.tp1ej6;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    Integer cant_libros=0;
    Integer cant_prestamos=0;
    ArrayList<Libro> libros=new ArrayList<>();
    Scanner dato=new Scanner(System.in);

    public Libro agregarLibro(){

        String chars;
        Integer val=0;
        Libro libro=new Libro();

        System.out.printf("Ingrese titulo: ");
        libro.setTitulo(dato.nextLine());
        System.out.printf("Ingres autor: ");
        libro.setAutor(dato.nextLine());
        System.out.printf("Ingrse numero de paginas: ");
        chars=dato.nextLine();
        if (chars.compareTo("0")<1){
            System.out.printf("ERROR. Valor de paginas invalido\n");
            return null;
        }
        libro.setCant_pags(chars);
        System.out.printf("Ingrese cantidad de ejemplares: ");
        Integer ejem=dato.nextInt();
        dato.nextLine();
        while (ejem<1){
            System.out.printf("Valor invalido. Ingrese cantidad de ejemplares:");
            ejem=dato.nextInt();
            dato.nextLine();
        }
        libro.setCant_ejemplares(ejem);
        libros.add(libro);
        cant_libros++;
        return libro;
    }

    public void prestar(){
        Integer encontrado=0;
        String buscado;
        Integer i;
        System.out.printf("Ingrese el titulo del libro a prestar: ");
        buscado= dato.nextLine();
        for (i=0; i<cant_libros; i++){
            if (libros.get(i).getTitulo().equals(buscado)){
                encontrado=1;
                break;
            }
        }
        if (encontrado==1){
            if (libros.get(i).getCant_ejemplares()==1){
                System.out.printf("ERROR. Solo queda un ejemplar del libro solicitado.\n");
            }
            else {
                libros.get(i).setCant_prestados(libros.get(i).getCant_prestados()+1);
                libros.get(i).setCant_ejemplares(libros.get(i).getCant_ejemplares()-1);
                cant_prestamos++;
            }
        }
        else {
            System.out.printf("Libro no encontrado\n");
        }

    }

    public void devolucion(){
        Integer encontrado=0;
        Integer i;
        String devuelto;
        System.out.printf("Ingrese el libro devuelto: ");
        devuelto=dato.nextLine();
        for (i=0; i<cant_libros; i++){
            if (libros.get(i).getTitulo().equals(devuelto)){
                encontrado=1;
                break;
            }
        }
        if (encontrado==1){
            if (libros.get(i).getCant_prestados()==0){
                System.out.printf("No hay ejemplares prestados del libro seleccionado.\n");
            }
            else {
                libros.get(i).setCant_prestados(libros.get(i).getCant_prestados()-1);
                libros.get(i).setCant_ejemplares(libros.get(i).getCant_ejemplares()+1);
            }
        }
        else {
            System.out.printf("Libro no encontrado\n");
        }
    }

    public void mostrarLibro(){
        String buscado;
        Integer encontrado=0;
        Integer i;
        System.out.printf("Ingrese el titulo o autor a consultar: ");
        buscado=dato.nextLine();
        for (i=0; i<cant_libros; i++){
            if (libros.get(i).getTitulo().equals(buscado) || libros.get(i).getAutor().equals(buscado)){
                encontrado=1;
                System.out.printf("El libro "+libros.get(i).getTitulo()+" creado por el autor "+libros.get(i).getAutor()+" tiene "+libros.get(i).getCant_pags()+" páginas, quedan "+libros.get(i).getCant_ejemplares()+" disponibles y se prestaron "+libros.get(i).getCant_prestados()+"\n");
            }
        }
        if (encontrado==0){
            System.out.printf("Libro no encontrado\n");
        }

    }

    public Integer prestamosActuales(){
        Integer presatamos=0;
        Integer i;
        for (i=0; i<cant_libros; i++){
            presatamos+=libros.get(i).getCant_prestados();
        }
        System.out.printf("Hay "+presatamos+" libros prestados en este momento.\n");
        return presatamos;
    }

    public Integer historiaPrestamos(){
        System.out.printf("Se realizaron "+cant_prestamos+" prestamos en total.\n");
        return cant_prestamos;
    }

    public void mostrarListado(){
        Integer i;
        for (i=0; i<cant_libros; i++){
            System.out.printf("El libro "+libros.get(i).getTitulo()+" creado por el autor "+libros.get(i).getAutor()+" tiene "+libros.get(i).getCant_pags()+" páginas, quedan "+libros.get(i).getCant_ejemplares()+" disponibles y se prestaron "+libros.get(i).getCant_prestados()+"\n");
        }
    }
}
