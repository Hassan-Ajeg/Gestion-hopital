package entities;

public class Ordonnance {
    
    private int id;
    private int idConsultation;

    public Ordonnance() {
    }

    public Ordonnance(int id, int idConsultation) {
        this.id = id;
        this.idConsultation = idConsultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    @Override
    public String toString() {
        return "Ordonnance{" + "id=" + id + ", idConsultation=" + idConsultation + '}';
    }
    
    
    
    
}
