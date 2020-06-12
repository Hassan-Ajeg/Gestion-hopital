package entities;

/**
 *
 * @author hassan
 */
public class UtilisateurDetails {
    
    private String nom;
    private String prenom;
    private String pseudo;
    private String profil;

    public UtilisateurDetails() {
    }

    public UtilisateurDetails(String nom, String prenom, String pseudo, String profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.profil = profil;
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

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    @Override
    public String toString() {
        return "UtilisateurDetails{" + "nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", profil=" + profil + '}';
    }
    
    
}
