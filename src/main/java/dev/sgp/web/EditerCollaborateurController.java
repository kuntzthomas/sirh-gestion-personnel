package dev.sgp.web;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebServlet("/collaborateur/editer")
public class EditerCollaborateurController extends HttpServlet {

	@EJB
	private CollaborateurService collabService;
	@EJB
	private DepartementService departementService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Optional<String> matricule = Optional.ofNullable(req.getParameter("matricule"));
		if (matricule.isPresent() && collabService.trouverCollabParMatricule(matricule.get()) != null) {
			req.setAttribute("collab", collabService.trouverCollabParMatricule(matricule.get()));
			req.setAttribute("listeDepartements", departementService.listerDepartement());
			req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("lister");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String matricule = req.getParameter("matricule");
		String adresse = req.getParameter("adresse");
		boolean inactif = req.getParameter("desactiver") == null;
		String intitulePoste = req.getParameter("intitulePoste");
		String banque = req.getParameter("banque");
		String iban = req.getParameter("iban");
		String bic = req.getParameter("bic");
		Departement departement = departementService
				.getDepartementById(Integer.valueOf(req.getParameter("departement")));

		collabService.updateCollaborateur(
				new Collaborateur(matricule, adresse, inactif, intitulePoste, departement, banque, iban, bic));
		resp.sendRedirect("lister");
	}
}
