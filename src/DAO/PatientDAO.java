package DAO;

import connection.SingleConnection;
import entities.Patient;
import java.sql.*;
import java.util.*;


public class PatientDAO {
     Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public PatientDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance(url, dbName, user, password);
    }
    //liste des patients
    public List<Patient> selectAll(){
        List<Patient> liste = new ArrayList();
        
        try{
            String sql = "SELECT * FROM patients";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setNss(rs.getInt("nss"));
                patient.setDateDeCreation(rs.getDate("date_creation"));
                liste.add(patient);
            }
        }catch(SQLException e){
            
        }
        return liste;
    }
    
    //rechercher un patient en fonction de son NSS
    public Patient selectOne(int nss){
        Patient patient = null;
        
        
        
        return patient;
    }
    
}
