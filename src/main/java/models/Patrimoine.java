package models;

import java.sql.Timestamp;

public class Patrimoine {
    private int id;
    private String nomPatrimoine;
    private String description;
    private String imagePatrimoine;
    private String prixEstime ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomPatrimoine() {
		return nomPatrimoine;
	}
	public void setNomPatrimoine(String nomPatrimoine) {
		this.nomPatrimoine = nomPatrimoine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePatrimoine() {
		return imagePatrimoine;
	}
	public void setImagePatrimoine(String imagePatrimoine) {
		this.imagePatrimoine = imagePatrimoine;
	}
	public String getPrixEstime() {
		return prixEstime;
	}
	public void setPrixEstime(String prixEstime) {
		this.prixEstime = prixEstime;
	}
	public Patrimoine(String nomPatrimoine, String description, String imagePatrimoine, String prixEstime) {
		super();
		this.nomPatrimoine = nomPatrimoine;
		this.description = description;
		this.imagePatrimoine = imagePatrimoine;
		this.prixEstime = prixEstime;
	}
	public Patrimoine() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}
