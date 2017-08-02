package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {

	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

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
	}
}
