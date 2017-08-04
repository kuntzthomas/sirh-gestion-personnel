package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Departement")
@NamedQueries({ @NamedQuery(name = "Departement.findAll", query = "select d from Departement d"),
		@NamedQuery(name = "Departement.findDepById", query = "select d from Departement d where d.id=:departement") })
public class Departement {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;

	public Departement() {
		super();
	}

	public Departement(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
