package entities;

public class Materiel {
    
    private int id;
    private String designation;
    private int quantite;

    public Materiel() {
    }

    public Materiel(int id, String designation, int quantite) {
        this.id = id;
        this.designation = designation;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Materiel{" + "id=" + id + ", designation=" + designation + ", quantite=" + quantite + '}';
    }
    
    
    
}
