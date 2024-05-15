package daomanager;

import ds.ConnectionDB;
import model.Genero;
import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOpeliculaImpl implements DAOpelicula, ConnectionDB {

    @Override
    public void busquedaTitulo(String titulo) {
        String query = "SELECT codigo, titulo FROM peliculas WHERE titulo LIKE ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + titulo + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println(String.format("%nNo se pudo encontrar la/s película/s que incluyen: %s", titulo));
            } else {
                System.out.println(String.format("%nListado de película/s encontrada/s:%n"));
                System.out.println("Código\t| Título");
                System.out.println("-----------------------------------------------");

                do {
                    System.out.println(String.format("%d\t| %s", resultSet.getInt("codigo"), resultSet.getString("titulo")));
                } while (resultSet.next());

            }

        } catch (SQLException ex) {
            System.out.println("Error al conectarse con la base de datos" + ex.getMessage());
        }
    }


    @Override
    public List<Pelicula> todasPeliculas() {
        String query = "SELECT * FROM peliculas";
        List<Pelicula> peliculas = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pelicula pelicula = resultSetPeliculaObtener(resultSet);
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse con la base de datos" + ex.getMessage());
        }
        return peliculas;
    }

    private Pelicula resultSetPeliculaObtener(ResultSet resultSet) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setCodigo(resultSet.getInt("codigo"));
        pelicula.setTitulo(resultSet.getString("titulo"));
        pelicula.setDirector(resultSet.getString("director"));
        pelicula.setUrl(resultSet.getString("url"));
        pelicula.setImagen(resultSet.getBytes("imagen"));

        return pelicula;
    }


    @Override
    public void agregarPelicula(Pelicula pelicula) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String queryP = "INSERT INTO peliculas (titulo, director, url, imagen) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(queryP, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getDirector());
            statement.setString(3, pelicula.getUrl());
            statement.setBytes(4, pelicula.getImagen());
            int rowsAffectedP = statement.executeUpdate();

            if (rowsAffectedP == 0) {
                throw new Exception("No se pudo agregar la película: " + pelicula);
            }

            resultSet = statement.getGeneratedKeys();
            int peliculaId = -1;
            if (resultSet.next()) {
                peliculaId = resultSet.getInt(1);
            }

            if (peliculaId != -1) {
                for (Genero genero : pelicula.getGeneros()) {
                    String queryPG = "INSERT INTO peliculas_generos (codigoPelicula, idGenero) VALUES (?, ?)";
                    statement = connection.prepareStatement(queryPG);
                    statement.setInt(1, peliculaId);
                    statement.setInt(2, genero.getId());
                    int rowsAffectedPG = statement.executeUpdate();

                    if (rowsAffectedPG == 0) {
                        throw new Exception("No se pudo agregar la relación película-géneros de la película: " + pelicula);
                    }

                }
            }
        } catch (Exception ex) {
            System.out.println("Error al conectarse con la base de datos" + ex.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error al intentar cerrar el resultset" + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error al intentar cerrar el statement" + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al conectarse con la base de datos" + e.getMessage());
                }
            }
        }
    }


    @Override
    public void eliminarPeli(int codigo) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statementPG = connection.prepareStatement("DELETE FROM peliculas_generos WHERE codigoPelicula = ?")) {
                statementPG.setInt(1, codigo);
                int rowsAffectedPG = statementPG.executeUpdate();
                if (rowsAffectedPG == 0) {
                    throw new SQLException("No se pudo eliminar la relación película-géneros de la película con código: " + codigo);
                }
            }

            try (PreparedStatement statementP = connection.prepareStatement("DELETE FROM peliculas WHERE codigo = ?")) {
                statementP.setInt(1, codigo);
                int rowsAffectedP = statementP.executeUpdate();
                if (rowsAffectedP == 0) {
                    throw new SQLException("No se pudo eliminar la película con código: " + codigo);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse con la base de datos" + ex.getMessage());
        }
    }


    @Override
    public void modificarPelicula(Pelicula pelicula) {
        try (Connection connection = getConnection()) {
            String queryP = "UPDATE peliculas SET titulo = ?, director = ?, url = ?, imagen = ? WHERE codigo = ?";
            try (PreparedStatement statement = connection.prepareStatement(queryP)) {
                statement.setString(1, pelicula.getTitulo());
                statement.setString(2, pelicula.getDirector());
                statement.setString(3, pelicula.getUrl());
                statement.setBytes(4, pelicula.getImagen());
                statement.setInt(5, pelicula.getCodigo());
                int rowsAffectedP = statement.executeUpdate();

                if (rowsAffectedP == 0) {
                    throw new SQLException("No se pudo modificar la película: " + pelicula);
                }
            }

            String queryPG = "DELETE FROM peliculas_generos WHERE codigoPelicula = ?";
            try (PreparedStatement statement = connection.prepareStatement(queryPG)) {
                statement.setInt(1, pelicula.getCodigo());
                int rowsAffectedPG = statement.executeUpdate();

                if (rowsAffectedPG == 0) {
                    throw new SQLException("No se pudo modificar la relación película-géneros de la película: " + pelicula);
                }
            }

            for (Genero genero : pelicula.getGeneros()) {
                queryPG = "INSERT INTO peliculas_generos (codigoPelicula, idGenero) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(queryPG)) {
                    statement.setInt(1, pelicula.getCodigo());
                    statement.setInt(2, genero.getId());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse con la base de datos" + ex.getMessage());
        }
    }


}
