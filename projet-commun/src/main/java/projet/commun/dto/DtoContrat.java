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
	private double tarifHoraire;
	private double entretien;
	private double tauxHoraire;
	private double indemniteRepas;
	private DtoParent parent;
	
	
	public DtoContrat() {
		
	}
	
	
	public DtoContrat(int id, String nom, String prenom, Date dateNaissance, Date debut, Date fin, double tarifHoraire,
			double entretien, double tauxHoraire,double indemniteRepas, DtoParent parent) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.debut = debut;
		this.fin = fin;
		this.tarifHoraire = tarifHoraire;
		this.entretien = entretien;
		this.tauxHoraire = tauxHoraire;
		this.indemniteRepas = indemniteRepas;
		this.parent = parent;
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


	public double getTarifHoraire() {
		return tarifHoraire;
	}


	public void setTarifHoraire(double tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}


	public double getEntretien() {
		return entretien;
	}


	public void setEntretien(double entretien) {
		this.entretien = entretien;
	}
	
	
	
	public double getTauxHoraire() {
		return tauxHoraire;
	}


	public void setTauxHoraire(double tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}


	public double getIndemniteRepas() {
		return indemniteRepas;
	}


	public void setIndemniteRepas(double indemniteRepas) {
		this.indemniteRepas = indemniteRepas;
	}


	public DtoParent getParent() {
		return parent;
	}


	public void setParent(DtoParent parent) {
		this.parent = parent;
	}
	
}
