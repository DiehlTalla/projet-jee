package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoGarde;
import projet.ejb.data.Contrat;
import projet.ejb.data.Garde;

@Stateless
@Local
//@TransactionAttribute(MANDATORY)
public class DaoGarde implements IDaoGarde {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Garde garde) {
		em.persist(garde);
		em.flush();
		return garde.getId();
	}

	@Override
	public void modifier(Garde garde) {
		em.merge(garde);
	}

	@Override
	public void supprimer(int idGarde) {
		em.remove(retrouver(idGarde));
		
	}

	@Override
	public Garde retrouver(int idGarde) {
		return em.find(Garde.class, idGarde);	
	}

	@Override
	public List<Garde> listerTout() {

		em.clear();
		var jpql = "SELECT g FROM Garde g ";
		var query = em.createQuery(jpql, Garde.class);
		return query.getResultList();
	}


	@Override
	public List<Garde> listerParContrat(int idContrat) {
		em.clear();
		var jpql = "SELECT g FROM Garde g WHERE g.contrat.id = :idContrat";
		var query = em.createQuery(jpql, Garde.class);
		query.setParameter("idContrat", idContrat);
		return query.getResultList();
	}

}
