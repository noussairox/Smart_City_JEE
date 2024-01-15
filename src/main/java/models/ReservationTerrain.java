package models;

import java.sql.Timestamp;

public class ReservationTerrain {
    private int id;
    private int idTerrain;
    private String nomTerrain;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private String nomReservant;
    private String numeroTel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTerrain() {
		return idTerrain;
	}
	public void setIdTerrain(int idTerrain) {
		this.idTerrain = idTerrain;
	}
	public String getNomTerrain() {
		return nomTerrain;
	}
	public void setNomTerrain(String nomTerrain) {
		this.nomTerrain = nomTerrain;
	}
	public Timestamp getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Timestamp getDateFin() {
		return dateFin;
	}
	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}
	public String getNomReservant() {
		return nomReservant;
	}
	public void setNomReservant(String nomReservant) {
		this.nomReservant = nomReservant;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public ReservationTerrain(int idTerrain, String nomTerrain, Timestamp dateDebut, Timestamp dateFin,
			String nomReservant, String numeroTel) {
		super();
		this.idTerrain = idTerrain;
		this.nomTerrain = nomTerrain;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nomReservant = nomReservant;
		this.numeroTel = numeroTel;
	}
	public ReservationTerrain() {
	}


}