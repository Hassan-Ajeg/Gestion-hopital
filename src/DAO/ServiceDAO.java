package DAO;

import connection.SingleConnection;
import entities.Service;
import java.sql.*;
import java.util.*;

public class ServiceDAO {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public ServiceDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }

    //Liste des services
    public List<Service> selectAll() {
        List<Service> liste = new ArrayList();
        try {
            String sql = "SELECT * FROM services ORDER BY id";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setNomService(rs.getString("nom_service"));
                liste.add(service);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    
    //Rechercher un service par son id
    public Service selectOne(int id){
        Service service = null;
        try{
            String sql= "SELECT * FROM services WHERE id = ?";
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                service.setId(rs.getInt("id"));
                service.setNomService(rs.getString("nom_service"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return service;
        
    }
    
    //ajouter un service 
    public int insert(Service service){
        int affected = 0;
        try{
            String sql = "INSERT INTO services(nom_service) VALUES(?)";
             ps = cnx.prepareStatement(sql);
            ps.setString(1, service.getNomService());
            affected = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return affected;
    }
    //supprimer un service
    public int delete(String nomService){
        int affected = 0;
        try{
            String sql = "DELETE FROM services WHERE nom_service=?";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, nomService);
            affected = ps.executeUpdate();
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
        
        
        return affected;
    }
    

}
