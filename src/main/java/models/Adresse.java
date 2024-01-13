package models;

public class Adresse {
    private String amenity;
    private String road;
    private String suburb;
    private String city;
    private String county;
    private String stateDistrict;
    private String iso3166Lvl5;
    private String region;
    private String iso3166Lvl4;
    private String postcode;
    private String country;
    private String countryCode;
	@Override
	public String toString() {
		return "Adresse [amenity=" + amenity + ", road=" + road + ", suburb=" + suburb + ", city=" + city + ", county="
				+ county + ", stateDistrict=" + stateDistrict + ", iso3166Lvl5=" + iso3166Lvl5 + ", region=" + region
				+ ", iso3166Lvl4=" + iso3166Lvl4 + ", postcode=" + postcode + ", country=" + country + ", countryCode="
				+ countryCode + "]";
	}
	public String getAmenity() {
		return amenity;
	}
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getStateDistrict() {
		return stateDistrict;
	}
	public void setStateDistrict(String stateDistrict) {
		this.stateDistrict = stateDistrict;
	}
	public String getIso3166Lvl5() {
		return iso3166Lvl5;
	}
	public void setIso3166Lvl5(String iso3166Lvl5) {
		this.iso3166Lvl5 = iso3166Lvl5;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getIso3166Lvl4() {
		return iso3166Lvl4;
	}
	public void setIso3166Lvl4(String iso3166Lvl4) {
		this.iso3166Lvl4 = iso3166Lvl4;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

    // Les getters et setters vont ici...


    
}
