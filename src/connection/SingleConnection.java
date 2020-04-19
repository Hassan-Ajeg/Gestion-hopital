package connection;

import java.sql.*;

public class SingleConnection {

    private static Connection cnx;
//Constructeur privé

    private SingleConnection(String url, String dbName, String user, String password) {
        
        try {
            cnx = (Connection) DriverManager.getConnection( url + dbName, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//Méthode qui crée/retourne l’instance unique

    public static Connection getInstance(String url, String dbName, String user, String password) {
        if (cnx == null) {
            new SingleConnection(url, dbName, user, password);
        }
        return cnx;
    }
}
