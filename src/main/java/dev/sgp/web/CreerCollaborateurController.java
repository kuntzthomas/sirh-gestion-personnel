package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.utils.Constantes;

public class CreerCollaborateurController extends HttpServlet {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> list = Stream.of("nom", "prenom", "adresse", "dateNaissance", "numSecu")
				.filter(p -> req.getParameter(p) == null).collect(Collectors.toList());
		resp.getWriter().write("");

		if (list.isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_CREATED);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			Collaborateur collab = new Collaborateur(req.getParameter("nom"), req.getParameter("prenom"),
					LocalDate.parse(req.getParameter("dateNaissance"), formatter), req.getParameter("adresse"),
					req.getParameter("numSecu"));

			collabService.sauvegarderCollaborateur(collab);
			resp.sendRedirect("/sgp/collaborateur/lister");

		} else {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
