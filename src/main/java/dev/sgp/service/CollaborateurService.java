package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	@Inject
	Event<CollabEvt> collabEvt;

	public List<Collaborateur> listerCollaborateurs() {
		return em.createNamedQuery("Collaborateur.findAll", Collaborateur.class).getResultList();
	}

	public List<Collaborateur> listerCollabParDepartement(Integer departement) {
		return em.createNamedQuery("Collaborateur.findByDep", Collaborateur.class)
				.setParameter("departement", departement).getResultList();

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		collab.setMatricule(collab.getPrenom().substring(0, 1) + collab.getNom());
		collab.setPhoto("http://i.imgur.com/oPyO3CJ.png");
		collab.setEmailPro(collab.getNom() + "." + collab.getPrenom() + "@societe.com");
		collab.setDateHeureCreation(ZonedDateTime.now());
		collab.setActif(true);

		em.persist(collab);

		collabEvt.fire(
				new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	}

	public Collaborateur trouverCollabParMatricule(String matricule) {

		return em.createNamedQuery("Collaborateur.findByMat", Collaborateur.class).setParameter("matricule", matricule)
				.getSingleResult();
	}

	public void updateCollaborateur(Collaborateur collaborateur) {
		Collaborateur collab = trouverCollabParMatricule(collaborateur.getMatricule());
		if (collab != null) {
			collab.setActif(collaborateur.isActif());
			collab.setAdresse(collaborateur.getAdresse());
			collab.setBanque(collaborateur.getBanque());
			collab.setBic(collaborateur.getBic());
			collab.setIban(collaborateur.getIban());
			collab.setIntitulePoste(collaborateur.getIntitulePoste());
			collab.setDepartement(collaborateur.getDepartement());
			em.merge(collab);
			collabEvt.fire(new CollabEvt(ZonedDateTime.now(), TypeCollabEvt.MODIFICATION_COLLAB,
					collaborateur.getMatricule()));
		}
	}
}
