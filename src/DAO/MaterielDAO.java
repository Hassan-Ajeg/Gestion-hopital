package DAO;

import connection.SingleConnection;
import entities.Materiel;
import java.sql.*;
import java.util.*;

public class MaterielDAO {
    
    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    
    public MaterielDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }

    //liste des matériaux
    public List<Materiel> selectAll() {
        List<Materiel> liste = new ArrayList();
        
        try {
            String sql = "SELECT * FROM materiels";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Materiel materiel = new Materiel();
                materiel.setId(rs.getInt("id"));
                materiel.setDesignation(rs.getString("designation"));
                materiel.setQuantite(rs.getInt("quantite"));
                liste.add(materiel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    //rechercher un matériel en fonction de son id
    public Materiel selectOne(int id) {
        Materiel materiel = null;
        try {
            String sql = "SELECT * FROM materiels WHERE id= ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiel.setId(rs.getInt("id"));
                materiel.setDesignation(rs.getString("designation"));
                materiel.setQuantite(rs.getInt("quantite"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return materiel;
    }
    
    //inserer un nouveau matériel
    public int insert(Materiel materiel){
        int affected = 0;
        
        try{
            String sql = "INSERT INTO materiels(designation, quantite) VALUES(?,?)";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, materiel.getDesignation());
            ps.setInt(2, materiel.getQuantite());
            affected = ps.executeUpdate();
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        return affected;
    }
    //supprimer un matériel
    public int delete(String designation){
        int affected = 0;
        try {
            String sql = "DELETE FROM materiels WHERE designation= ?";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, designation);
            affected = ps.executeUpdate();
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        return affected;
    }
    
    //mise à jour d'un matériel
    public int update(Materiel materiel){
        int affected = 0;
        try{
            String sql = "UPDATE materiels SET designation= ?, quantite= ? WHERE id= ?";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, materiel.getDesignation());
            ps.setInt(2, materiel.getQuantite());
            ps.setInt(3, materiel.getId());
            affected = ps.executeUpdate();
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        return affected;
    }
    
}
