package entities;

import java.time.LocalDate;
import java.util.Date;

public class Consultation {
	
	private int id;
	private int idMedecin;
	private int idPatient;
        private int idPathologie;
	private LocalDate dateDeCreation;
	
	public Consultation() {
		super();
	}

	public Consultation(int id, int idMedecin) {
		super();
		this.id = id;
		this.idMedecin = idMedecin;
	}

	public Consultation(int id, int idMedecin, int idPatient,int idPathologie, LocalDate dateDeCreation) {
		super();
		this.id = id;
		this.idMedecin = idMedecin;
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

	public int getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}

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
        return "Consultation{" + "id=" + id + ", idMedecin=" + idMedecin + 
                ", idPatient=" + idPatient + ", idPathologie=" + idPathologie + ", dateDeCreation=" + dateDeCreation + '}';
    }

	
	
	

}
