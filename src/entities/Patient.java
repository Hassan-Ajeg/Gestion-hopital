package entities;

import java.util.*;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private int nss;
    private Date dateDeCreation;

    public Patient() {
        super();
    }

    public Patient(String nom, String prenom, int nss, Date dateDeCreation) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.nss = nss;
    }

    public Patient(int id, String nom, String prenom, int nss, Date dateDeCreation) {
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

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nss=" + nss + ", dateDeCreation=" + dateDeCreation + '}';
    }

}
