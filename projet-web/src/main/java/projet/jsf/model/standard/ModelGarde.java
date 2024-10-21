package projet.jsf.model.standard;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoContrat;
import projet.commun.dto.DtoGarde;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceGarde;
import projet.jsf.data.Garde;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelGarde implements Serializable {

	private List<Garde> liste;
	private Garde courant;
	
	@Inject
	private CompteActif compteActif;
	
	private List<Garde> listeP;
	
	private long duree;
	
	@EJB
	private IServiceGarde serviceGarde;

	@Inject
	private IMapper mapper;

	public List<Garde> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			if (compteActif.isAdmin()) {
				for (DtoGarde dto : serviceGarde.listerTout()) {
					liste.add(mapper.map(dto));
				}
			}else {
				for (DtoContrat dto : serviceGarde.listerParCompte(compteActif.getId())) {
					liste.add(mapper.map(dto));
				}
			}
		}
		return liste;
	}
	
	
	public List<Garde> getListeP() {
		if (listeP == null) {
			listeP = new ArrayList<>();
			for (DtoGarde dto : serviceGarde.listerParContrat(courant.getContrat().getId())) {
				listeP.add(mapper.map(dto));
			}
		}
		return listeP;
	}
	

	public Garde getCourant() {
		if (courant == null) {
			courant = new Garde();
		}
		return courant;
	}

	public String actualiserCourant() {
		if (courant != null) {
			DtoGarde dto = serviceGarde.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("Le garde demandé n'existe pas");
				return "test/liste";
			} else {
				courant = mapper.map(dto);
			}
		}
		return null;
	}

	public String validerMiseAJour() {

		try {
			if (courant.getId() == null) {
				serviceGarde.inserer(mapper.map(courant));
			} else {
				serviceGarde.modifier(mapper.map(courant));
			}
			UtilJsf.messageError("Mise à jour effectuée avec succès");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}

	public String supprimer(Garde item) {
		try {
			serviceGarde.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageError("Suppression effectuée avec succès");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}
	
	
	public long calculDuree() {
        Duration dur = Duration.between(courant.getHeureArrivee(), courant.getHeureDepart());
        long hours = dur.toHours();
        long minutes = dur.toMinutes() % 60;
        duree = hours+minutes;
        return duree;
	}
	

}
