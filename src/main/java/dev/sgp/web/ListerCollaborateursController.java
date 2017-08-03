package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebServlet("/collaborateur/lister")
public class ListerCollaborateursController extends HttpServlet {

	// Récupération du service
	@Inject
	private CollaborateurService collabService;
	@Inject
	private DepartementService depService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		List<Departement> departements = depService.listerDepartement();
		req.setAttribute("listeCollab", collaborateurs);
		req.setAttribute("listeDep", departements);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);

	}

}
