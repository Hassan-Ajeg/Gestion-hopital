package DAO;

import connection.SingleConnection;
import entities.Ordonnance;
import java.sql.*;
import java.util.*;

public class OrdonnanceDAO {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    
    public OrdonnanceDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance(url, dbName, user, password);
    }

    //Liste des ordonnances 
    public List<Ordonnance> selectAll() {
        List<Ordonnance> liste = new ArrayList();
        try {
            String sql = "SELECT * FROM ordonnances";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Ordonnance ordonnance = new Ordonnance();
                ordonnance.setId(rs.getInt("id"));
                ordonnance.setIdConsultation(rs.getInt("id_consultation"));
                liste.add(ordonnance);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    //rechercher une ordonnance en fonction de l'id
    public Ordonnance selectOne(int id) {
        Ordonnance ordonnance = null;
        try {
            String sql = "SELECT * FROM ordonnances WHERE id=?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ordonnance.setId(rs.getInt("id"));
                ordonnance.setIdConsultation(rs.getInt("id_consultation"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ordonnance;
    }
}
