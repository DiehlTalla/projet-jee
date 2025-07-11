package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoGarde;
import projet.commun.exception.ExceptionValidation;

public interface IServiceGarde {

	int inserer(DtoGarde dtoGarde) throws ExceptionValidation;

	void modifier(DtoGarde dtoGarde) throws ExceptionValidation;

	void supprimer(int idGarde) throws ExceptionValidation;

	DtoGarde retrouver(int idGarde);

	List<DtoGarde> listerTout();

	List<DtoGarde> 	listerParContrat(int idContrat);

	List<DtoGarde> listerParCompte(int idParent);
}
