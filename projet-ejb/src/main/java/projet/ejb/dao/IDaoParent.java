package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Parent;

public interface IDaoParent {

	int inserer(Parent parent);

	void modifier(Parent parent);

	void supprimer(int idparent);

	Parent retrouver(int idparent);

	List<Parent> listerTout();

	List<Parent> listerParCompte(int idCompte);

}
