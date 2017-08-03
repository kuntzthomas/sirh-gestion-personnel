package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class CollaborateurService {

	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	@Inject
	Event<CollabEvt> collabEvt;

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		collab.setMatricule(collab.getPrenom().substring(0, 1) + collab.getNom());
		collab.setPhoto("http://i.imgur.com/oPyO3CJ.png");
		collab.setEmailPro(collab.getNom() + "." + collab.getPrenom() + "@societe.com");
		collab.setDateHeureCreation(ZonedDateTime.now());
		collab.setActif(true);

		listeCollaborateurs.add(collab);

		collabEvt.fire(
				new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	}
}
