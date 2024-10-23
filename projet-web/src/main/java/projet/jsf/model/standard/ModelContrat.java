package projet.jsf.model.standard;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoContrat;
import projet.commun.dto.DtoGarde;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceContrat;
import projet.commun.service.IServiceGarde;
import projet.jsf.data.Compte;
import projet.jsf.data.Contrat;
import projet.jsf.data.Garde;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelContrat implements Serializable {
	
	
	private List<Contrat> liste;
	private Contrat courant;
	
	@Inject
	private CompteActif compteActif;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private IServiceGarde serviceGarde;
	
	private List<Contrat> listeP;
	
	@EJB
	private IServiceContrat serviceContrat;
	
	@Inject
	private IMapper mapper;
	

	public List<Contrat> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			if (compteActif.isAdmin()) {
				for (DtoContrat dto : serviceContrat.listerTout()) {
					liste.add(mapper.map(dto));
				}
			}else {
				for (DtoContrat dto : serviceContrat.listerParCompte(compteActif.getId())) {
					liste.add(mapper.map(dto));
				}
			}
		}
		return liste;
	}
	
	
	
	public List<Contrat> getListeP() {
		if (listeP == null) {
			listeP = new ArrayList<>();
		String parentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

			for (DtoContrat dto : serviceContrat.listerParParent(Integer.valueOf(parentId))) {
				listeP.add(mapper.map(dto));
			}
		}
		return listeP;
	}
	

	public Contrat getCourant() {
		if (courant == null) {
			courant = new Contrat();
		}
		return courant;
	}

	
	public String actualiserCourant() {
		if (courant != null) {
			serviceGarde.listerParContrat(courant.getId());
			DtoContrat dto = serviceContrat.retrouver(courant.getId());
//			serviceContrat.listerParParent(courant.getParent().getId());
			if (dto == null) {
				UtilJsf.messageError("Le contrat demandé n'existe pas");
				return "test/liste";
			}else {
				courant = mapper.map(dto);
			}
		}
		return null;
	}
	
	
	public String validerMiseAJour() {
		comparerDates();
		try {
			if (courant.getId() == null) {
				serviceContrat.inserer(mapper.map(courant));
			}else {
				
				serviceContrat.modifier(mapper.map(courant));
			}
			UtilJsf.messageError("Mise à jour effectuée avec succès");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	
	
	public String supprimer(Contrat item) {
		try {
			serviceContrat.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageError("Suppression effectuée avec succès");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}
	
	
	public void comparerDates() {
        if (getCourant().getDebut() != null && getCourant().getFin() != null) {
            if (getCourant().getDebut().after(getCourant().getFin())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "La date de début ne peut pas être postérieure à la date de fin."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Les dates sont valides."));
            }
        }
    }
	
	
	public double totalAPayer(List<Garde> gardes,BigDecimal tarif, BigDecimal taux, BigDecimal indemnite, BigDecimal repas) {
		List<Double> montants = new ArrayList<>();
		for (Garde garde : gardes) {
			Duration dur = Duration.between(garde.getHeureArrivee(), garde.getHeureDepart());
	        long totalMinutes = dur.toMinutes();
//	        long minutes = dur.toMinutes() % 60;
	        double duree = totalMinutes / 60.0;
	        double revenu = tarif.doubleValue()*duree;
			revenu = revenu + taux.doubleValue()*duree; 
			revenu = revenu + indemnite.doubleValue(); 
			revenu = revenu + repas.doubleValue();
			montants.add(revenu);
		}
		double somme = 0.0;
        for (Double valeur : montants) {
            somme += valeur;
        }
//		double somme = gardes.stream().mapToDouble(Double::doubleValue).sum();
        return somme;
	}

}
