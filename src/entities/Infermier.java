package entities;

public class Infermier {
    
    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private int idService;

    public Infermier() {
    }

    public Infermier(int id,String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Infermier(String nom, String prenom, String motDePasse, int idService) {
         this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.idService = idService;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Infermier{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse + ", idService=" + idService + '}';
    }

   
    
}
