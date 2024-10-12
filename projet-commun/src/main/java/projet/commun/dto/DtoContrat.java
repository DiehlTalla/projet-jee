package projet.commun.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

@SuppressWarnings("serial")
public class DtoContrat implements Serializable {

	
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Date debut;
	private Date fin;
	private int tarifHoraire;
	private int entretien;
	
	
	public DtoContrat() {
		
	}
	
	
	public DtoContrat(int id, String nom, String prenom, Date dateNaissance, Date debut, Date fin, int tarifHoraire,
			int entretien) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.debut = debut;
		this.fin = fin;
		this.tarifHoraire = tarifHoraire;
		this.entretien = entretien;
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


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Date getDebut() {
		return debut;
	}


	public void setDebut(Date debut) {
		this.debut = debut;
	}


	public Date getFin() {
		return fin;
	}


	public void setFin(Date fin) {
		this.fin = fin;
	}


	public int getTarifHoraire() {
		return tarifHoraire;
	}


	public void setTarifHoraire(int tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}


	public int getEntretien() {
		return entretien;
	}


	public void setEntretien(int entretien) {
		this.entretien = entretien;
	}
	
	
	
	
}
