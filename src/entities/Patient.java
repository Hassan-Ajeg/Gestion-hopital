package entities;

import java.time.LocalDate;
import java.util.*;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private Long nss;
    private LocalDate dateDeCreation;

    public Patient() {
        super();
    }

    public Patient(String nom, String prenom, Long nss, LocalDate dateDeCreation) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.nss = nss;
    }

    public Patient(int id, String nom, String prenom, Long nss, LocalDate dateDeCreation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nss = nss;
        this.dateDeCreation = dateDeCreation;
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

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getNss() {
        return nss;
    }

    public void setNss(Long nss) {
        this.nss = nss;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nss=" + nss + ", dateDeCreation=" + dateDeCreation + '}';
    }

}
