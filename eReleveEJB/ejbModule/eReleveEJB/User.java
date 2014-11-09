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
@Table(name="Eleve")
public class User implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private long id;

	
	//private String username;
	
	
	private String nom;

	
	private String prenom;

		
	
	private String email;

	
	
	private String password;
	
	
	
	private int profil;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

    
	public void setId(long id) {
		this.id = id;
	}
	
	/*
	@Column(name="username")
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
*/
	
	 @Column(name="Prenom")
	public String getPrenom() {
		return prenom;
	}

		
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

		
	@Column(name="Nom")
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	@Column(name="password")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Column(name="profil")
	public int getProfil() {
		return profil;
	}


	public void setProfil(int profil) {
		this.profil = profil;
	}
	
	
}

	
