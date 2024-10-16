package projet.ejb.data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idparent")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idcompte")
	private Compte compte;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "adresse_postale")
	private String adressePostale;

	public Parent() {
	}

	

	public Parent(int id, Compte compte, String nom, String prenom, String email,
			String telephone, String adressePostale) {

		this.id = id;
		this.compte = compte;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adressePostale = adressePostale;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
	
	

	public String getAdressePostale() {
		return adressePostale;
	}



	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
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
		Parent other = (Parent) obj;
		return id == other.id;
	}


	

	

}
