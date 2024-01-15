package models;

public class Terrain {
    private int id;
    private String nom;
    private String description;
    private String imageTerrain;
    private boolean disponibilite;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageTerrain() {
		return imageTerrain;
	}
	public void setImageTerrain(String imageTerrain) {
		this.imageTerrain = imageTerrain;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	public Terrain(String nom, String description, String imageTerrain, boolean disponibilite) {
		super();
		this.nom = nom;
		this.description = description;
		this.imageTerrain = imageTerrain;
		this.disponibilite = disponibilite;
	}
	public Terrain() {
	}


}
