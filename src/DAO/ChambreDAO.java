package DAO;

import connection.SingleConnection;
import entities.Chambre;
import java.sql.*;
import java.util.*;

public class ChambreDAO {
     Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    
    public ChambreDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance(url, dbName, user, password);
    }
    
    //liste des chambres
    public List<Chambre> selectAll(){
        List<Chambre> liste = new ArrayList();
        try{
            String sql = "SELECT * FROM chambres";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Chambre chambre = new Chambre();
                chambre.setId(rs.getInt("id"));
                chambre.setIdService(rs.getInt("id_service"));
                chambre.setEtage(rs.getInt("etage"));
                liste.add(chambre);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return liste;
    }
    //Rechercher une chambre par son id
    public Chambre selectOne(int id){
        Chambre chambre = new Chambre();
        try{
            String sql = "SELECT * FROM chambres WHERE id = ?";
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                chambre.setId(rs.getInt("id"));
                chambre.setIdService(rs.getInt("id_service"));
                chambre.setId(rs.getInt("etage"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return chambre;
    }
}
