package ar.unlu.poo.ej9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UtilidadesFechas {

    public Fecha cargarFecha(String fecha, Integer op) {

        Fecha fecha1=new Fecha();

        DateTimeFormatter formato1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formato2=DateTimeFormatter.ofPattern("MM-dd-yyyy");

        LocalDate f1;

        if (op==0){
            f1=LocalDate.parse(fecha,formato1);
            fecha1.setFormato("dd-MM-yyyy");
        }
        else {
            f1=LocalDate.parse(fecha,formato2);
            fecha1.setFormato("MM-dd-yyyy");
        }
        fecha1.setFecha(f1);
        fecha1.setFechaS(fecha);
        return fecha1;
    }

    public Integer compararFechas(Fecha f1, Fecha f2){

        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha1=LocalDate.parse(f1.getFechaS(), formato);
        LocalDate fecha2=LocalDate.parse(f2.getFechaS(), formato);
        if (fecha1.isBefore(fecha2)){
            return 0;
        }
        else if (fecha1.isAfter(fecha2)){
            return 1;
        }
        else {
            return 2;
        }
    }

    public Integer fechaEntre (Fecha f1, Fecha f2, Fecha f3){
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha1=LocalDate.parse(f1.getFechaS(), formato);
        LocalDate fecha2=LocalDate.parse(f2.getFechaS(), formato);
        LocalDate fecha3=LocalDate.parse(f3.getFechaS(), formato);

        if (fecha1.isBefore(fecha2) && fecha1.isBefore(fecha3)){
            return 0;
        }
        else if (fecha1.isBefore(fecha2) && fecha1.isAfter(fecha3)){
            return 1;
        }
        else if (fecha1.isBefore(fecha3) && fecha1.isAfter(fecha2)){
            return 1;
        }
        else if (fecha1.isEqual(fecha2)){
            return 2;
        }
        else if (fecha1.isEqual(fecha3)){
            return 3;
        }
        else {
            return 4;
        }
    }

    public void mostrarFecha(Fecha fecha){
        DateTimeFormatter formato= DateTimeFormatter.ofPattern(fecha.getFormato());
        String forma=fecha.getFormato();
        System.out.printf(""+fecha.getFecha().format(formato)+" ("+forma+")\n");
    }
}
