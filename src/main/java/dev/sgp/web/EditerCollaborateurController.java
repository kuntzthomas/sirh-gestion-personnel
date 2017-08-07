package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String matriculeParam = req.getParameter("matricule");
		if (matriculeParam == null) {
			resp.setContentType("text/html");
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setContentType("text/html");
			resp.getWriter().write("<h1>Edition de collaborateur</h1>" + "<p>Matricule : " + matriculeParam + "</p>");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matriculeParam = req.getParameter("matricule");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		String intitulePosteParam = req.getParameter("intitulePoste");
		String banqueParam = req.getParameter("banque");
		String ibanParam = req.getParameter("iban");
		String bicParam = req.getParameter("bic");

		List<String> paramsNull = Stream.of("matricule", "titre", "nom", "prenom")
				.filter(p -> req.getParameter(p) == null).collect(Collectors.toList());

		List<String> params = Arrays.asList(matriculeParam, intitulePosteParam, nomParam, prenomParam, banqueParam,
				ibanParam, bicParam);

		if (paramsNull.isEmpty()) {
			resp.setContentType("text/html");
			resp.setStatus(201);

			params.stream().forEach(resp.getWriter()::write);
		} else {
			resp.setContentType("text/html");
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects : ");
			paramsNull.stream().forEach(resp.getWriter()::write);
		}
	}
}
