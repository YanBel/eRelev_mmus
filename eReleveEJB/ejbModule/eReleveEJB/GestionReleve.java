package eReleveEJB;

import java.math.BigDecimal;
import java.util.List;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class GestionReleve implements GestionReleveRemote {

	@PersistenceContext
	EntityManager em;
	
	
	/*** Créations ***/
	
	public Classe addClasse(String nom, String branche, Ecole ecole){
    	
		Classe c= new Classe();
		c.setNom(nom);
		c.setBranche(branche);
		c.setEcole(ecole);
		em.persist(c);
		return c;
    }
	
	
	public Ecole addEcole(String nom, String type){
    	
		Ecole ec= new Ecole();
		ec.setNom(nom);
		ec.setType(type);
		em.persist(ec);
		return ec;
    }
		
	
	public Eleve addEleve(String nom, String prenom,  String date_naissance, Classe classe){
    	
		Eleve el= new Eleve();
		el.setNom(nom);
		el.setPrenom(prenom);
		el.setDate_naissance(date_naissance);
		el.setClasse(classe);
		em.persist(el);
		return el;
    }
	
	public Module addModule(String nom, Prof prof){
    	
		Module m= new Module();
		m.setNom(nom);
		m.setProf(prof);
		em.persist(m);
		return m;
    }

	public Note addNote(String note, Eleve eleve, Module module){
    	
		Note n= new Note();
		n.setNote(note);
		n.setEleve(eleve);
		n.setModule(module);
		em.persist(n);
		return n;
    }

	
	public User addProf(String nom, String prenom, String email, String password){
		
		
		Prof pf= new Prof();
		pf.setNom(nom);
		pf.setPrenom(prenom);
		em.persist(pf);

		User u = registerUser(nom, prenom, email, password, 3);
		
		return u;
	}
	
	

	/*** Recherches et consultations ***/
	
@SuppressWarnings("unchecked")
public List<Eleve> findEleve_nom(String nom){
	List<Eleve> list=em.createQuery("SELECT el FROM Eleve el where el.nom=?1")
	    	.setParameter(1,nom)
	    	.getResultList();
	return list.isEmpty()? null : list;
}


@SuppressWarnings("unchecked")
public List<Eleve> findEleve_prenom(String prenom){
	List<Eleve> list=em.createQuery("SELECT el FROM Eleve el where el.prenom=?1")
	    	.setParameter(1,prenom)
	    	.getResultList();
	return list.isEmpty()? null : list;
}

@SuppressWarnings("unchecked")
public List<Eleve> findEleve_classe(Classe classe){
	List<Eleve> list=em.createQuery("SELECT el FROM Eleve el where el.classe=?1")
	    	.setParameter(1,classe)
	    	.getResultList();
	return list.isEmpty()? null : list;
}


@SuppressWarnings("unchecked")
public List<Eleve> getAllEleves(){
	return em.createQuery("SELECT el FROM Eleve el ORDER BY el.nom")
	.getResultList();
}	


@SuppressWarnings("unchecked")
private User findUser(String email){
	List<User> list=em.createQuery("SELECT u FROM User u where u.email=?1")
	    	.setParameter(1,email)
	    	.getResultList();
	return list.isEmpty()? null : list.get(0);
}



/************ Méthodes pour l'utisateur ***************/


public User registerUser(String nom, String prenom, String email, String password, int profil){
	User u=new User();
	u.setNom(nom);
	u.setPrenom(prenom);
	//u.setUsername(username);
	u.setEmail(email);
	newPassword(u, password);
	u.setProfil(profil);  //Profil: parent=1, Prof= 3, Direction= 5.
	em.persist(u);
	return u;
}


 @SuppressWarnings("unused")
 private void newPassword(User u, String password){
    	String salt=BCrypt.gensalt();
		u.setPassword(BCrypt.hashpw(password, salt));
    }
 
 public User checkLogin(String email, String password){
        User retval=findUser(email);
        if(retval==null) return null;
        if(BCrypt.checkpw(password, retval.getPassword()))
        {
     	   return retval;
        } else return null;
     }

 	public boolean isLoginUsed(String login){
 	return findUser(login)!=null;
 }
 	
}
