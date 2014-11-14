package eReleveEJB;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GestionReleveRemote {

	public Classe addClasse(String nom, String branche, Ecole ecole);
	public Ecole addEcole(String nom, String type);
	public Eleve addEleve(String nom, String prenom,  String date_naissance, Classe classe);
	public Module addModule(String nom, Prof prof);
	public Note addNote(String note, Eleve eleve, Module module);
	public User addProf(String nom, String prenom, String email, String password);
	public List<Eleve> findEleve_nom(String nom);
	public List<Eleve> findEleve_parent(User parent);
	public List<Eleve> getAllEleves();
	public User registerUser(String nom, String prenom, String email, String password, int profil);
	public User checkLogin(String email, String password);
 	public boolean isLoginUsed(String login);
 
	
}
