package daomanager;

import ds.ConnectionDB;
import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class DAOgeneroImpl implements DAOgenero, ConnectionDB {
    String query = "SELECT * FROM genero";
    @Override
    public List<Genero> obtenerGeneros() {
        List<Genero> generos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
