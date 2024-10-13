package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoParent;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceParent;
import projet.jsf.data.Parent;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelParent implements Serializable {
	
	
	private List<Parent> liste;
	private List<Parent> listeAvecNull;
	private Parent courant;
	
	@EJB
	private IServiceParent serviceParent;
	
	@Inject
	private IMapper mapper;

	public List<Parent> getListe() {
		if (liste == null) {
			liste = new ArrayList<>();
			for (DtoParent dto : serviceParent.listerTout()) {
				liste.add(mapper.map(dto));
			}
		}
		return liste;
	}
	
	public List<Parent> getListeAvecNull() {
		if ( listeAvecNull == null ) {
			listeAvecNull = new ArrayList<>();
			listeAvecNull.add( null );
			listeAvecNull.addAll(getListe());
		}
		return listeAvecNull;
	}


	public Parent getCourant() {
		if (courant == null) {
			courant = new Parent();
		}
		return courant;
	}
	
	
	public String actualiserCourant() {
		if (courant != null) {
			DtoParent dto = serviceParent.retrouver(courant.getId());
			if (dto == null) {
				UtilJsf.messageError("Le parent demandé n'existe pas");
				return "test/liste";
			}else {
				courant = mapper.map(dto);
			}
		}
		return null;
	}
	
	
	public String validerMiseAJour() {
		try {
			if (courant.getId() == null) {
				serviceParent.inserer(mapper.map(courant));
			}else {
				serviceParent.modifier(mapper.map(courant));
			}
			UtilJsf.messageError("Mise à jour effectuée avec succès");
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer(Parent item) {
		try {
			serviceParent.supprimer(item.getId());
			liste.remove(item);
			UtilJsf.messageError("Suppression effectuée avec succès");
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
		}
		return null;
	}
	
	

}
