package daomanager;

import model.Genero;
import model.Pelicula;

import java.util.List;

public interface DAOpeliculaGenero {
    public void pelisPorGenero(String genero);
    List<Genero> pelisPorCodigo(int codigo);
}
