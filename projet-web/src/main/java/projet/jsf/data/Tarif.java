package projet.jsf.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@SuppressWarnings("serial")
public class Tarif implements Serializable {
	
	private Integer id;
	
	@NotBlank(message = "Le tarif horaire doit être renseigné")
	@PositiveOrZero(message = "Le tarif doit être positif ou nul")
	private BigDecimal tarifHoraire;
	
	@NotBlank(message = "Le minimum journalier doit être renseigné")
	@PositiveOrZero(message = "Ce champ doit être positif ou nul")
	private BigDecimal minimumJournalier;
	
	@NotBlank(message = "L'indemnité de repas doit être renseigné")
	@PositiveOrZero(message = "Ce champ doit être positif ou nul")
	private BigDecimal indemniteRepas;
	
	
	public Tarif() {
	}
	
	

	public Tarif(Integer id, BigDecimal tarifHoraire, BigDecimal minimumJournalier, BigDecimal indemniteRepas) {
		this.id = id;
		this.tarifHoraire = tarifHoraire;
		this.minimumJournalier = minimumJournalier;
		this.indemniteRepas = indemniteRepas;
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

	
	
	
	
}
