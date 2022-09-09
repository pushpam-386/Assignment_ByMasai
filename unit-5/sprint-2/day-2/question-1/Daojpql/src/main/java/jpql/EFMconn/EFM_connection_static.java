package jpql.EFMconn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EFM_connection_static {
	
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory=Persistence.createEntityManagerFactory("Unit");
	}
	
	public static EntityManager getEntityMF() {
		EntityManager em=entityManagerFactory.createEntityManager();
		
		return em;
	}

}
