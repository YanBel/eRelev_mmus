package eReleveEJB;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;


/**
 * Session Bean implementation class UserFlow
 */

@Stateful
@LocalBean
public class ProfFlow implements ProfFlowRemote {

	
	private State state;
	private User u;

	
	@EJB
	GestionReleve g;
	
    /**
     * Default constructor. 
     */
    public ProfFlow() {
        state=State.UNKNOWN;
        u=null;
    }
	
    public State getState() {
		return state;
	}
	
    // Pour s'enregistrer
    
    // Un prof ne peut s'enregistrer lui même, il 
    
    public void register(String nom, String prenom, String email, String password){
    	// Assuming state=UNKNOWN - TODO: add a check
    	if(g.isLoginUsed(email)){
    		// The username is already used
    		state=State.USERNAME_USED;
    	}
    	else{
    		g.registerUser(nom, prenom, email, password, 3);
    		state=State.REGISTERED; 
    		// We could return right here
    		// Instead, we proceed with login
            login(email, password);
            
    	}
    }
	
    
    // Pour se connecter
    public void login(String email, String password){
    	u=g.checkLogin(email, password);
    	if(u==null){
    		state=State.LOGIN_FAILURE;
    	}else{
    		state=State.LOGGED_IN;
    	}
    }

    
    // Pour se déconnecter
    public void logout(){
    	u=null;
    	state=State.UNKNOWN;
    }
    
    
    // Pour récupérer ses enfants élèves
    public List<Eleve> getEleves(){
    	return g.findEleve_parent(u);
    }
    
    
    
    
    
    public User getU() {
		return u;
	}
    
    
}
