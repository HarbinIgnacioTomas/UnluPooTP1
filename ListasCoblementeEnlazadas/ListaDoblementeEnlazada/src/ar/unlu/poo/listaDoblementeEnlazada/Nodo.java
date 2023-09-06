package ar.unlu.poo.listaDoblementeEnlazada;

public class Nodo {
    private Object dato;
    private Nodo proximo=null;
    private Nodo anterior=null;

    public void setDato(Object dato){
        this.dato=dato;
    }
    public Object getDato(){
        return dato;
    }
    public void setProximo(Nodo nodo){
        this.proximo=nodo;
    }
    public Nodo getProximo(){
        return proximo;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getAnterior() {
        return anterior;
    }
}
