package ar.unlu.poo.listaDeTareas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilidadesTareas {
    ArrayList<Tarea> listaDeTareas=new ArrayList<>();
    ArrayList<Colaborador> listaDeColaboradores=new ArrayList<>();
    ArrayList<LocalDate> listaDeFechas=new ArrayList<>();
    Scanner dato=new Scanner(System.in);

    public Tarea agregarTarea(String descripcion, String fechaLimite, String fechaRecordatorio, String prioridad){
        Integer i;
        Integer fechaAniadida=0;
        LocalDate fecha=LocalDate.parse(fechaLimite);
        LocalDate fecha2=LocalDate.parse(fechaRecordatorio);
        if (fecha2.isAfter(fecha)){
            System.out.printf("El recordatorio debe ser anterior a la fecha limite");
            return null;
        }
        else {
            Tarea tarea=new Tarea();
            tarea.setDescripcion(descripcion);
            tarea.setFechaRecordatorio(fecha2);
            tarea.setFechaLimite(fecha);
            tarea.setPrioridad(prioridad);
            this.comprobarVencimiento(tarea);
            listaDeTareas.add(tarea);
            if (listaDeFechas.isEmpty()){
                listaDeFechas.add(fecha);
            }
            else if (fecha.isBefore(listaDeFechas.get(0))){
                listaDeFechas.add(0,fecha);
            }
            else if (fecha.isAfter(listaDeFechas.get(listaDeFechas.size()-1))){
                listaDeFechas.add(fecha);
            }
            else {
                for (i=0; i<listaDeFechas.size(); i++){
                    if (fecha.isBefore(listaDeFechas.get(i)) && fecha.isAfter(listaDeFechas.get(i-1))){
                        listaDeFechas.add(i,fecha);
                        break;
                    }
                }
            }
            return tarea;
        }
    }

    public Tarea modificarTarea(Integer i, String descripcion, String prioridad){
        Tarea tarea=listaDeTareas.get(i);
        tarea.setDescripcion(descripcion);
        tarea.setPrioridad(prioridad);
        this.comprobarVencimiento(tarea);
        return tarea;
    }

    public Integer buscarTares(String descripcio){
        Integer i;
        Integer encontrada=0;
        for (i=0; i<listaDeTareas.size(); i++){
            if (listaDeTareas.get(i).getDescripcion().equals(descripcio)){
                encontrada=1;
                break;
            }
        }
        if (encontrada==1){
            return i;
        }
        else {
            return null;
        }
    }

    public void agregarColaborador(Tarea tarea, String nombre){
        Integer i;
        Integer encontrado=0;
        for (i=0; i<listaDeColaboradores.size(); i++){
            if (listaDeColaboradores.get(i).getNombre().equals(nombre)){
                encontrado=1;
                break;
            }
        }
        if (encontrado==1){
            tarea.getColaboradores().add(listaDeColaboradores.get(i));
        }
        else {
            Colaborador colaborador=new Colaborador();
            colaborador.setNombre(nombre);
            tarea.getColaboradores().add(colaborador);
            listaDeColaboradores.add(colaborador);
        }
    }

    public void comprobarVencimiento(Tarea tarea){
        if (tarea.getFechaLimite().isBefore(LocalDate.now())){
            tarea.setVencimiento("Vencida");
        }
        else {
            tarea.setVencimiento("Por vencer");
        }
    }

    public Integer completarTarea(String descTarea, String nombre){
        Integer i=0;
        Integer j=0;
        Integer tareaEncontrada=0;
        Integer colaboradorEncontrado=0;
        for (i=0; i<listaDeTareas.size(); i++){
            if (listaDeTareas.get(i).getDescripcion().equals(descTarea)){
                tareaEncontrada=1;
                break;
            }
        }
        if (tareaEncontrada==1){
            this.comprobarVencimiento(listaDeTareas.get(i));
            for (j=0; j<listaDeTareas.get(i).getColaboradores().size(); j++){
                if (listaDeTareas.get(i).getColaboradores().get(j).getNombre().equals(nombre)){
                    colaboradorEncontrado=1;
                    break;
                }
            }
            if (listaDeTareas.get(i).getVencimiento().equals("Vencida")){
                return 2;
            }
            else if (colaboradorEncontrado==0){
                return 3;
            }
            else {
                listaDeTareas.get(i).setFechaRealizada(LocalDate.now());
                listaDeTareas.get(i).setEstado("Completa ("+listaDeTareas.get(i).getColaboradores().get(j).getNombre()+"-"+listaDeTareas.get(i).getFechaRealizada()+")");
                listaDeTareas.get(i).getColaboradores().get(j).getTareasRealizadas().add(listaDeTareas.get(i));
                return 0;
            }
        }
        else {
            return 1;
        }
    }

    public void comprobarPrioridad(Tarea tarea){
        if (tarea.getFechaLimite().equals(LocalDate.now()) || tarea.getFechaLimite().equals(LocalDate.now().plusDays(1))){
            tarea.setPrioridad("3");
        }
    }

    public void mostrarTarea(String descTarea){
        Integer i;
        Integer j;
        Integer encontrada=0;
        for (i=0; i<listaDeTareas.size(); i++){
            if (listaDeTareas.get(i).getDescripcion().equals(descTarea)){
                encontrada=1;
                break;
            }
        }
        if (encontrada==1){
            Tarea tarea=listaDeTareas.get(i);
            this.comprobarVencimiento(tarea);
            this.comprobarPrioridad(tarea);
            System.out.printf(""+tarea.getDescripcion()+"\n"+tarea.getEstado()+" ("+tarea.getVencimiento()+")\nFecha de vencimiento: "+tarea.getFechaLimite()+"\nPrioridad: "+tarea.getPrioridad()+"\n");
            System.out.printf("Colaboradores: \n");
            for (j=0; j<tarea.getColaboradores().size(); j++){
                System.out.printf(""+tarea.getColaboradores().get(j).getNombre()+"\n");
            }
            System.out.printf("\n");
        }
        else {
            System.out.printf("Tarea no encontrada\n\n");
        }
    }

    public void mostrarListaDeTareas(){
        Integer i;
        for (i=0; i<listaDeTareas.size(); i++){
            this.mostrarTarea(listaDeTareas.get(i).getDescripcion());
        }
    }

    public void mostrarRecordatorios(){
        LocalDate hoy=LocalDate.now();
        Integer i;
        Tarea tareaAux;
        System.out.printf("Recordatorios:\n");
        for (i=0; i<listaDeTareas.size(); i++){
            tareaAux=listaDeTareas.get(i);
            if (tareaAux.getVencimiento().equals("Por vencer") && (tareaAux.getFechaRecordatorio().equals(hoy) || tareaAux.getFechaRecordatorio().equals(hoy.plusDays(1)))){
                System.out.printf(""+tareaAux.getDescripcion()+"- por vencer el "+tareaAux.getFechaLimite()+"\n");
            }
        }
    }

    public Integer mostrarColaborador(String nombre){
        Integer i;
        Integer j;
        Integer encontrado=0;
        for (i=0; i<listaDeColaboradores.size(); i++){
            if (listaDeColaboradores.get(i).getNombre().equals(nombre)){
                encontrado=1;
                break;
            }
        }
        if (encontrado==1){
            System.out.printf("\nTareas realizadas por "+listaDeColaboradores.get(i).getNombre()+":\n");
            for (j=0; j<listaDeColaboradores.get(i).getTareasRealizadas().size(); j++){
                System.out.printf(""+listaDeColaboradores.get(i).getTareasRealizadas().get(j).getDescripcion()+"\n");
            }
        }
        return encontrado;
    }

    public void mostrarPorPrioridad(){
        Integer i;
        for (i=0; i<listaDeTareas.size(); i++){
            Tarea tarea=listaDeTareas.get(i);
            this.comprobarVencimiento(tarea);
            if (tarea.getEstado().equals("Incompleta") && tarea.getVencimiento().equals("Por vencer") && tarea.getPrioridad().equals("3")){
                this.mostrarTarea(tarea.getDescripcion());
            }
        }
        for (i=0; i<listaDeTareas.size(); i++){
            Tarea tarea=listaDeTareas.get(i);
            if (tarea.getEstado().equals("Incompleta") && tarea.getVencimiento().equals("Por vencer") && tarea.getPrioridad().equals("2")){
                this.mostrarTarea(tarea.getDescripcion());
            }
        }
        for (i=0; i<listaDeTareas.size(); i++){
            Tarea tarea=listaDeTareas.get(i);
            if (tarea.getEstado().equals("Incompleta") && tarea.getVencimiento().equals("Por vencer") && tarea.getPrioridad().equals("1")){
                this.mostrarTarea(tarea.getDescripcion());
            }
        }
    }

    public void mostrarPorFecha(){
        Integer i;
        Integer j;
        for (i=0; i<listaDeFechas.size(); i++){
            LocalDate fecha=listaDeFechas.get(i);
            for (j=0; j<listaDeTareas.size(); j++){
                Tarea tarea=listaDeTareas.get(j);
                if (tarea.getEstado().equals("Incompleta") && tarea.getVencimiento().equals("Por vencer") && tarea.getFechaLimite().equals(fecha)){
                    this.mostrarTarea(tarea.getDescripcion());
                }
            }
        }
    }

    //Funcion diseñada especificamente para cumplir con la consigna del ejercicio 5, ya que la aplicacion
    //no permite marcar como "completa" una tarea ingresada con una fecha limite anterior a la fecha actual
    public void forzarEstado(Tarea tarea){
        tarea.setEstado("Completa");
    }
}
