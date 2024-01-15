package models;

public class PlaceTouristique {
    private int id;
    private String nom;
    private String description;
    private String ville;
    private String image;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public PlaceTouristique(String nom, String description, String ville, String image) {
		this.nom = nom;
		this.description = description;
		this.ville = ville;
		this.image = image;
	}
	public PlaceTouristique() {
	}
	

    
}