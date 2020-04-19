package entities;

import java.util.Date;

public class Consultation {
	
	private int id;
	private int idPraticien;
	private int idPatient;
        private int idPathologie;
	private Date dateDeCreation;
	
	public Consultation() {
		super();
	}

	public Consultation(int idConsultation, int idPraticien) {
		super();
		this.id = id;
		this.idPraticien = idPraticien;
	}

	public Consultation(int id, int idPraticien, int idPatient,int idPathologie, Date dateDeCreation) {
		super();
		this.id = id;
		this.idPraticien = idPraticien;
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

	public int getIdPraticien() {
		return idPraticien;
	}

	public void setIdPraticien(int idPraticien) {
		this.idPraticien = idPraticien;
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
        

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

    @Override
    public String toString() {
        return "Consultation{" + "id=" + id + ", idPraticien=" + idPraticien + 
                ", idPatient=" + idPatient + ", idPathologie=" + idPathologie + ", dateDeCreation=" + dateDeCreation + '}';
    }

	
	
	

}
