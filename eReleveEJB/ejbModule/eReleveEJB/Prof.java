package eReleveEJB;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Prof")
public class Prof implements Serializable {

	
	private static final long serialVersionUID = -5960371069728822202L;

	private long id;
	

	private String nom;
	
	
	private String prenom;
	
	
	
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

	
	
	@Column(name="Prenom")
	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
