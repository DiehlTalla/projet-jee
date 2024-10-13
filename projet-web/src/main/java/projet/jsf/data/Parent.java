package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Parent implements Serializable {

	
	private Integer id;
	
	@NotNull(message = "Le compte doit être renseigné")
	private Compte compte;
	
	@NotBlank(message = "Le nom doit être rendeigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car maxi")
	private String nom;

	@NotBlank(message = "Le prénom doit être rendeigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car maxi")
	private String prenom;

	@NotBlank(message = "L'adresse postale doit être renseignée")
	private String adressePostale;

	@NotBlank(message = "L'email doit être renseigné")
	@Email(message = "Le format de l'email est incorrect")
	private String email;
	
	@NotBlank(message = "Le téléphone doit être renseigné")
	private String telephone;

	public Parent() {
	}

	

	public Parent(Integer id, Compte compte, String nom, String prenom, String adressePostale, String email,
			String telephone) {

		this.id = id;
		this.compte = compte;
		this.nom = nom;
		this.prenom = prenom;
		this.adressePostale = adressePostale;
		this.email = email;
		this.telephone = telephone;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
