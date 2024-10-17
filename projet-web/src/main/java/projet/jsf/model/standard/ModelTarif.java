package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoGarde;
import projet.commun.dto.DtoTarif;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceTarif;
import projet.jsf.data.Tarif;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelTarif implements Serializable {
	
	private List<Tarif> liste;
	private Tarif courant;
	
	@EJB
	private IServiceTarif serviceTarif;
	
	@Inject
	private IMapper mapper;
	
	
	public List<Tarif> getListe(){
		if(liste == null) {
			liste = new ArrayList<>();
			for (DtoTarif dto : serviceTarif.listerTout()) {
				liste.add(mapper.map(dto));
			}
		}
		return liste;
	}
	
	
	public Tarif getCourant() {
		if (courant == null) {
			courant = new Tarif();
		}
		return courant;
	}
	
	
	public String actualiserCourant() {
		if (courant != null) {
			DtoTarif dto = serviceTarif.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("Le tarif demandé n'existe pas");
				return "test/list";
			}else {
				courant = mapper.map(dto);
			}
		}
		return null;
	}
	
	
	public String validerMiseAJour() {
		try {
			if (courant.getId() == null) {
				serviceTarif.inserer(mapper.map(courant));
			}else {
				serviceTarif.modifier(mapper.map(courant));
			}
			UtilJsf.messageError("Mise à jour effectuée avec succès");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	
	public String supprimer(Tarif item) {
		try {
			serviceTarif.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageError("Suppression effectuée avec succès");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}

}
