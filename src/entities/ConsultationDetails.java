package entities;

import java.time.LocalDate;

public class ConsultationDetails {
    
    private long nss;
    private String nom;
    private String nomPathologie;
    private LocalDate dateDeCreation;

    public ConsultationDetails() {
    }

    public ConsultationDetails(long nss, String nom, String nomPathologie, LocalDate dateDeCreation) {
        this.nss = nss;
        this.nom = nom;
        this.nomPathologie = nomPathologie;
        this.dateDeCreation = dateDeCreation;
    }

    public long getNss() {
        return nss;
    }

    public String getNom() {
        return nom;
    }

    public void setNss(long nss) {
        this.nss = nss;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNomPathologie(String nomPathologie) {
        this.nomPathologie = nomPathologie;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getNomPathologie() {
        return nomPathologie;
    }

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }

    @Override
    public String toString() {
        return "ConsultationDetails{" + "nss=" + nss + ", nom=" + nom + ", nomPathologie=" + nomPathologie + ", dateDeCreation=" + dateDeCreation + '}';
    }
    
    
}
