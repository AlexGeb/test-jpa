package fr.brico.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "bon")
public class BonCommande {
	@Id
	private Integer id;

	@Column
	private Integer numero;

	@Column
	private Integer delai;

	@Column
	private LocalDate date_cmde;

	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	private Fournisseur fournisseur;

	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_BON", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ART", referencedColumnName = "ID"))
	private Set<Article> articles;

	@Override
	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append("[").append(id).append(" ").append(numero).append(" ").append(delai).append(" ")
				.append(date_cmde).append(" ").append(articles.size()).append("]");
		return strbuilder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public LocalDate getDate_cmde() {
		return date_cmde;
	}

	public void setDate_cmde(LocalDate date_cmde) {
		this.date_cmde = date_cmde;
	}

	public Fournisseur getId_fou() {
		return fournisseur;
	}

	public void setId_fou(Fournisseur fou) {
		this.fournisseur = fou;
	}

}
