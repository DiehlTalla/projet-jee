package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoParent implements Serializable {

	
	private int id;
	private String nom;
	private String prenom;
	private String adressePostale;
	private String email;
	private String telephone;
	
	
	public DtoParent() {
	}


	public DtoParent(int id, String nom, String prenom, String adressePostale, String email, String telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adressePostale = adressePostale;
		this.email = email;
		this.telephone = telephone;
	}


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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdressePostale() {
		return adressePostale;
	}


	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	
	
	
}
