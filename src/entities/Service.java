package entities;

public class Service {
    
    private int id;
    private String nomService;

    public Service() {
    }

    public Service(int id, String nomService) {
        this.id = id;
        this.nomService = nomService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", nomService=" + nomService + '}';
    }
    
    
    
}
