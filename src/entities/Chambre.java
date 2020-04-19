package entities;

public class Chambre {
    
    private int id;
    private int idService;
    private int etage;

    public Chambre() {
    }

    public Chambre(int id, int idService, int etage) {
        this.id = id;
        this.idService = idService;
        this.etage = etage;
    }

    public Chambre(int idService, int etage) {
        this.idService = idService;
        this.etage = etage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    @Override
    public String toString() {
        return "Chambre{" + "id=" + id + ", idService=" + idService + ", etage=" + etage + '}';
    }
    
    
    
    
}
