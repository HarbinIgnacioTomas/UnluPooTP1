package ar.unlu.poo.ej11;

import java.util.ArrayList;

public class Diccionario {
    ArrayList<String> diccionario=new ArrayList<>();

    public void agregarPalabra(String palabra){
        diccionario.add(palabra);
    }

    public boolean buscarPalabra(String palabra) {
        Integer i;
        for (i=0; i<diccionario.size(); i++){
            if (palabra.equals(diccionario.get(i))){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getDiccionario() {
        return diccionario;
    }
}
