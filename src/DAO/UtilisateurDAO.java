package DAO;

import connection.SingleConnection;
import entities.Utilisateur;
import java.sql.*;
import java.util.*;

/**
 *
 * @author hassan
 */
public class UtilisateurDAO {

    Connection cnx = null;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
     Utilisateur utilisateur = new Utilisateur();

    public UtilisateurDAO() {
        //connexion à la BD dans le constructeur en passant par singleConnection
        cnx = SingleConnection.getInstance();
    }

    //liste des utilisateurs
    public ArrayList<Utilisateur> selectAll() {
        ArrayList<Utilisateur> liste = new ArrayList();
       
        try {
            String sql = "SELECT * FROM utilisateurs";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setIdService(rs.getInt("id_service"));
                utilisateur.setIdProfil(rs.getInt("id_profil"));
                utilisateur.setIdSpecialite(rs.getInt("id_specialite"));
                liste.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    //recherche un utilisateur avec son id
    public Utilisateur selectOne(int id) {
        Utilisateur utilisateur = null;

        try {
            String sql = "SELECT * FROM utilisateurs WHERE id= ?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setIdService(rs.getInt("id_service"));
                utilisateur.setIdProfil(rs.getInt("id_profil"));
                utilisateur.setIdSpecialite(rs.getInt("id_specialite"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return utilisateur;
    }

    //ajouter un utilisateur
    public int insert(Utilisateur utilisateur) {
        int affected = 0;
        if (utilisateur == null) {
            System.out.println("Veuillez saisir toutes les infos !");
        } else {
            try {
                String sql = "INSERT INTO utilisateurs(nom, prenom, pseudo, mdp, id_service, id_profil, id_specialite) VALUES(?, ?, ?, ?,?, ?, ?)";
                ps = cnx.prepareStatement(sql);
                ps.setString(1, utilisateur.getNom());
                ps.setString(2, utilisateur.getPrenom());
                ps.setString(3, utilisateur.getPseudo());
                ps.setString(4, utilisateur.getMdp());
                ps.setInt(5, utilisateur.getIdService());
                ps.setInt(6, utilisateur.getIdProfil());
                ps.setInt(7, utilisateur.getIdSpecialite());
                affected = ps.executeUpdate();

            } catch (SQLException e) {
                affected = -1;
                System.out.println(e.getMessage());
            }
        }

        return affected;
    }

    //supprimer un utilisateur
    public int delete(Utilisateur utilisateur) {
        int affected = 0;
        try {
            String sql = "DELETE FROM utilisateurs WHERE id=?";
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, utilisateur.getId());
            affected = ps.executeUpdate();

        } catch (SQLException e) {
            affected = -1;
            System.out.println(e.getMessage());
        }

        return affected;
    }

    //mettre à jour un utilisateur
    public int update(Utilisateur utilisateur) {
        int affected = 0;
        try {
            String sql = "UPDATE utilisateurs set nom= ?, prenom= ?, pseudo= ?, mdp= ?, id_service= ?, id_profil= ?, id_specialite= ? WHERE id= ?";
            ps = cnx.prepareStatement(sql);
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getPseudo());
            ps.setString(4, utilisateur.getMdp());
            ps.setInt(5, utilisateur.getIdService());
            ps.setInt(6, utilisateur.getIdProfil());
            ps.setInt(7, utilisateur.getIdSpecialite());
            ps.setInt(8, utilisateur.getId());
            affected = ps.executeUpdate();

        } catch (SQLException e) {
            affected = -1;
            System.out.println(e.getMessage());
        }

        return affected;
    }

    //trouver un utilisateur avec son pseudo
    public Utilisateur findByLogin(String pseudo, String mdp) {
        Utilisateur utilisateur = new Utilisateur();
        try {
            String sql = "SELECT * FROM utilisateurs WHERE pseudo= ? AND mdp = ? LIMIT 1";
            System.out.println(cnx);
            ps = cnx.prepareStatement(sql);
            ps.setString(1, pseudo);
            ps.setString(2, mdp);
            rs = ps.executeQuery();
            while (rs.next()) {

                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setMdp(rs.getString("mdp"));
                utilisateur.setIdService(rs.getInt("id_service"));
                utilisateur.setIdProfil(rs.getInt("id_profil"));
                utilisateur.setIdSpecialite(rs.getInt("id_specialite"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return utilisateur;
    }

    /*SELECT nom, prenom, pseudo, nom_profil
    FROM utilisateurs AS u INNER JOIN profils AS p
    WHERE u.id_profil = p.id; */
 /*public static void main(String[] args) {
        List<Utilisateur> liste = new ArrayList();
        UtilisateurDAO dao = new UtilisateurDAO();
        liste = dao.selectAll();
        for(Utilisateur user : liste){
            System.out.println(user);
        }
    }*/
}
