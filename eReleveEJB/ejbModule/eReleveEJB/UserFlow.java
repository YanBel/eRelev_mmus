package eReleveEJB;

import java.math.BigDecimal;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;


/**
 * Session Bean implementation class UserFlow
 */

@Stateful
@LocalBean
public class UserFlow implements UserFlowRemote {

	
	private State state;
	private User u;

	
	@EJB
	GestionReleve g;
	
    /**
     * Default constructor. 
     */
    public UserFlow() {
        state=State.UNKNOWN;
        u=null;
    }
	
    public State getState() {
		return state;
	}
	
    public void register(String nom, String prenom, String email, String password){
    	// Assuming state=UNKNOWN - TODO: add a check
    	if(g.isLoginUsed(email)){
    		// The username is already used
    		state=State.USERNAME_USED;
    	}
    	else{
    		g.registerUser(nom, prenom, email, password, 1);
    		state=State.REGISTERED; 
    		// We could return right here
    		// Instead, we proceed with login
            login(email, password);
            
    	}
    }
	
    public void login(String email, String password){
    	u=g.checkLogin(email, password);
    	if(u==null){
    		state=State.LOGIN_FAILURE;
    	}else{
    		state=State.LOGGED_IN;
    	}
    }

    
    public void logout(){
    	u=null;
    	state=State.UNKNOWN;
    }
    
    
    
    public User getU() {
		return u;
	}
    
    
}
