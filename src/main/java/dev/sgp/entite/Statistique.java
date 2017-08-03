package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Statistique")
@NamedQueries({ @NamedQuery(name = "Statistique.findAll", query = "select c from Statistique c") })
public class Statistique {

	@Id
	private String chemin;
	private Integer nbVisites;
	private Integer tempsMin;
	private Integer tempsMax;
	private Integer tempsMoyen;

	public Statistique() {
		super();
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public int getNbVisites() {
		return nbVisites;
	}

	public void setNbVisites(int nbVisites) {
		this.nbVisites = nbVisites;
	}

	public int getTempsMin() {
		return tempsMin;
	}

	public void setTempsMin(int tempsMin) {
		this.tempsMin = tempsMin;
	}

	public int getTempsMax() {
		return tempsMax;
	}

	public void setTempsMax(int tempsMax) {
		this.tempsMax = tempsMax;
	}

	public int getTempsMoyenne() {

		return tempsMoyen;

	}

	public void setTempsMoyenne(int tempsMoyenne) {

		this.tempsMoyen = tempsMoyenne;

	}

}
