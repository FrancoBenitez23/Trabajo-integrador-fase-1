package ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionDB {
    default Connection getConnection(){
        try {
            final String URL = "jdbc:mysql://localhost/integrador_fase_1_peliculas";
            final String USER = "root";
            final String PASSWORD = "Ninguna123-";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            return conn ;

        } catch (SQLException sqlExcex) {
            sqlExcex.printStackTrace();
            return null;
        }
    }
}
