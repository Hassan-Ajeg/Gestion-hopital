package DAO;

import connection.SingleConnection;
import entities.Profil;
import java.sql.*;
import java.util.*;

/**
 *
 * @author hassan
 */
public class ProfilDAO {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public ProfilDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }

    //liste des profils
    public List<Profil> selectAll() {
        List<Profil> liste = new ArrayList();

        try {
            String sql = "SELECT * FROM profils ORDER BY id";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Profil profil = new Profil();
                profil.setId(rs.getInt("id"));
                profil.setNomProfil(rs.getString("nom_profil"));
                liste.add(profil);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    
    //Ajouter un profil
    public int insert(Profil profil){
        int affected = 0;
        try{
            String sql = "INSERT INTO profils(nom_profil) VALUES(?)";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, profil.getNomProfil());
            affected = ps.executeUpdate();
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        
        return affected;
    }
    
    //supprimer un profil
    public int delete(String nomProfil){
        int affected = 0;
        try{
            String sql = "DELETE FROM profils WHERE nom_profil = ?";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, nomProfil);
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        return affected;
    }

}
