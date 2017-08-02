package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Statistique;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteService;
import dev.sgp.utils.Constantes;

public class VisiteController extends HttpServlet {

	private static final VisiteService visiteService = Constantes.VISITE_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, List<VisiteWeb>> groupe = visiteService.listerVisitesWeb().stream()
				.collect(Collectors.groupingBy(VisiteWeb::getChemin));

		List<Statistique> listeStatistiques = groupe.keySet().stream().map(chemin -> {
			Statistique stat = new Statistique();
			stat.setChemin(chemin);
			stat.setNbVisites(visiteService.getNombreVisitesParChemin(chemin));
			stat.setTempsMin(visiteService.getTempsMinVisitesParChemin(chemin));
			stat.setTempsMax(visiteService.getTempsMaxVisitesParChemin(chemin));
			stat.setTempsMoyenne(visiteService.getTempsMoyenVisitesParChemin(chemin));
			return stat;
		}).collect(Collectors.toList());

		req.setAttribute("listeStatistiques", listeStatistiques);
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(req, resp);

	}
}
