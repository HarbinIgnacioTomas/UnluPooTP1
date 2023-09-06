package ar.unlu.poo.ej11;

public class Jugador {
    private Integer puntaje=0;
    private String nombre;

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
