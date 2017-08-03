package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.service.CollaborateurService;

@WebServlet("/collaborateur/editer")
public class EditerCollaborateurController extends HttpServlet {

	@Inject
	private CollaborateurService collabService;

	private static final String MATRICULE = "matricule";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String avecMatricule = req.getParameter(MATRICULE);

		resp.setContentType("text/html");

		if (avecMatricule == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("<h1>Un matricule est attendu</h1>");
		} else {
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().write("<h1> Edition de collaborateur</h1>Matricule : " + avecMatricule);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> list = Stream.of(MATRICULE, "titre", "nom", "prenom").filter(p -> req.getParameter(p) == null)
				.collect(Collectors.toList());
		resp.getWriter().write("");

		if (list.isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_CREATED);
			resp.getWriter()
					.write("Creation d'un collaborateur avec les informations suivantes : </br> matricule = "
							+ req.getParameter(MATRICULE) + ", titre = " + req.getParameter("titre") + ", nom = "
							+ req.getParameter("nom") + ", prenom = " + req.getParameter("prenom"));
		} else {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Les parametres suivants sont incorrect : " + String.join(", ", list));
		}
	}
}
