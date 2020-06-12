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
        cnx = SingleConnection.getInstance();
    }

    //liste des patients
    public List<Patient> selectAll() {
        List<Patient> liste = new ArrayList();

        try {
            String sql = "SELECT * FROM patients";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setNss(rs.getLong("nss"));
                patient.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
                liste.add(patient);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    //rechercher un patient en fonction de son NSS
    public Patient selectOne(long nss) {
        Patient patient = new Patient();
        try {
            String sql = "SELECT * FROM patients WHERE nss = ?";
            ps = cnx.prepareStatement(sql);
            ps.setLong(1, nss);
            rs = ps.executeQuery();
            while (rs.next()) {
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setNss(rs.getLong("nss"));
                patient.setDateDeCreation(rs.getDate("date_creation").toLocalDate());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return patient;
    }

    //supprimer un patient en fonction de son nss
    public int delete(long nss) {
        int affected = 0;
        try {
            String sql = "DELETE FROM patients WHERE nss = ?";
            ps = cnx.prepareStatement(sql);
            ps.setLong(1, nss);
            affected = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return affected;
    }

    //inserer un nouveau patient
    public int insert(Patient patient) {
        int affected = 0;

        try {
            String sql = "INSERT INTO patients(nom, prenom, nss, date_creation) VALUES(?, ?, ? , ?)";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setLong(3, patient.getNss());
            ps.setDate(4, java.sql.Date.valueOf(patient.getDateDeCreation()));
            affected = ps.executeUpdate();

        } catch (SQLException e) {
            affected = -1;
            System.out.println(e.getMessage());
        }

        return affected;
    }

    //test de SelectALL
    public static void main(String[] args) {
        List<Patient> list = new ArrayList();
        
        PatientDAO dao = new PatientDAO();
        Patient patient = new Patient();

        list = dao.selectAll();
        if (!list.isEmpty()) {
            for (Patient item : list) {
                System.out.println(item.getNss() + "  " + item.getNom());
            }
        } else {
            System.out.println("Liste vide ");
        }
        
        System.out.println("************ test Select One **********");
        
        patient = dao.selectOne(1650213333333l);
        System.out.println(patient.getNom() + " - " + patient.getPrenom());

    }
}
