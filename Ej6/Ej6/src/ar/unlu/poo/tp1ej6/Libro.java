package ar.unlu.poo.tp1ej6;

public class Libro {
    private String titulo;
    private String autor;
    private String cant_pags;
    private Integer cant_ejemplares;
    private Integer cant_prestados=0;

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setAutor(String autor) {
        this.autor=autor;
    }
    public void setCant_pags(String cant_pags) {
        this.cant_pags=cant_pags;
    }
    public void setCant_ejemplares(Integer cant_ejemplares){
        this.cant_ejemplares=cant_ejemplares;
    }
    public void setCant_prestados(Integer cant_prestados){
        this.cant_prestados=cant_prestados;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getCant_pags() {
        return cant_pags;
    }
    public Integer getCant_ejemplares() {
        return cant_ejemplares;
    }
    public Integer getCant_prestados() {
        return cant_prestados;
    }
}
