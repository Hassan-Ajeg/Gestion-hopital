package DAO;

import connection.SingleConnection;
import entities.Hospitalisation;
import java.sql.*;
import java.util.*;

/**
 *
 * @author hassan
 */
public class HospitalisationDAO {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public HospitalisationDAO() {
         //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }
    
    //liste de toutes les hospitalisations
    public List<Hospitalisation> selectAll(){
        List<Hospitalisation> liste = new ArrayList();
        try{
            String sql = "SELECT * FROM hospitalisations";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Hospitalisation hospitalisation = new Hospitalisation();
                hospitalisation.setId(rs.getInt("id"));
                hospitalisation.setIdPatient(rs.getInt("id_patient"));
                hospitalisation.setIdChambre(rs.getInt("id_chambre"));
                hospitalisation.setDateEntree(rs.getDate("date_entree").toLocalDate());
                hospitalisation.setDateEntree(rs.getDate("date_sortie").toLocalDate());
                liste.add(hospitalisation);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return liste;
    } 
    
    //récupérer une hospitalisation en fonction 
    public Hospitalisation selectOne(int id){
        Hospitalisation hospitalisation = null;
        try{
            String sql = "SELECT * FROM hospitalisations WHERE id = ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                hospitalisation.setId(rs.getInt("id"));
                hospitalisation.setIdPatient(rs.getInt("id_patient"));
                hospitalisation.setIdChambre(rs.getInt("id_chambre"));
                hospitalisation.setDateEntree(rs.getDate("date_entree").toLocalDate());
                hospitalisation.setDateSortie(rs.getDate("date_sortie").toLocalDate());
            }
       
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return hospitalisation;
    }
    
    //Inserer une nouvelle hospitalisation dans la bd
    public int insert(Hospitalisation hospitalisation){
        int affected = 0;
        
        try{
            String sql = "INSERT INTO hospitalisations(id_patient, id_chambre, date_entree, date_sortie) VALUES(?, ?, ?, ?)";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, hospitalisation.getIdPatient());
            ps.setInt(1, hospitalisation.getIdChambre());
            ps.setDate(4, java.sql.Date.valueOf(hospitalisation.getDateEntree()));
            ps.setDate(4, java.sql.Date.valueOf(hospitalisation.getDateSortie()));
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            affected = -1;
            System.out.println(e.getMessage());
        }
             
        
        return affected;
    }
    
    

}
