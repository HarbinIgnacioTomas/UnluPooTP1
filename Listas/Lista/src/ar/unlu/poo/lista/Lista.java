package ar.unlu.poo.lista;

public class Lista {
    private Nodo primero=null;
    private Integer lon=0;



    public void longitud(){
        System.out.printf("La lista tiene %d elementos\n", lon);
    }

    public void esVacia(){
        if (primero==null){
            System.out.printf("Lista vacia.\n");
        }
        else {
            System.out.printf("Lista no vacia.\n");
        }
    }

    public void agregar(Object dato){
        Nodo nuevoNodo=new Nodo();
        nuevoNodo.setDato(dato);
        if (primero==null){
            primero=nuevoNodo;
            lon++;
        }
        else {
            Nodo nodoAux=primero;
            while (nodoAux.getProximo()!=null){
                nodoAux=nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
            lon++;
        }
    }

    public void insertar(Object dato, int pos){

        int i;
        Nodo nodoAux=primero;
        Nodo nuevoNodo=new Nodo();
        nuevoNodo.setDato(dato);

        if (pos<0){
            System.out.printf("Ingrese indice valido.\n");
        }
        else if (primero==null && pos==0) {
            primero = nuevoNodo;
            lon++;
        }
        else if (primero!=null && pos==0){
            primero=nuevoNodo;
            primero.setProximo(nodoAux);
        }
        else {
            if (pos>lon+1){
                System.out.printf("ERROR. La lista tiene %d elementos\n", lon);
            }
            else {
                nodoAux=primero;
                for (i = 0; i < pos - 1; i++) {
                    nodoAux = nodoAux.getProximo();
                }
                nuevoNodo.setProximo(nodoAux.getProximo());
                nodoAux.setProximo(nuevoNodo);
                lon++;
            }
        }
    }

        public Object recuperar(int pos){
        int i;
        Nodo nodoAux=primero;

        if (pos>lon) {
            System.out.printf("Elemento no encontrado. La lista tiene %d elementos.\n", lon);
            return null;
        }
        else {
            nodoAux=primero;
            for (i=0; i<pos-2; i++) {
                nodoAux = nodoAux.getProximo();
            }
            System.out.printf(""+nodoAux.getDato()+"\n");
            return nodoAux.getDato();
        }
    }

    public void eliminar(int pos){
        int i;
        Nodo nodoAux=primero;

        if (pos<1){
            System.out.printf("Ingrese indice valido.\n");
        }
        else if (pos>lon) {
            System.out.printf("Elemento no encontrado. La lista tiene %d elementos.\n", lon);
        }

        else {
            nodoAux = primero;
            for (i = 0; i < pos - 2; i++) {
                nodoAux = nodoAux.getProximo();
            }
            Nodo eliminar = nodoAux.getProximo();
            nodoAux.setProximo(eliminar.getProximo());
            lon--;
        }
    }

    public String toString(){
        String acumulador= "";
        Integer i=1;
        Nodo nodoAux=primero;
        if (primero==null){
            System.out.printf("Lista Vacia.\n");
        }
        else {
            while (nodoAux!=null){
                acumulador+="Nodo " + i + " " + nodoAux.getDato() + "\n";
                i++;
                nodoAux=nodoAux.getProximo();
            }
        }
        return acumulador;
    }

    public Nodo iterador(Nodo nodo){
        if (nodo.getProximo()!=null){
            nodo=nodo.getProximo();
            return nodo;
        }
        else {
            System.out.printf("Se encuentra en el ultimo nodo de la lista.\n");
            return null;
        }
    }

    public Object buscar(Object elemento){
        Integer econtrado=0;
        Nodo nodoAux=primero;
        while ((nodoAux.getDato()!=elemento || nodoAux.getDato().equals(elemento)) && nodoAux.getProximo()!=null){
            nodoAux=nodoAux.getProximo();
        }
        if (nodoAux.getDato()==elemento || nodoAux.getDato().equals(elemento)){
            System.out.printf("Elemento encontrado en la lista\n");
            return nodoAux.getDato();
        }
        else if (primero.getDato()==elemento || primero.getDato().equals(elemento)){
            System.out.printf("Elemento encontrado en la lista\n");
            return primero.getDato();
        }
        else {
            System.out.printf("Elemento no encontrado en la lista\n");
            return null;
        }
    }
}

