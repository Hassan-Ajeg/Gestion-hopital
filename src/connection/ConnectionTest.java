package connection;

import java.sql.*;

public class ConnectionTest {
    
    public static void main(String[] args) {
        
        Connection cnx = null;
        String dbName = "gestion_hopital";
        String user = "root";
        String password = "root";
        
         try {
            //connexion à la BD
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/" + dbName, user, password);
            System.out.println("Connexion OK");
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
    }
}
