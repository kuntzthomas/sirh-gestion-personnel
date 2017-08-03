package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	public List<Departement> listerDepartement() {
		return em.createNamedQuery("Departement.findAll", Departement.class).getResultList();
	}

	public void sauvegarderDepartement(Departement departement) {
		em.persist(departement);
	}
}
