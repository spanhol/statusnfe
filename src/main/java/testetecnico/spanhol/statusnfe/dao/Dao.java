package testetecnico.spanhol.statusnfe.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando Spanhol
 */
public class Dao {

	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("testetecnico.spanhol_statusnfe_jar_1.0PU");

	public static void clearCache() {
		emf.getCache().evictAll();
	}
}
