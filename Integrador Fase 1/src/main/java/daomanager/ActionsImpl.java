package daomanager;

import ds.ConnectionDB;
import model.Pelicula;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionsImpl implements ConnectionDB, ActionsDao {
    @Override
    public Map<Integer, String> busquedaTitulo(String tituloPeli) {
        Map<Integer, String> mapaInfo = new HashMap<>();

        String query = "select codigo, titulo from Pelicula where titulo like ?";
        try(Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, tituloPeli);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String tituloBD = rs.getString("titulo");
                mapaInfo.put(codigo, tituloBD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapaInfo;
    }

    @Override
    public List<Map<Integer, String>> busquedaGenero(String genero) {
        List<Map<Integer, String>> listaInfo = new ArrayList<>();
        String query = "SELECT pelicula.codigo, pelicula.titulo from pelicula inner join genero on genero.codigo = pelicula.codigo where genero.genero = ?";
        try(Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, genero); // Agrega los comodines % alrededor del valor del género
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String tituloBD = rs.getString("titulo");
                Map<Integer,String> peliculaInfo = new HashMap<>();
                peliculaInfo.put(codigo, tituloBD);
                listaInfo.add(peliculaInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaInfo;
    }


    @Override
    public List<Map<String, String>> busquedaCodigo(int codigo) {
        List<Map<String, String>> listaPeliculas = new ArrayList<>();

        String query = "select * from pelicula where codigo = ?";
        try(Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Map<String, String> peliculaInfo = new HashMap<>();

                int codigoBD = rs.getInt("codigo");
                String tituloBD = rs.getString("titulo");
                String url = rs.getString("url");
                String genero = rs.getString("genero_id");
                String imagen = rs.getString("imagen");

                peliculaInfo.put("codigo", Integer.toString(codigoBD));
                peliculaInfo.put("titulo", tituloBD);
                peliculaInfo.put("url", url);
                peliculaInfo.put("genero", genero);
                peliculaInfo.put("imagen", imagen);

                listaPeliculas.add(peliculaInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPeliculas;
    }

    @Override
    public void altaPelicula(Pelicula pelicula) {
        String queryObtenerGeneroId = "SELECT codigo FROM genero WHERE genero = ?";
        String queryInsertarPelicula = "INSERT INTO pelicula (titulo, url, genero_id, imagen) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmtGeneroId = connection.prepareStatement(queryObtenerGeneroId);
             PreparedStatement pstmtInsertarPelicula = connection.prepareStatement(queryInsertarPelicula)) {

            File file = new File(pelicula.getImagen());
            file.isFile();
            file.canRead();

            FileInputStream reader = new FileInputStream(file);
            byte[] bytesImagen = new byte[(int) file.length()];
            reader.read(bytesImagen);

            pstmtGeneroId.setString(1, pelicula.getGeneros());
            ResultSet rs = pstmtGeneroId.executeQuery();
            if (rs.next()) {
                int generoId = rs.getInt("codigo");

                // Establecer los parámetros de la consulta de inserción en la tabla 'pelicula'
                pstmtInsertarPelicula.setString(1, pelicula.getTitulo());
                pstmtInsertarPelicula.setString(2, pelicula.getUrl());
                pstmtInsertarPelicula.setInt(3, generoId);
                pstmtInsertarPelicula.setBytes(4, bytesImagen);

                int rowsAffected = pstmtInsertarPelicula.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("La película ha sido insertada correctamente en la base de datos.");
                } else {
                    System.out.println("Error al insertar la película en la base de datos.");
                }
            } else {
                System.out.println("No se encontró ningún género con el nombre proporcionado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void bajaPelicula(int codigo) {
        String query = "delete from pelicula WHERE codigo = ?";
        PreparedStatement statement = null;
        try(Connection connection = getConnection();){
            statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);

            int rowsaffected = statement.executeUpdate();
            if(rowsaffected==0){
                System.out.println("La Pelicula con el id: " + codigo + "No fue eliminada");
            }
            System.out.println("La Pelicula con el id: " + codigo + " fue eliminada correctamente");


        }catch (SQLException sqlEX){
            sqlEX.printStackTrace();
        }finally {
            try{
                statement.close();
            }catch (SQLException sqlEX){
                sqlEX.printStackTrace();
            }
        }
    }

    @Override
    public void modificacionPelicula(int codigoPelicula, Pelicula nuevaPelicula) {
        String query = "UPDATE Pelicula SET titulo = ?, url = ?, genero_id = ?, imagen = ? WHERE codigo = ?";
        PreparedStatement statement = null;

        try (Connection connection = getConnection()) {
            // Obtenemos el ID del género basado en el nombre proporcionado en la película
            String queryObtenerGeneroId = "SELECT codigo FROM genero WHERE genero = ?";
            try (PreparedStatement pstmtGeneroId = connection.prepareStatement(queryObtenerGeneroId)) {
                pstmtGeneroId.setString(1, nuevaPelicula.getGeneros());
                ResultSet rs = pstmtGeneroId.executeQuery();
                if (rs.next()) {
                    int generoId = rs.getInt("codigo");

                    // Cargamos la nueva imagen de la película
                    File file = new File(nuevaPelicula.getImagen());
                    file.isFile();
                    file.canRead();
                    FileInputStream reader = new FileInputStream(file);
                    byte[] bytesImagen = new byte[(int) file.length()];
                    reader.read(bytesImagen);

                    // Actualizamos la película utilizando el código proporcionado
                    statement = connection.prepareStatement(query);
                    statement.setString(1, nuevaPelicula.getTitulo());
                    statement.setString(2, nuevaPelicula.getUrl());
                    statement.setInt(3, generoId); // Utilizamos el ID del género en la actualización
                    statement.setBytes(4, bytesImagen);
                    statement.setInt(5, codigoPelicula); // Condición de igualdad para el código proporcionado

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("La película con el código " + codigoPelicula + " ha sido modificada correctamente.");
                    } else {
                        System.out.println("No se encontró ninguna película con el código " + codigoPelicula + ".");
                    }
                } else {
                    throw new IllegalArgumentException("No se encontró ningún género con el nombre proporcionado: " + nuevaPelicula.getGeneros());
                }
            }
        } catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException sqlEX) {
                sqlEX.printStackTrace();
            }
        }
    }




}