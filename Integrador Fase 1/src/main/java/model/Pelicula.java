package model;

public class Pelicula {
    private int codigo;
    private String titulo;
    private String url;
    private String generos;
    private String imagen;

    public Pelicula(String titulo, String url, String generos, String imagen) {
        this.titulo = titulo;
        this.url = url;
        this.generos = generos;
        this.imagen = imagen;
    }

    public Pelicula(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public Pelicula() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
