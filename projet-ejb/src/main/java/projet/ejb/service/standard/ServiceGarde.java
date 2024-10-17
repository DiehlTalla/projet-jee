package projet.ejb.service.standard;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoGarde;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceGarde;
import projet.ejb.dao.IDaoGarde;
import projet.ejb.data.Garde;
import projet.ejb.data.mapper.IMapperEjb;

@Local
@Stateless
public class ServiceGarde implements IServiceGarde {
	@Inject
	private IMapperEjb mapper;

	@Inject
	private IDaoGarde daoGarde;

	@Override
	public int inserer(DtoGarde dtoGarde) throws ExceptionValidation {
		int id = daoGarde.inserer(mapper.map(dtoGarde));
		return id;
	}

	@Override
	public void modifier(DtoGarde dtoGarde) throws ExceptionValidation {
		daoGarde.modifier(mapper.map(dtoGarde));
	}

	

	@Override
	public List<DtoGarde> listerTout() {
		List<DtoGarde> liste = new ArrayList<>();
		for (Garde garde : daoGarde.listerTout()) {
			liste.add(mapper.map(garde));

		}
		return liste;

	}

	@Override
	public void supprimer(int idGarde) throws ExceptionValidation {
		daoGarde.supprimer(idGarde);
		
	}

	@Override
	public DtoGarde retrouver(int idGarde) {
		return mapper.map(daoGarde.retrouver(idGarde));
	}
}
