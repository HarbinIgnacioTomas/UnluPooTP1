package ar.unlu.poo.listaDeTareas;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea {
    private String descripcion;
    private LocalDate fechaLimite;
    private String prioridad;
    private String estado="Incompleta";
    private String vencimiento;
    private LocalDate fechaRealizada;
    private LocalDate fechaRecordatorio;
    private ArrayList<Colaborador> colaboradores=new ArrayList<>();

    public String getDescripcion() {
        return descripcion;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaRealizada(LocalDate fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public LocalDate getFechaRealizada() {
        return fechaRealizada;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public void setFechaRecordatorio(LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public LocalDate getFechaRecordatorio() {
        return fechaRecordatorio;
    }
}
