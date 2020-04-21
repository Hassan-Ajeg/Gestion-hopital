package DAO;

import connection.SingleConnection;
import entities.Medecin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO {
    
    
    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public MedecinDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance(url, dbName, user, password);
    }
    //liste des medecins
    public List<Medecin> selectAll() {
        List<Medecin> liste = new ArrayList();

        try {
            String sql = "SELECT * FROM medecins";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
                medecin.setIdPraticien(rs.getInt("id_praticien"));
                medecin.setIdService(rs.getInt("id_service"));
                medecin.setIdSpecialite(rs.getInt("id_specialite"));
                liste.add(medecin);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }
    //rechercher un medecin en fonction de son id_praticien
    public Medecin selectOne(int id) {
        Medecin medecin = null;
        
        try{
            String sql = "SELECT * FROM medecins WHERE id = ?";
            ps= cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
                medecin.setIdPraticien(rs.getInt("id_praticien"));
                medecin.setIdService(rs.getInt("id_service"));
                medecin.setIdSpecialite(rs.getInt("specialite"));
                
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        return medecin;
    }
    
    //inserer un nouveau medecin
    public int insert(Medecin medecin) {
        int affected = 0;
        
        try{
            String sql = "INSERT INTO medecins(nom, prenom,mot_de_passe, id_praticien, id_service, id_specialite) VALUES(?, ?, ? , ? ,?, ?)";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getMotDePasse());
            ps.setInt(4, medecin.getIdPraticien());
            ps.setInt(5, medecin.getIdService());
            ps.setInt(6, medecin.getIdSpecialite());
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        
        return affected;
    }
}
