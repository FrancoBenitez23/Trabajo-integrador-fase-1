package daomanager;

import model.Pelicula;

import java.util.List;
import java.util.Map;

public interface ActionsDao {
    public Map<Integer, String> busquedaTitulo(String titulo);

    public List<Map<Integer, String>> busquedaGenero(String genero);

    public List<Map<String, String>> busquedaCodigo(int codigo);

    public void altaPelicula(Pelicula pelicula);

    public void bajaPelicula(int codigo);

    public void modificacionPelicula(int codigoPelicula, Pelicula nuevaPelicula);

}
