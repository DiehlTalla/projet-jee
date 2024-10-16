package projet.ejb.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoTarif;
import projet.ejb.data.Tarif;

public class DaoTarif implements IDaoTarif {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void supprimer(int idTarif) {
		em.remove( retrouver(idTarif) );

	}

	@Override
	public int inserer(Tarif tarif) {
		em.persist(tarif);
		em.flush();
		return tarif.getId();
	}

	@Override
	public void modifier(Tarif tarif) {
		em.merge( tarif );
		
	}

	@Override
	public Tarif retrouver(int idTarif) {
		return em.find( Tarif.class, idTarif );
	}

	@Override
	public List<Tarif> listerTout() {
		em.clear();
		var jpql = "SELECT t FROM Tarif t";
		var query = em.createQuery( jpql, Tarif.class );
		return query.getResultList();
	}

}
