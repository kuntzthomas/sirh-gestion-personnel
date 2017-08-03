package dev.sgp.web.listener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class InitListener implements ServletContextListener {

	@Inject
	private CollaborateurService collabService;

	@Inject
	private DepartementService depService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		depService.sauvegarderDepartement(new Departement("Comptabilité"));
		depService.sauvegarderDepartement(new Departement("Ressources Humaines"));
		depService.sauvegarderDepartement(new Departement("Informatique"));
		depService.sauvegarderDepartement(new Departement("Administratif"));

		List<Departement> dep = new ArrayList<>();
		dep.addAll(depService.listerDepartement());

		collabService.sauvegarderCollaborateur(new Collaborateur("Kuntz", "Thomas", LocalDate.parse("1988-12-23"),
				"6 rue du poitou", "12345678912345", "Dev", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("IronHead", "Mordrin", LocalDate.parse("1950-12-23"),
				"Karak Hirn", "1547896548954896", "Maitre des runes", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Kuntz", "Elisa", LocalDate.parse("1954-12-23"),
				"107 rue principale", "1579856423598652", "Dev", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Von Carstein", "Vlad", LocalDate.parse("1968-02-23"),
				"DrakenHoff", "1586589523569875", "Vampire", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Von Carstein", "Mannfred",
				LocalDate.parse("1995-05-23"), "DrakenHoff", "1258648985652357", "Vampire", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Franz", "Karl", LocalDate.parse("1975-08-23"),
				"Altdorf", "15799654893215658", "Empereur", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Von Gustav", "Gustav", LocalDate.parse("1988-12-23"),
				"Altdorf", "4859658752369852", "Chirurgien Barbier", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Heldenhammer", "Sigmar",
				LocalDate.parse("1982-06-02"), "Ascended", "1547896585236985", "PDG", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Baltazar", "Picsou", LocalDate.parse("1988-05-08"),
				"Banque", "5879658756985235", "Riche", dep.get(2)));
		collabService.sauvegarderCollaborateur(new Collaborateur("Duck", "Donald", LocalDate.parse("1925-05-09"), "Bof",
				"5789658745632145", "Pauvre", dep.get(2)));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
