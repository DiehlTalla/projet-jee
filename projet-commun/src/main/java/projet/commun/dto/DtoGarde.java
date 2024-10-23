package projet.commun.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoGarde implements Serializable {
	private int id;
	private DtoContrat contrat;
	private Date date;
	private LocalTime heureArrivee;
	private LocalTime heureDepart;
	private int repas;

	public DtoGarde() {

	}

	public DtoGarde(int id, DtoContrat contrat, Date date, LocalTime heureArrivee, LocalTime heureDepart,
			int repas) {
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

	public DtoContrat getContrat() {
		return contrat;
	}

	public void setContrat(DtoContrat contrat) {
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

}
