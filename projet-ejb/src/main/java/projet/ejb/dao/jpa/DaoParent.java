package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoParent;
import projet.ejb.data.Garde;
import projet.ejb.data.Parent;


@Stateless
@Local
//@TransactionAttribute(MANDATORY)
public class DaoParent implements IDaoParent {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Parent parent) {
		em.persist(parent);
		em.flush();
		return parent.getId();
	}

	@Override
	public void modifier(Parent parent) {
		em.merge(parent);
	}

	@Override
	public void supprimer(int idparent) {
		em.remove(retrouver(idparent));
	}

	@Override
	public Parent retrouver(int idparent) {
		return em.find(Parent.class, idparent);
	}

	@Override
	public List<Parent> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Parent p ORDER BY p.nom";
		var query = em.createQuery(jpql, Parent.class);
		return query.getResultList();
	}
	
	@Override
	public List<Parent> listerParCompte(int idCompte) {
		em.clear();
		var jpql = "SELECT p FROM Parent p WHERE p.compte.id = :idCompte";
		var query = em.createQuery(jpql, Parent.class);
		query.setParameter("idCompte", idCompte);
		return query.getResultList();
	}

}
