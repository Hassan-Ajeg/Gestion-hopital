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
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setNss(rs.getInt("nss"));
                patient.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
                liste.add(patient);
            }
        }catch(SQLException e){
            
        }
        return liste;
    }
    
    //rechercher un patient en fonction de son NSS
    public Patient selectOne(int id){
        Patient patient = null;
        try{
            String sql = "SELECT * FROM patients WHERE id = ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setNss(rs.getInt("nss"));
                patient.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
            }
           
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return patient;
    }
    //inserer un nouveau medecin
    public int insert(Patient patient) {
        int affected = 0;
        
        try{
            String sql = "INSERT INTO patients(nom, prenom, nss, date_creation) VALUES(?, ?, ? , ?)";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setInt(3, patient.getNss());
            ps.setDate(4, java.sql.Date.valueOf(patient.getDateDeCreation()));
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        
        return affected;
    }
    
}
