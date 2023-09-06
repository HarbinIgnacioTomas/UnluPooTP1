package ar.unlu.poo.cola;

public class Cola {
    private Integer lon=0;
    private Nodo primero=null;

    public void encolar(Object dato){
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

    public Object desencolar(){
        if (primero==null){
            System.out.printf("Cola vacia.\n");
            return null;
        }
        else {
            Object dato;
            dato=primero.getDato();
            System.out.printf("Valor: "+dato+"\n");
            primero=primero.getProximo();
            return dato;
        }
    }

    public Object recuperar(){
        if (primero==null){
            System.out.printf("Cola vacia.\n");
            return null;
        }
        else {
            Object dato;
            dato=primero.getDato();
            System.out.printf("Valor: "+dato+"\n");
            return dato;
        }
    }

    public void mostrarCola(){
        if (primero==null){
            System.out.printf("Cola vacia.\n");
        }
        else{
            Nodo nodoAux=primero;
            Integer i=1;
            while (nodoAux!=null){
                System.out.printf("Elemento "+i+": "+ nodoAux.getDato()+"\n");
                i++;
                nodoAux=nodoAux.getProximo();
            }

        }
    }

    public void esVacia(){
        if (primero==null){
            System.out.printf("Cola vacia\n");
        }
        else {
            System.out.printf("Cola no vacia\n");
        }
    }
}
















