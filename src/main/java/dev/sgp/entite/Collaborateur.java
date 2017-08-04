package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Collaborateur")
@NamedQueries({ @NamedQuery(name = "Collaborateur.findAll", query = "select c from Collaborateur c"),
		@NamedQuery(name = "Collaborateur.findByDep", query = "select c from Collaborateur c where c.departement.id=:departement"),
		@NamedQuery(name = "Collaborateur.findByMat", query = "select c from Collaborateur c where c.matricule=:matricule") })
public class Collaborateur {

	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String adresse;
	private String numSecu;
	private String emailPro;
	private String intitulePoste;
	@ManyToOne
	@JoinColumn(name = "Dep_Id")
	private Departement departement;
	private String photo;
	private ZonedDateTime dateHeureCreation;
	private Boolean actif;
	private String banque;
	private String iban;
	private String bic;

	public Collaborateur() {
		super();
	}

	public Collaborateur(String matricule, String adresse, boolean actif, String intitulePoste, Departement departement,
			String banque, String iban, String bic) {
		super();
		this.matricule = matricule;
		this.adresse = adresse;
		this.actif = actif;
		this.intitulePoste = intitulePoste;
		this.departement = departement;
		this.banque = banque;
		this.iban = iban;
		this.bic = bic;

	}

	public Collaborateur(String nom, String prenom, LocalDate dateNaissance, String adresse, String numSecu) {
		super();
		this.matricule = null;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.emailPro = null;
		this.photo = null;
		this.dateHeureCreation = ZonedDateTime.now();
		this.actif = false;
	}

	public Collaborateur(String nom, String prenom, LocalDate dateNaissance, String adresse, String numSecu,
			String intitulePoste, Departement departement) {
		super();
		this.matricule = null;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.emailPro = null;
		this.intitulePoste = intitulePoste;
		this.departement = departement;
		this.photo = null;
		this.dateHeureCreation = ZonedDateTime.now();
		this.actif = false;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public Boolean isActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
