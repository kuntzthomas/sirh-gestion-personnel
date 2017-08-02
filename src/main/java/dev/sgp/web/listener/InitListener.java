package dev.sgp.web.listener;

import java.time.LocalDate;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.utils.Constantes;

@WebListener
public class InitListener implements HttpSessionListener {

	private static final CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		collabService.sauvegarderCollaborateur(new Collaborateur("Kuntz", "Thomas", LocalDate.parse("1988-12-23"),
				"6 rue du poitou", "12345678912345"));
		collabService.sauvegarderCollaborateur(new Collaborateur("IronHead", "Mordrin", LocalDate.parse("1950-12-23"),
				"Karak Hirn", "1547896548954896"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Kuntz", "orehgiroeh", LocalDate.parse("1954-12-23"),
				"107 rue principale", "1579856423598652"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Von Carstein", "Vlad", LocalDate.parse("1968-02-23"),
				"DrakenHoff", "1586589523569875"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Von Carstein", "Mannfred",
				LocalDate.parse("1995-05-23"), "DrakenHoff", "1258648985652357"));
		collabService.sauvegarderCollaborateur(
				new Collaborateur("Franz", "Karl", LocalDate.parse("1975-08-23"), "Altdorf", "15799654893215658"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Von Gustav", "Gustav", LocalDate.parse("1988-12-23"),
				"Altdorf", "4859658752369852"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Heldenhammer", "Sigmar",
				LocalDate.parse("1982-06-02"), "Ascended", "1547896585236985"));
		collabService.sauvegarderCollaborateur(
				new Collaborateur("Baltazar", "Picsou", LocalDate.parse("1988-05-08"), "Banque", "5879658756985235"));
		collabService.sauvegarderCollaborateur(
				new Collaborateur("Duck", "Donald", LocalDate.parse("1925-05-09"), "Bof", "5789658745632145"));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

	}

}
