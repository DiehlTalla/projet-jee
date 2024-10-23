package projet.ejb.data;

import java.time.LocalTime;
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
@Table(name = "garde")
public class Garde {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgarde")
	private int id;
	@ManyToOne
	@JoinColumn(name = "idcontrat")
	private Contrat contrat;

	@Column(name = "dategarde")
	private Date date;
	@Column(name = "heureArrivee")
	private LocalTime heureArrivee;
	@Column(name = "heureDepart")
	private LocalTime heureDepart;
	@Column(name = "repas")
	private int repas;

	public Garde() {

	}

	public Garde(int id, Contrat contrat, Date date, LocalTime heureArrivee, LocalTime heureDepart, int repas) {
		super();
		this.id = id;
		this.contrat = contrat;
		this.date = date;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.repas = repas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(LocalTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
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
		Garde other = (Garde) obj;
		return id == other.id;
	}

}
