package ar.unlu.poo.ej9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {

    private String formato;
    private LocalDate fecha;
    private String fechaS;

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getFechaS() {
        return fechaS;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFechaS(String fechaS) {
        this.fechaS = fechaS;
    }
}
