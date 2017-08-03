package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.Departement;

@ApplicationScoped
public class DepartementService {

	List<Departement> listeDepartements = new ArrayList<>();

	public List<Departement> listerDepartement() {
		return listeDepartements;
	}

	public void sauvegarderDepartement(Departement departement) {
		listeDepartements.add(departement);
	}
}
