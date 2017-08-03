package dev.sgp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.VisiteWeb;

@Stateless
public class VisiteService {

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	public List<VisiteWeb> listerVisitesWeb() {
		return em.createNamedQuery("VisiteWeb.findAll", VisiteWeb.class).getResultList();
	}

	public void sauvegarderVisiteWeb(VisiteWeb visiteWeb) {
		em.persist(visiteWeb);
	}

	public List<VisiteWeb> getVisitesParChemin(String chemin) {
		return listerVisitesWeb().stream().filter(v -> v.getChemin().equals(chemin)).collect(Collectors.toList());
	}

	public int getNombreVisitesParChemin(String chemin) {
		return (int) getVisitesParChemin(chemin).stream().count();
	}

	public int getTempsMinVisitesParChemin(String chemin) {
		return getVisitesParChemin(chemin).stream().mapToInt(VisiteWeb::getTempsExecution).min().getAsInt();
	}

	public int getTempsMaxVisitesParChemin(String chemin) {
		return getVisitesParChemin(chemin).stream().mapToInt(VisiteWeb::getTempsExecution).max().getAsInt();
	}

	public int getTempsMoyenVisitesParChemin(String chemin) {
		return (int) Math.round(
				getVisitesParChemin(chemin).stream().mapToInt(VisiteWeb::getTempsExecution).average().getAsDouble());
	}

}
