package eReleveEJB;

import java.math.BigDecimal;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GestionReleve implements GestionReleveRemote {

	@PersistenceContext
	EntityManager em;
	
	/*
	@SuppressWarnings("unchecked")
	public List<User> getAllMembres(){
    	return em.createQuery("SELECT u FROM User u ORDER BY u.last_name")
    	.getResultList();
    }	
	*/
	
	
	public Classe registerClasse(String nom, String branche, Ecole ecole){
    	
		Classe c= new Classe();
		c.setNom(nom);
		c.setBranche(branche);
		c.setEcole(ecole);
		em.persist(c);
		return c;
    }
	
	
	public Ecole registerEcole(String nom, String type){
    	
		Ecole ec= new Ecole();
		ec.setNom(nom);
		ec.setType(type);
		em.persist(ec);
		return ec;
    }
		
	
	public Eleve registerEleve(String nom, String prenom,  String date_naissance, Classe classe){
    	
		Eleve el= new Eleve();
		el.setNom(nom);
		el.setPrenom(prenom);
		el.setDate_naissance(date_naissance);
		el.setClasse(classe);
		em.persist(el);
		return el;
    }
	
	public Module registerModule(String nom, String prof){
    	
		Module m= new Module();
		m.setNom(nom);
		m.setProf(prof);
		em.persist(m);
		return m;
    }

public Note registerNote(String note, Eleve eleve, Module module){
    	
		Note n= new Note();
		n.setNote(note);
		n.setEleve(eleve);
		n.setModule(module);
		em.persist(n);
		return n;
    }


}
