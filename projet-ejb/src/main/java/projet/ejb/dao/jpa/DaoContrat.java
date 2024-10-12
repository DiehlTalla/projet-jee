package projet.ejb.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoContrat;
import projet.ejb.data.Contrat;

public class DaoContrat implements IDaoContrat {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Contrat contrat) {
		em.persist(contrat);
		em.flush();
		return contrat.getId();
	}

	@Override
	public void modifier(Contrat contrat) {
		em.merge(contrat);

	}

	@Override
	public void supprimer(int idContrat) {
		em.remove(retrouver(idContrat));
	}

	@Override
	public Contrat retrouver(int idContrat) {
		return em.find(Contrat.class, idContrat);
	}

	@Override
	public List<Contrat> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Contrat c ORDER BY c.nom";
		var query = em.createQuery(jpql, Contrat.class);
		return query.getResultList();
	}

}
