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
@Table(name="Module")
public class Module implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5528552575942140658L;


	private long id;
	

	private String nom;
	
	
	private Prof prof;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

    
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Column(name="nom")
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	@ManyToOne
	@JoinColumn(name = "prof")
	public Prof getProf() {
		return prof;
	}


	public void setProf(Prof prof) {
		this.prof = prof;
	}

}
