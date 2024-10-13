package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoContrat;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceContrat;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoContrat;
import projet.ejb.data.Contrat;
import projet.ejb.data.mapper.IMapperEjb;


@Stateful
@Remote
public class ServiceContrat implements IServiceContrat {

	
	// Champs
		@Inject
		private IMapperEjb mapper;
		@Inject
		private IDaoContrat daoContrat;

		// Actions

		@Override
		public int inserer(DtoContrat dtoContrat) throws ExceptionValidation {
			verifierValiditeDonnees(dtoContrat);
			int id = daoContrat.inserer(mapper.map(dtoContrat));
			return id;
		}

		@Override
		public void modifier(DtoContrat dtoContrat) throws ExceptionValidation {
			verifierValiditeDonnees(dtoContrat);
			daoContrat.modifier(mapper.map(dtoContrat));
		}

		@Override
		public void supprimer(int idContrat) throws ExceptionValidation {
			daoContrat.supprimer(idContrat);
		}

		@Override
		@TransactionAttribute(NOT_SUPPORTED)
		public DtoContrat retrouver(int idContrat) {
			return mapper.map(daoContrat.retrouver(idContrat));
		}

		@Override
		@TransactionAttribute(NOT_SUPPORTED)
		public List<DtoContrat> listerTout() {
			List<DtoContrat> liste = new ArrayList<>();
			for (Contrat contrat : daoContrat.listerTout()) {
				liste.add(mapper.map(contrat));
			}
			return liste;
		}

		// Méthodes auxiliaires

		private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

			StringBuilder message = new StringBuilder();

			if (dtoContrat.getNom() == null || dtoContrat.getNom().isEmpty()) {
				message.append("\nLe nom est absent.");
			} else if (dtoContrat.getNom().length() < 3) {
				message.append("\nLe nom est trop court.");
			} else if (dtoContrat.getNom().length() > 25) {
				message.append("\nLe nom est trop long.");
			}
			
			if (dtoContrat.getPrenom() == null || dtoContrat.getPrenom().isEmpty()) {
				message.append("\nLe prenom est absent.");
			} else if (dtoContrat.getPrenom().length() < 3) {
				message.append("\nLe prenom est trop court.");
			} else if (dtoContrat.getPrenom().length() > 25) {
				message.append("\nLe prenom est trop long.");
			}
			
			if (dtoContrat.getDateNaissance() == null || ((List<DtoContrat>) dtoContrat.getDateNaissance()).isEmpty()) {
				message.append("\nLe date de naissance est absente.");
			}
			
			if (dtoContrat.getDebut() == null || ((List<DtoContrat>) dtoContrat.getDebut()).isEmpty()) {
				message.append("\nLa date de début est absente.");
			}
			
			if (dtoContrat.getFin() == null || ((List<DtoContrat>) dtoContrat.getFin()).isEmpty()) {
				message.append("\nLa date de fin est absente.");
			}
			
			if (dtoContrat.getTarifHoraire() <= 0) {
				message.append("\nLe tarif doit être positif.");
			}

			
			if (message.length() > 0) {
				throw new ExceptionValidation(message.toString().substring(1));
			}
		}

	
	
}
