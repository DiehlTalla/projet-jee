package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoContrat;
import projet.ejb.data.Contrat;


@Stateless
@Local
//@TransactionAttribute(MANDATORY)
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

	@Override
	public List<Contrat> listerParParent(int idParent) {
		em.clear();
		var jpql = "SELECT c FROM Contrat c WHERE c.parent.id = :idParent ORDER BY c.nom";
		var query = em.createQuery(jpql, Contrat.class);
		query.setParameter("idParent", idParent);
		return query.getResultList();
	}
	
	@Override
	public List<Contrat> listerParCompte(int idCompte){
		em.clear();
		var jpql = "SELECT c FROM Contrat c WHERE c.parent.compte.id = :idCompte";
		var query = em.createQuery(jpql, Contrat.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}

}
