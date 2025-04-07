package eu.ase.lab6;

import java.io.Serializable;

public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2844395316699011142L;
	private int birthYear;
	private String name;
	private String country;
	public Author(int birthYear, String name, String country) {
		super();
		this.birthYear = birthYear;
		this.name = name;
		this.country = country;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Author [birthYear=" + birthYear + ", name=" + name + ", country=" + country + "]";
	}	
	
}
