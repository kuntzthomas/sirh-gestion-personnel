package dev.sgp.entite;

public enum TypeCollabEvt {

	CREATION_COLLAB("Creation d'un nouveau collaborateur"), MODIFICATION_COLLAB("Modification d'un collaborateur");

	String libelle;

	TypeCollabEvt(String libelle) {
		this.setLibelle(libelle);
	}

	public String getLibelle() {
		return libelle;
	}

	void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
