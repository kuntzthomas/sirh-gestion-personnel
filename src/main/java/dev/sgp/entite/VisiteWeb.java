package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "VisiteWeb")
@NamedQueries({ @NamedQuery(name = "VisiteWeb.findAll", query = "select v from VisiteWeb v") })
public class VisiteWeb {

	@Id
	@GeneratedValue
	private Integer id;
	private String chemin;
	private Integer tempsExecution;

	public VisiteWeb() {
		super();
	}

	public VisiteWeb(String chemin, Integer tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Integer getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
