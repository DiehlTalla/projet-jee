package projet.ejb.data;

import static javax.persistence.CascadeType.ALL;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "contrat")
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@Column(name = "idparent")
	private Parent parent;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "dateNaissance")
	private Date dateNaissance;
	@Column(name = "debut")
	private Date debut;
	@Column(name = "fin")
	private Date fin;
	@Column(name = "tarif")
	private BigDecimal tarif;
	@Column(name = "taux")
	private BigDecimal taux;
	@Column(name = "montantEntretient")
	private int montantEntretient;
	@Column(name = "repas")
	private int repas;

	
	public Contrat() {

	}

	public Contrat(int id, Parent parent, String nom, String prenom, Date dateNaissance, Date debut, Date fin,
			BigDecimal tarif, BigDecimal taux, int montantEntretient, int repas) {

		this.id = id;
		this.parent = parent;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.debut = debut;
		this.fin = fin;
		this.tarif = tarif;
		this.taux = taux;
		this.montantEntretient = montantEntretient;
		this.repas = repas;
		
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

	public BigDecimal getTarif() {
		return tarif;
	}

	public void setTarif(BigDecimal tarif) {
		this.tarif = tarif;
	}

	public BigDecimal getTaux() {
		return taux;
	}

	public void setTaux(BigDecimal taux) {
		this.taux = taux;
	}

	public int getMontantEntretient() {
		return montantEntretient;
	}

	public void setMontantEntretient(int montantEntretient) {
		this.montantEntretient = montantEntretient;
	}

	public int getRepas() {
		return repas;
	}

	public void setRepas(int repas) {
		this.repas = repas;
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
