package entities;

public class Technicien {

    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private int idService;

    public Technicien() {
        super();
    }

    public Technicien(String nom, String prenom, String motDePasse, int idService) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.idService = idService;
    }

    public Technicien(int id, String nom, String prenom, int idService) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idService = idService;
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

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Technicien{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse + ", idService=" + idService + '}';
    }

}
