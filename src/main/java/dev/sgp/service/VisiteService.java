package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.VisiteWeb;

@ApplicationScoped
public class VisiteService {

	List<VisiteWeb> listeVisiteWeb = new ArrayList<>();

	public List<VisiteWeb> listerVisitesWeb() {
		return listeVisiteWeb;
	}

	public void sauvegarderVisiteWeb(VisiteWeb visite) {
		listeVisiteWeb.add(visite);
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
