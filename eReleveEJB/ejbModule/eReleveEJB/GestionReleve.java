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
	
	
	
	
		
}
