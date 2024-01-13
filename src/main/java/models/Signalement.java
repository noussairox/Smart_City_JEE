package models;

public class Signalement {
    private int Id;
    private String description;
    private double latitude;
    private double longitude;
    private String localisation;
    private String typeReclamation;
    private String photoPath;  
    
    

    public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public String getLocalisation() {
		return localisation;
	}



	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}



	public String getTypeReclamation() {
		return typeReclamation;
	}



	public void setTypeReclamation(String typeReclamation) {
		this.typeReclamation = typeReclamation;
	}



	public String getPhotoPath() {
		return photoPath;
	}



	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}



	// Exemple de méthode pour afficher la localisation complète
    public String getLocalisationComplete() {
        return latitude + ", " + longitude + " - " + localisation;
    }
}
