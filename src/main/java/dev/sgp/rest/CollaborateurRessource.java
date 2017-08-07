package dev.sgp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@Path("/collaborateurs")
public class CollaborateurRessource {

	@EJB
	private CollaborateurService collabService;

	@EJB
	private DepartementService depService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") Integer departement) {
		if (departement == null) {
			return collabService.listerCollaborateurs();
		} else {
			return collabService.listerCollabParDepartement(departement);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{matricule}")
	public Collaborateur trouverCollabParMatricule(@PathParam("matricule") String matricule) {
		return collabService.trouverCollabParMatricule(matricule);

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{matricule}")
	public void updateCollaborateur(@PathParam("matricule") String matricule, Collaborateur collab) {

		collabService.updateCollaborateur(matricule, collab);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{matricule}/banque")
	public Object list(@PathParam("matricule") String matricule) {

		Collaborateur collab = collabService.trouverCollabParMatricule(matricule);
		if (collab.getBanque() == null || collab.getBic() == null || collab.getIban() == null) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Des informations concernant la banque sont manquantes veuillez editer le collaborateur : "
							+ collab.getNom().toUpperCase() + " " + collab.getPrenom())
					.build();
		} else {
			return Json.createObjectBuilder().add("banque", collab.getBanque()).add("bic", collab.getBic())
					.add("iban", collab.getIban()).build();

		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{matricule}/banque")
	public Response updateBanqueCollaborateur(@PathParam("matricule") String matricule,
			@QueryParam("banque") String banque, @QueryParam("bic") String bic, @QueryParam("iban") String iban) {

		Map<String, Object> params = new HashMap<>();
		params.put("matricule", matricule);
		params.put("banque", banque);
		params.put("bic", bic);
		params.put("iban", iban);

		List<String> notFound = params.entrySet().stream().filter(p -> p.getValue() == null).map(p -> p.getKey())
				.collect(Collectors.toList());
		if (!notFound.isEmpty()) {

			JsonObject jSon = Json.createObjectBuilder().add("non_renseigne", "[" + String.join(", ", notFound) + "]")
					.build();
			return Response.status(400).entity(jSon).build();

		} else {
			Collaborateur collab = collabService.trouverCollabParMatricule(matricule);
			collab.setBanque(banque);
			collab.setBic(bic);
			collab.setIban(iban);
			collabService.updateBanqueCollaborateur(matricule, collab);
			return Response.status(Response.Status.OK).build();

		}
	}
}
