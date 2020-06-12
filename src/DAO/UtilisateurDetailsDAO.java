package DAO;

import connection.SingleConnection;
import entities.UtilisateurDetails;
import java.sql.*;
import java.util.*;

/**
 *
 * @author hassan
 */
public class UtilisateurDetailsDAO {

    Connection cnx = null;
    String url = "jdbc:mysql://127.0.0.1:8889/";
    String dbName = "gestion_hopital";
    String user = "root";
    String password = "root";
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public UtilisateurDetailsDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }

    //la méthode retourne les details des utilisateurs
    public List<UtilisateurDetails> getUsersDetails() {
        List<UtilisateurDetails> liste = new ArrayList();
        try {
            String sql = "SELECT nom, prenom, pseudo, p.nom_profil\n"
                    + "FROM utilisateurs AS u\n"
                    + "INNER JOIN profils AS p\n"
                    + "ON u.id_profil = p.id\n"
                    + "ORDER BY u.id;";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                UtilisateurDetails userDetails = new UtilisateurDetails();
                userDetails.setNom(rs.getString("nom"));
                userDetails.setPrenom(rs.getString("prenom"));
                userDetails.setPseudo(rs.getString("pseudo"));
                userDetails.setProfil(rs.getString("p.nom_profil"));
                liste.add(userDetails);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

}
