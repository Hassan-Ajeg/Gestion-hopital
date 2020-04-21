package entities;

public class Medecin {
    
    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private int idPraticien;
    private int idService;
    private int idSpecialite;

    public Medecin() {
        super();
    }

    public Medecin(String nom, String prenom,String motDePasse, int idPraticien, int idService, int idSpecialite) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.idPraticien = idPraticien;
        this.idService = idService;
    }

    public Medecin(String nom, String prenom, int idService, int idSpecialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.idService = idService;
        this.idSpecialite = idSpecialite;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    

    public int getIdPraticien() {
        return idPraticien;
    }

    public void setIdPraticien(int idPraticien) {
        this.idPraticien = idPraticien;
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

    @Override
    public String toString() {
        return "Medecin{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", idPraticien=" + idPraticien + ", idService=" + idService + ", idSpecialite=" + idSpecialite + '}';
    }

    
}
