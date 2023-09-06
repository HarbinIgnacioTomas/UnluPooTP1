package ar.unlu.poo.pila;

public class Pila {
    private Nodo primero=null;
    private Integer lon=0;

    public void apilar(Object dato){
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

    public void esVacia(){
        if (primero==null){
            System.out.printf("Pila vacia\n");
        }

        else {
            System.out.printf("Pila no vacia\n");
        }
    }

    public Object desapilarSinMostrar(){
        int i;
        Object dato;
        Nodo nodoAux=primero;
        if (lon==1){
            dato=primero.getDato();
            primero=null;
            lon--;
            return dato;
        }
        while (nodoAux.getProximo().getProximo()!=null){
            nodoAux=nodoAux.getProximo();
        }
        dato=nodoAux.getProximo().getDato();
        nodoAux.setProximo(null);
        lon--;
        return dato;
    }

    public Object desapilar(){
        if (primero==null){
            System.out.printf("Pila vacia.\n");
            return null;
        }
        else {
            Object dato;
            dato=desapilarSinMostrar();
            System.out.printf("Valor: "+dato+"\n");
            return dato;
        }
    }

    public Object recuperar(){
        if (primero==null){
            System.out.printf("Pila vacia.\n");
            return null;
        }
        else {
            Object dato;
            Nodo nodoAux=primero;
            while (nodoAux.getProximo().getProximo()!=null){
                nodoAux=nodoAux.getProximo();
            }
            dato=nodoAux.getProximo().getDato();
            System.out.printf("Valor: "+dato+"\n");
            return dato;
        }
    }


    public void mostrarPila(){

        Object dato;
        Pila pilaAux=new Pila();
        Nodo nodoAux=primero;
        String acumulador="";

        if (primero==null){
            System.out.printf("Pila Vacia.\n");
        }
        else {
            while (lon>0) {
                dato=this.desapilar();
                pilaAux.apilar(dato);
            }
            while (pilaAux.lon>0){
                dato=pilaAux.desapilarSinMostrar();
                this.apilar(dato);
            }
        }
    }
}
