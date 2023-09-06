package ar.unlu.poo.tp1ej6;

public class Comparador {


    public void cargarComparacion(){
        Biblioteca bibComp=new Biblioteca();
        System.out.printf("Primer libro:\n");
        bibComp.agregarLibro();
        if (bibComp.agregarLibro()==null){
            return;
        }
        System.out.printf("Segundo libro:\n");
        bibComp.agregarLibro();
        if (bibComp.agregarLibro()==null){
            return;
        }
        compararLibros(bibComp.libros.get(0), bibComp.libros.get(1));
    }

    public void compararLibros(Libro libro1, Libro libro2){
        System.out.printf("---Libro 1---\nTitulo: "+libro1.getTitulo()+"\nAutor: "+libro1.getAutor()+"\nCantidad de paginas: "+libro1.getCant_pags()+"\n");
        System.out.printf("---Libro 2---\nTitulo: "+libro2.getTitulo()+"\nAutor: "+libro2.getAutor()+"\nCantidad de paginas: "+libro2.getCant_pags()+"\n");
        Integer pags1=Integer.parseInt(libro1.getCant_pags());
        Integer pags2=Integer.parseInt(libro2.getCant_pags());
        if (pags1>pags2){
            System.out.printf("\nEl libro 1 tiene mas paginas.\n");
        }
        else if (pags1<pags2){
            System.out.printf("El libro 2 tiene mas paginas.\n");
        }
        else {
            System.out.printf("Ambos libros tienen la misma cantidad de paginas.\n");
            }
    }
}
