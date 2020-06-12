package entities;

/**
 *
 * @author hassan
 */
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;
    private int idService;
    private int idProfil;
    private int idSpecialite;
    

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, String pseudo, String mdp, int idService, int idSpecialite, int idProfil) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.idService = idService;
        this.idSpecialite = idSpecialite;
        this.idProfil = idProfil;
    }

    public Utilisateur(String nom, String prenom, String pseudo, String mdp, int idService, int idSpecialite, int idProfil) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.idService = idService;
        this.idSpecialite = idSpecialite;
        this.idProfil = idProfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", idService=" + idService + ", idSpecialite=" + idSpecialite + ", idProfil=" + idProfil + '}';
    }
    
    
    
}
