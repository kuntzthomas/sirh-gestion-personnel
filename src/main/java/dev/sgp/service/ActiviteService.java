package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;

@Stateless
public class ActiviteService {

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	public void recevoirEvenementCollab(@Observes CollabEvt evt) {
		em.persist(evt);

	}

	public List<CollabEvt> listerActivitesCollab() {
		return em.createNamedQuery("CollabEvt.findAll", CollabEvt.class).getResultList();

	}
}
