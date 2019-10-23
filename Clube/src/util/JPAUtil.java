package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	@Override
	protected void finalize() throws Throwable {
		emf.close();
		super.finalize();
	}
}
