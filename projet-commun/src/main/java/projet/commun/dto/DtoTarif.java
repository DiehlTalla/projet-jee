package projet.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoTarif implements Serializable {
	
	private int id;
	private BigDecimal tarifHoraire;
	private BigDecimal minimumJournalier;
	private BigDecimal indemniteRepas;
	private BigDecimal tauxHoraire;
	
	
	public DtoTarif() {
	}
	
	
	public DtoTarif(int id, BigDecimal tarifHoraire, BigDecimal minimumJournalier, BigDecimal indemniteRepas, BigDecimal tauxHoraire) {
		this.id = id;
		this.tarifHoraire = tarifHoraire;
		this.minimumJournalier = minimumJournalier;
		this.indemniteRepas = indemniteRepas;
		this.tauxHoraire = tauxHoraire;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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
