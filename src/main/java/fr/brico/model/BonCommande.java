package fr.brico.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Type(type = "timestamp")
	private Date date_cmde;

	@Column
	private Integer id_fou;

	@Override
	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append("[").append(id).append(" ").append(numero).append(" ").append(delai).append(" ")
				.append(date_cmde).append("]");
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

	public Date getDate_cmde() {
		return date_cmde;
	}

	public void setDate_cmde(Date date_cmde) {
		this.date_cmde = date_cmde;
	}

	public Integer getId_fou() {
		return id_fou;
	}

	public void setId_fou(Integer id_fou) {
		this.id_fou = id_fou;
	}

}
