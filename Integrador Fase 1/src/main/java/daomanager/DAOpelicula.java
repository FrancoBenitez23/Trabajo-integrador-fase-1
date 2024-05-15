package daomanager;

import model.Pelicula;

import java.util.List;
import java.util.Map;

public interface DAOpelicula {
    public void busquedaTitulo(String titulo);
    List<Pelicula> todasPeliculas();
    void agregarPelicula(Pelicula pelicula);
    void eliminarPeli(int codigo);
    void modificarPelicula(Pelicula pelicula);
}
