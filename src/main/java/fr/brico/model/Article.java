package fr.brico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	@Column
	private Integer id_fou;

	@Override
	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append("[").append(id).append(" ").append(ref).append(" ").append(designation).append(" ")
				.append(prix).append(" ").append(id_fou).append("]");
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

	public Integer getId_fou() {
		return id_fou;
	}

	public void setId_fou(Integer id_fou) {
		this.id_fou = id_fou;
	}
}
