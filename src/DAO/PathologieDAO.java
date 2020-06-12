package DAO;

import connection.SingleConnection;
import entities.Pathologie;
import java.sql.*;
import java.util.*;

/**
 *
 * @author hassan
 */
public class PathologieDAO {
     Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public PathologieDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }
    //liste des pathologies
    public List<Pathologie> seletAll(){
        List<Pathologie> liste = new ArrayList();
        try{
             String sql = "SELECT * FROM pathologies ORDER BY id;";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pathologie pathologie = new Pathologie();
                pathologie.setId((rs.getInt("id")));
                pathologie.setNomPathologie(rs.getString("nom_pathologie"));
                liste.add(pathologie);
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
        
        return liste;
    }
    
    //rechercher une pathologie avec son id
    public Pathologie selectOne(int id){
        Pathologie pathologie = null;
        try{
            String sql = "SELECT *FROM pathologies WHERE id=?";
             ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pathologie.setId(rs.getInt("id"));
                pathologie.setNomPathologie(rs.getString("nom_pathologie"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
         return pathologie;
    }
    
    //supprimer une pathologie
    public int delete(Pathologie pathologie){
        int affected = 0;
        try{
            String sql = "DELETE FROM services WHERE id=?";
            ps.setInt(1, pathologie.getId());
            affected = ps.executeUpdate();
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        return affected;
    }
    
    //ajouter une pathologie
    public int insert(Pathologie pathologie){
        int affected = 0;
        try{
            String sql = "INSERT INTO pathologies(nom_pathologie) VALUES(?)";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, pathologie.getNomPathologie());
            affected = ps.executeUpdate();
            
        }catch(Exception e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        return affected;
    }
    
    
    
}
