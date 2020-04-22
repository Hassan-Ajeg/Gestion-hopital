package DAO;

import connection.SingleConnection;
import entities.Consultation;
import java.sql.*;
import java.util.*;

public class ConsultationDAO {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public ConsultationDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance(url, dbName, user, password);
    }

    //récupérer l'ensemble des consultations
    public List<Consultation> selectAll() {
        List<Consultation> liste = new ArrayList();
        try {
            String sql = "SELECT * FROM consultations";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Consultation consultation = new Consultation();
                consultation.setId(rs.getInt("id"));
                consultation.setIdMedecin(rs.getInt("id_medecin"));
                consultation.setIdPatient(rs.getInt("id_patient"));
                consultation.setIdPathologie(rs.getInt("id_pathologie"));
                consultation.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
                liste.add(consultation);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    //récupérer une consultation en fonction de son id 
    public Consultation selectOne(int id){
        Consultation consultation = null;
        try{
            String sql = "SELECT * FROM consultations WHERE id = ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                consultation.setId(rs.getInt("id"));
                consultation.setIdMedecin(rs.getInt("id_medecin"));
                consultation.setIdPatient(rs.getInt("id_patient"));
                consultation.setIdPathologie(rs.getInt("id_pathologie"));
                consultation.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return consultation;
    }
}
