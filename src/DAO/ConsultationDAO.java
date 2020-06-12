package DAO;

import connection.SingleConnection;
import entities.Consultation;
import static java.lang.String.valueOf;
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
        cnx = SingleConnection.getInstance();
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
                //consultation.setIdUtilisateur(rs.getInt("id_utilisateur"));
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
    public Consultation selectOne(int id) {
        Consultation consultation = null;
        try {
            String sql = "SELECT * FROM consultations WHERE id = ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                consultation.setId(rs.getInt("id"));
                //consultation.setIdUtilisateur(rs.getInt("id_utilisateur"));
                consultation.setIdPatient(rs.getInt("id_patient"));
                consultation.setIdPathologie(rs.getInt("id_pathologie"));
                consultation.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return consultation;
    }

    //ajouter une consultation
    public int insert(Consultation consultation) {
        int affected = 0;
        try {
            String sql = "INSERT INTO consultations(id_patient, id_pathologie, date_creation) VALUES(?, ?, ?)";
            ps = cnx.prepareStatement(sql);
            //ps.setInt(1, consultation.getIdUtilisateur());
            ps.setInt(1, consultation.getIdPatient());
            ps.setInt(2, consultation.getIdPathologie());
            ps.setDate(3, java.sql.Date.valueOf(consultation.getDateDeCreation()));
            affected = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return affected;
    }

    
}
