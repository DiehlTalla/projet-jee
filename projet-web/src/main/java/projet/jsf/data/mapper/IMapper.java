package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoContrat;
import projet.commun.dto.DtoGarde;
import projet.commun.dto.DtoParent;
import projet.commun.dto.DtoTarif;
import projet.jsf.data.Compte;
import projet.jsf.data.Contrat;
import projet.jsf.data.Parent;
import projet.jsf.data.Garde;
import projet.jsf.data.Tarif;

@Mapper(componentModel = "cdi")
public interface IMapper {

	// -------
	// Compte
	// -------

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	Compte duplicate(Compte source);

	Compte update(@MappingTarget Compte target, Compte source);

	// -------
	// Contrat
	// -------

	Contrat map(DtoContrat source);

	DtoContrat map(Contrat source);

	Contrat duplicate(Contrat source);

	Contrat update(@MappingTarget Contrat target, Contrat source);

	// -------
	// Parent
	// -------

	Parent map(DtoParent source);

	DtoParent map(Parent source);

	Parent duplicate(Parent source);

	Parent update(@MappingTarget Parent target, Parent source);
	
	// Tarif

	Tarif map(DtoTarif source);

	DtoTarif map(Tarif source);

	Tarif duplicate(Tarif source);

	Tarif update(@MappingTarget Tarif target, Tarif source);
	
	// Garde 

		Garde map(DtoGarde source);

		DtoGarde map(Garde source);

		Garde duplicate(Garde source);

		Garde update(@MappingTarget Garde target, Garde source);


}
