package entities;

public class Pathologie {
    
    private int id;
    private String nomPathologie;

    public Pathologie() {
    }

    public Pathologie(int id, String nomPathologie) {
        this.id = id;
        this.nomPathologie = nomPathologie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPathologie() {
        return nomPathologie;
    }

    public void setNomPathologie(String nomPathologie) {
        this.nomPathologie = nomPathologie;
    }

    @Override
    public String toString() {
        return "Pathologie{" + "id=" + id + ", nomPathologie=" + nomPathologie + '}';
    }
    
    
}
