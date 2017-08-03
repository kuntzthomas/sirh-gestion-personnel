package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import dev.sgp.entite.CollabEvt;

@ApplicationScoped
public class ActiviteService {

	List<CollabEvt> listeEvt = new ArrayList<>();

	public void recevoirEvenementCollab(@Observes CollabEvt evt) {
		listeEvt.add(evt);

	}

	public List<CollabEvt> listerActivitesCollab() {
		return listeEvt;

	}
}
