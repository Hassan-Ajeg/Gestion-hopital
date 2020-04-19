package entities;

import java.util.*;

public class Hospitalisation {
    
    private int id;
    private int idPatient;
    private int idChambre;
    private Date dateEntree;
    private Date dateSortie;

    public Hospitalisation() {
    }

    public Hospitalisation(int id, int idPatient, int idChambre, Date dateEntree, Date dateSortie) {
        this.id = id;
        this.idPatient = idPatient;
        this.idChambre = idChambre;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
    }

    public Hospitalisation(int id, int idPatient, int idChambre) {
        this.id = id;
        this.idPatient = idPatient;
        this.idChambre = idChambre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return "Hospitalisation{" + "id=" + id + ", idPatient=" + idPatient + ", idChambre=" + idChambre + ", dateEntree=" + dateEntree + ", dateSortie=" + dateSortie + '}';
    }
    
    
}
