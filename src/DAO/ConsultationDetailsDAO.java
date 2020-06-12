package DAO;

import connection.SingleConnection;
import entities.ConsultationDetails;
import java.sql.*;
import java.util.*;


/**
 *
 * @author hassan
 */
public class ConsultationDetailsDAO {
    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    ConsultationDetails details = new ConsultationDetails();
    public ConsultationDetailsDAO() {
         //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
        
    }
    
    //la methode retourne une liste avec les details d'une consultation 
    public List<ConsultationDetails> getDetails() {
        List<ConsultationDetails> liste = new ArrayList();
        try {
            String sql = "SELECT nss, nom, nom_pathologie, c.date_creation\n"
                    + "FROM consultations AS c\n"
                    + "INNER JOIN patients AS p\n"
                    + "INNER JOIN pathologies AS pa\n"
                    + "ON c.`id_patient` = p.`id` AND c.`id_pathologie` = pa.`id`;";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                details.setNss(rs.getLong("nss"));
                details.setNom(rs.getString("nom"));
                details.setNomPathologie(rs.getString("nom_pathologie"));
                details.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
                liste.add(details);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return liste;
    }

    
    
}
