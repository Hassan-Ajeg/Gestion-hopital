package entities;

import java.time.LocalDate;
import java.util.Date;

public class Consultation {
	
	private int id;
	//private int idUtilisateur;
	private int idPatient;
        private int idPathologie;
	private LocalDate dateDeCreation;
	
	public Consultation() {
		super();
	}

	public Consultation(int id) {
		super();
		this.id = id;
		//this.idUtilisateur = idUtilisateur;
	}

	public Consultation(int id, int idPatient,int idPathologie, LocalDate dateDeCreation) {
		super();
		this.id = id;
		//this.idUtilisateur = idUtilisateur;
		this.idPatient = idPatient;
                this.idPathologie = idPathologie;
		this.dateDeCreation = dateDeCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}*/

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

    public int getIdPathologie() {
        return idPathologie;
    }

    public void setIdPathologie(int idPathologie) {
        this.idPathologie = idPathologie;
    }
        

	public LocalDate getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(LocalDate dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

    @Override
    public String toString() {
        return "Consultation{" + "id=" + id  + 
                ", idPatient=" + idPatient + ", idPathologie=" + idPathologie + ", dateDeCreation=" + dateDeCreation + '}';
    }

	
	
	

}
