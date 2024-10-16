SET search_path TO projet;


-- Supprime toutes les données
DELETE FROM compte;


-- Insère les données

-- Compte

INSERT INTO compte (idcompte, pseudo, motdepasse, email, flagadmin ) VALUES 
( 1, 'geek', 'geek', 'geek@jfox.fr', TRUE ),
( 2, 'chef', 'chef', 'chef@jfox.fr', FALSE ),
( 3, 'job', 'job', 'job@jfox.fr', FALSE );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 4;

INSERT INTO parent (idparent, idcompte, nom, prenom, adresse_postale, email, telephone)	VALUES	
(1, 1, 'foudjo', 'daniel', '9 rue andre antoine', 'dan@3il.fr', '0745289044');

 
