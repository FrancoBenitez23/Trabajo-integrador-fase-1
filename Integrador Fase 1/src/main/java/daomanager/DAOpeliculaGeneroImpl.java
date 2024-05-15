package daomanager;

import ds.ConnectionDB;
import model.Genero;
import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOpeliculaGeneroImpl implements DAOpeliculaGenero, ConnectionDB {
    @Override
    public void pelisPorGenero(String genero){
        String query = "SELECT p.* FROM peliculas p INNER JOIN peliculas_generos pg ON p.codigo = pg.codigoPelicula INNER JOIN genero g ON pg.idGenero = g.codigo WHERE g.genero LIKE ? order by 1";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + genero + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Boolean hayRegistros = resultSet.next();

            if (hayRegistros == false) {
                System.out.println("\nNo se pudo encontrar la/s película/s que incluyen: " + genero);
            } else {
                System.out.println("\nListado de película/s encontrada/s:");
                System.out.println("\n------------------------------------");
                System.out.println("Código"	+ "	" + "| Título");

                do {
                    Integer codigoBuscado = resultSet.getInt(1);
                    String tituloBuscado = resultSet.getString(2);
                    System.out.println(codigoBuscado + "	| " + tituloBuscado);
                } while (resultSet.next());

            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion: " + ex.getMessage());
        }
    }


    @Override
    public List<Genero> pelisPorCodigo(int codigo) {
        String query = "SELECT g.* FROM genero g INNER JOIN peliculas_generos pg ON g.codigo = pg.idGenero WHERE pg.codigoPelicula = ?";
        List<Genero> generos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setId(resultSet.getInt("codigo"));
                genero.setNombre(resultSet.getString("genero"));
                generos.add(genero);
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion: " + ex.getMessage());
        }
        return generos;
    }

}
