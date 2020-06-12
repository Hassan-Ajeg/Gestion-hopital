package DAO;

import connection.SingleConnection;
import entities.Specialite;
import java.sql.*;
import java.util.*;

public class SpecialiteDAO {
    
    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    
    public SpecialiteDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }

    //liste des specialités
    public List<Specialite> selectAll() {
        List<Specialite> liste = new ArrayList();
        try {
            String sql = "SELECT * FROM specialites ORDER BY id";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Specialite specialite = new Specialite();
                specialite.setId(rs.getInt("id"));
                specialite.setNomSpecialite(rs.getString("nom_specialite"));
                liste.add(specialite);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return liste;
    }

    //rechercher une specialité en fonction de son id
    public Specialite selectOne(int id) {
        Specialite specialite = null;
        
        try {
            String sql = "SELECT * FROM specialites WHERE id = ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                specialite.setId(rs.getInt("id"));
                specialite.setNomSpecialite(rs.getString("nom_specialite"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return specialite;
        
    }
}
