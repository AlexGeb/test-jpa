package fr.brico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
	@Id
	private Integer id;
	
	@Column
	private String nom;

	@Override
	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append("[").append(id).append(" ").append(nom).append("]");
		return strbuilder.toString();
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
