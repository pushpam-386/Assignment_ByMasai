package EMF.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF_Connect {
	
	private static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("Unit");
	}
	
	public static EntityManager provideEM() {
		EntityManager em=emf.createEntityManager();
		return em;
	}

}
