package ar.unlu.poo.ej8;

public class Contrasenia {
    UtilidadesContrsenia util =new UtilidadesContrsenia();
    private Integer longitud=8;
    private String contrasenia = util.generar(longitud);

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Integer getLongitud() {
        return longitud;
    }
}
