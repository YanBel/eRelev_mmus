package eReleveEJB;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Classe")
public class Classe implements Serializable {

	
	private static final long serialVersionUID = -5960371069728822202L;

	private long id;
	

	private String nom;
	
	
	private String branche;
	
	
	private Ecole ecole;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

    
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Column(name="Nom")
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	@Column(name="Branche")
	public String getBranche() {
		return branche;
	}


	public void setBranche(String branche) {
		this.branche = branche;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "Ecole")
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
}
