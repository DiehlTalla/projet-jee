package projet.ejb.service.standard;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoTarif;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceTarif;
import projet.ejb.dao.IDaoTarif;
import projet.ejb.data.Tarif;
import projet.ejb.data.mapper.IMapperEjb;


@Stateless
@Remote
public class ServiceTarif implements IServiceTarif {
	
	
	@Inject
	private IMapperEjb mapper;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private IDaoTarif daoTarif;
	

	@Override
	public int inserer(DtoTarif dtoTarif) throws ExceptionValidation {
		int id = daoTarif.inserer(mapper.map(dtoTarif));
		return id;
	}

	@Override
	public void modifier(DtoTarif dtoTarif) throws ExceptionValidation {
		daoTarif.modifier(mapper.map(dtoTarif));

	}

	@Override
	public void supprimer(int idTarif) throws ExceptionValidation {
		daoTarif.supprimer(idTarif);

	}

	@Override
	public DtoTarif retrouver(int idTarif) {
		return mapper.map(daoTarif.retrouver(idTarif));
	}

	@Override
	public List<DtoTarif> listerTout() {
		List<DtoTarif> liste = new ArrayList<>();
		for (Tarif tarif : daoTarif.listerTout()) {
			liste.add(mapper.map(tarif));
		}
		return liste;
	}

}
