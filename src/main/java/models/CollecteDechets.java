package models;

import java.sql.Date;
import java.sql.Timestamp;

public class CollecteDechets {
	private int id;
    private String latitude;
    private String longitude;
    private Timestamp heurePrevue;
    private String statut;
    private Adresse adresse;

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public Timestamp getHeurePrevue() {
        return heurePrevue;
    }

    public void setHeurePrevue(Timestamp heurePrevue) {
        this.heurePrevue = heurePrevue;
    }
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public CollecteDechets(String latitude, String longitude, Timestamp heurePrevue, String statut) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.heurePrevue = heurePrevue;
		this.statut = statut;
	}
	public CollecteDechets() {
			}
	
    
    
}
