package projet.jsf.data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Contrat implements Serializable {

	private Integer id;

	@NotNull(message = "Le parent doit être renseigné")
	private Parent parent;
	
	@NotBlank(message = "Le nom doit être rendeigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car maxi")
	private String nom;
	
	@NotBlank(message = "Le prénom doit être rendeigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car maxi")
	private String prenom;
	
	@NotNull(message = "La date de naissance doit être renseignée")
	private Date dateNaissance;
	
	@NotNull(message = "La date de début du contrat doit être renseignée")
	private Date debut;
	
	@NotNull(message = "La date de fin du contrat doit être renseignée")
	private Date fin;
	
	@NotNull(message = "Le tarif horaire doit être renseigné")
	@PositiveOrZero(message = "Le tarif horaire doit être positif et supérieur à zéro")
	private BigDecimal tarifHoraire;
	
	@NotNull(message = "Le taux horaire doit être renseigné")
	@PositiveOrZero(message = "Le taux doit être positif et supérieur à zéro")
	private BigDecimal tauxHoraire;
	
	@NotNull(message = "L'indemnité d'entretien doit être renseigné")
	@PositiveOrZero(message = "L'indemnité d'entretien doit être positif et supérieur à zéro")
	private BigDecimal indemniteEntretient;
	
	@NotNull(message = "L'indemnité de repas doit être renseigné")
	@PositiveOrZero(message = "L'indemnité de repas doit être positif et supérieur à zéro")
	private BigDecimal indemniteRepas;

	
	public Contrat() {

	}

	public Contrat(Integer id, Parent parent, String nom, String prenom, Date dateNaissance, Date debut, Date fin,
			BigDecimal tarifHoraire, BigDecimal tauxHoraire, BigDecimal indemniteEntretient, BigDecimal indemniteRepas) {

		this.id = id;
		this.parent = parent;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.debut = debut;
		this.fin = fin;
		this.tarifHoraire = tarifHoraire;
		this.tauxHoraire = tauxHoraire;
		this.indemniteEntretient = indemniteEntretient;
		this.indemniteRepas = indemniteRepas;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public BigDecimal getIndemniteEntretient() {
		return indemniteEntretient;
	}

	public void setIndemniteEntretient(BigDecimal indemniteEntretient) {
		this.indemniteEntretient = indemniteEntretient;
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
