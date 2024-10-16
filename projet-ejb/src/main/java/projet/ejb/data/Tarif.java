package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarif")
public class Tarif {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idtarif")
	private int id;
	
	@Column(name = "tarifhoraire")
	private BigDecimal tarifHoraire;
	
	@Column(name = "minimumjournalier")
	private BigDecimal minimumJournalier;
	
	@Column(name = "indemniteRepas")
	private BigDecimal indemniteRepas;
	
	
	
	public Tarif() {
	}
	
	

	public Tarif(int id, BigDecimal tarifHoraire, BigDecimal minimumJournalier, BigDecimal indemniteRepas) {
		this.id = id;
		this.tarifHoraire = tarifHoraire;
		this.minimumJournalier = minimumJournalier;
		this.indemniteRepas = indemniteRepas;
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
		Tarif other = (Tarif) obj;
		return id == other.id;
	}
	
	
	
	

}
