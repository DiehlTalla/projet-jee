package projet.jsf.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@SuppressWarnings("serial")
public class Tarif implements Serializable {
	
	private Integer id;
	
	@NotNull(message = "Le tarif horaire doit être renseigné")
	@PositiveOrZero(message = "Le tarif doit être positif ou nul")
	private BigDecimal tarifHoraire;
	
	@NotNull(message = "Le minimum journalier doit être renseigné")
	@PositiveOrZero(message = "Ce champ doit être positif ou nul")
	private BigDecimal minimumJournalier;
	
	@Max(value = 5, message = "L'indemnité repas doit être entre 1€ et 5€")
	@Min(value = 1, message = "L'indemnité repas doit être entre 1€ et 5€")
	@NotNull(message = "L'indemnité de repas doit être renseigné")
	@PositiveOrZero(message = "Ce champ doit être positif ou nul")
	private BigDecimal indemniteRepas;
	
	@NotNull(message = "L'indemnité de repas doit être renseigné")
	@PositiveOrZero(message = "Ce champ doit être positif ou nul")
	private BigDecimal tauxHoraire;
	
	public Tarif() {
	}
	
	

	public Tarif(Integer id, BigDecimal tarifHoraire, BigDecimal minimumJournalier, BigDecimal indemniteRepas, BigDecimal tauxHoraire) {
		this.id = id;
		this.tarifHoraire = tarifHoraire;
		this.minimumJournalier = minimumJournalier;
		this.indemniteRepas = indemniteRepas;
		this.tauxHoraire = tauxHoraire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTarifHoraire() {
		return tarifHoraire;
	}

	public void setTarifHoraire(BigDecimal tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}

	public BigDecimal getMinimumJournalier() {
		return minimumJournalier;
	}

	public void setMinimumJournalier(BigDecimal minimumJournalier) {
		this.minimumJournalier = minimumJournalier;
	}

	public BigDecimal getIndemniteRepas() {
		return indemniteRepas;
	}

	public void setIndemniteRepas(BigDecimal indemniteRepas) {
		this.indemniteRepas = indemniteRepas;
	}



	public BigDecimal getTauxHoraire() {
		return tauxHoraire;
	}



	public void setTauxHoraire(BigDecimal tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}

	
	
	
	
}
