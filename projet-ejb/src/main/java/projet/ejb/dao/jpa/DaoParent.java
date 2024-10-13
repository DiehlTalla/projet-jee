package projet.ejb.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoParent;
import projet.ejb.data.Parent;

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

}
