package connection;

import java.sql.*;

public class SingleConnection {

    private static Connection cnx;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
//Constructeur privé

    private SingleConnection() {
        
        try {
            cnx = (Connection) DriverManager.getConnection( url + dbName, user, password);
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//Méthode qui crée/retourne l’instance unique

    public static Connection getInstance() {
        if (cnx == null) {
            new SingleConnection();
        }
        return cnx;
    }
}


