package entities;

public class AgentAdministratif {

    private int id;
    private String nom;
    private String prenom;
    private int idAgent;
    private String motDePasse;
    private int idService;

    public AgentAdministratif() {
        super();
    }

    public AgentAdministratif(int id, String nom, String prenom, int idAgent, String motDePasse, int idService) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idAgent = idAgent;
        this.motDePasse = motDePasse;
        this.idService = idService;
    }
    

    public AgentAdministratif(String nom, String prenom, int idAgent, String motDePasse, int idService) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.idAgent = idAgent;
        this.motDePasse = motDePasse;
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

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
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
        return "AgentAdministratif [nom=" + nom + ", prenom=" + prenom + ", idAgent=" + idAgent
                + ", motDePAsse=" + motDePasse + ", idService=" + idService + "]";
    }

}
