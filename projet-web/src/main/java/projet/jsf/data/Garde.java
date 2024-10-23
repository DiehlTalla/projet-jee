package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class Garde implements Serializable {

	private Integer id;

	@NotNull(message = "Le contrat doit être renseigné ")
	private Contrat contrat;
	@NotNull(message = "La date  doit être renseignée")
	private Date date;
	@NotNull(message = "L'heure doit être renseignée")

	@NotNull(message = "L'heure doit être renseignée")
	private LocalTime heureArrivee;
	@NotNull(message = "L'heure doit être renseignée")
	private LocalTime heureDepart;

	private int repas;

	public Garde() {

	}

	public Garde(Integer id, @NotNull(message = "Le contrat doit être renseigné ") Contrat contrat,
			@NotNull(message = "La date  doit être renseignée") Date date,
			@NotNull(message = "L'heure doit être renseignée") LocalTime heureArrivee,
			@NotNull(message = "L'heure doit être renseignée") LocalTime heureDepart, int repas) {
		super();
		this.id = id;
		this.contrat = contrat;
		this.date = date;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.repas = repas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return Objects.equals(id, other.id);
	}

}
