package fr.brico.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
	@Id
	private Integer id;

	@Column
	private String ref;

	@Column
	private String designation;

	@Column
	private Double prix;

	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	private Fournisseur fournisseur;

	@ManyToMany(mappedBy = "articles")
	private Set<BonCommande> bons;

	@Override
	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append("[").append(id).append(" ").append(ref).append(" ").append(designation).append(" ")
				.append(prix).append(" ").append(fournisseur.toString()).append("]");
		return strbuilder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fou) {
		this.fournisseur = fou;
	}

	public Set<BonCommande> getBons() {
		return bons;
	}

	public void setBons(Set<BonCommande> bons) {
		this.bons = bons;
	}
}
