package projet.ejb.data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrat")
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcontrat")
	private int id;

	@ManyToOne
	@JoinColumn(name = "idparent")
	private Parent parent;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "datenaissance")
	private Date dateNaissance;
	
	@Column(name = "debut")
	private Date debut;
	
	@Column(name = "fin")
	private Date fin;
	
	@Column(name = "tarifhoraire")
	private BigDecimal tarifHoraire;
	
	@Column(name = "tauxhoraire")
	private BigDecimal tauxHoraire;
	
	@Column(name = "indemniteentretient")
	private BigDecimal entretien;
	
	@Column(name = "indemniterepas")
	private BigDecimal indemniteRepas;

	
	public Contrat() {

	}

	public Contrat(int id, Parent parent, String nom, String prenom, Date dateNaissance, Date debut, Date fin,
			BigDecimal tarifHoraire, BigDecimal tauxHoraire, BigDecimal entretien, BigDecimal indemniteRepas) {

		this.id = id;
		this.parent = parent;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.debut = debut;
		this.fin = fin;
		this.tarifHoraire = tarifHoraire;
		this.tauxHoraire = tauxHoraire;
		this.entretien = entretien;
		this.indemniteRepas = indemniteRepas;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
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

	public BigDecimal getTarifHoraire() {
		return tarifHoraire;
	}

	public void setTarifHoraire(BigDecimal tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}

	public BigDecimal getTauxHoraire() {
		return tauxHoraire;
	}

	public void setTauxHoraire(BigDecimal tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}

	public BigDecimal getEntretien() {
		return entretien;
	}

	public void setEntretien(BigDecimal entretien) {
		this.entretien = entretien;
	}

	public BigDecimal getIndemniteRepas() {
		return indemniteRepas;
	}

	public void setIndemniteRepas(BigDecimal indemniteRepas) {
		this.indemniteRepas = indemniteRepas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrat other = (Contrat) obj;
		return id == other.id;
	}

	

	
	
	
}
