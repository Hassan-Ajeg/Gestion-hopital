package entities;

import java.time.LocalDate;
import java.util.*;

public class Hospitalisation {
    
    private int id;
    private int idPatient;
    private int idChambre;
    private LocalDate dateEntree;
    private LocalDate dateSortie;

    public Hospitalisation() {
    }

    public Hospitalisation(int id, int idPatient, int idChambre, LocalDate dateEntree, LocalDate dateSortie) {
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

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(LocalDate dateEntree) {
        this.dateEntree = dateEntree;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return "Hospitalisation{" + "id=" + id + ", idPatient=" + idPatient + ", idChambre=" + idChambre + ", dateEntree=" + dateEntree + ", dateSortie=" + dateSortie + '}';
    }
    
    
}
