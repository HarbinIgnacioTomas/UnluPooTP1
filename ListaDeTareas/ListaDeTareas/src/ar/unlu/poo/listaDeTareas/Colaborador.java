package ar.unlu.poo.listaDeTareas;

import java.util.ArrayList;

public class Colaborador {
    private String nombre;
    private ArrayList<Tarea> tareasRealizadas=new ArrayList<>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Tarea> getTareasRealizadas() {
        return tareasRealizadas;
    }
    public void agregarRealizada(Tarea tarea){
        tareasRealizadas.add(tarea);
    }
}
