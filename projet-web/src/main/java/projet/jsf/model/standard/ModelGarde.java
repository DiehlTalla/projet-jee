package projet.jsf.model.standard;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
	
	private List<Integer> listeR;
	
	private Garde courant;
	
	@Inject
	private CompteActif compteActif;
	
	private List<Garde> listeP;
	
//	private double dureeEnHeures =0.0;
	
	@EJB
	private IServiceGarde serviceGarde;

	@Inject
	private IMapper mapper;
	
	
	
	public List<Integer> getListeR(){
		if(listeR == null) {
			listeR = new ArrayList<>();
			for(Integer i = 0; i <= 1; i++) {
				listeR.add(i);
			}
		}
		return listeR;
	}

	public List<Garde> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			if (compteActif.isAdmin()) {
				for (DtoGarde dto : serviceGarde.listerTout()) {
					liste.add(mapper.map(dto));
				}
			}else {
				for (DtoGarde dto : serviceGarde.listerParCompte(compteActif.getId())) {
					liste.add(mapper.map(dto));
				}
			}
		}
		return liste;
	}
	
	
	public List<Garde> getListeP() {
		if (listeP == null) {
			listeP = new ArrayList<>();
			String contratId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

			for (DtoGarde dto : serviceGarde.listerParContrat(Integer.valueOf(contratId))) {
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
//			if (listeP == null) {
//				listeP = new ArrayList<>();
//				for (DtoGarde dtoG : serviceGarde.listerParContrat(courant.getContrat().getId())) {
//					listeP.add(mapper.map(dto));
//				}
//			}
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
	
	
	public double calculDuree(LocalTime heureArrivee, LocalTime heureDepart) {
        Duration dur = Duration.between(heureArrivee, heureDepart);
        long totalMinutes = dur.toMinutes();
//        long minutes = dur.toMinutes() % 60;
        double dureeEnHeures = totalMinutes / 60.0;
        return dureeEnHeures;
	}
	
	public double calculRevenu(double duree, BigDecimal tarif, BigDecimal taux, BigDecimal indemnite, BigDecimal repas, int nbrepas) {
		double revenu = tarif.doubleValue()*duree;
		revenu = revenu + taux.doubleValue()*duree; 
		revenu = revenu + indemnite.doubleValue(); 
		revenu = repas.doubleValue()*nbrepas + revenu;
		return revenu;
	}
}
