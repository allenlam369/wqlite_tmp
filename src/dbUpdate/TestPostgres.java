package dbUpdate;

import java.util.List;

import javax.persistence.EntityManager;

import model.Rstation;

public class TestPostgres {
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) {
		em.getTransaction().begin();

		String tableName = "rstation";
		String idName = "site_id";
		if (isExist(tableName, idName, 1452)) {
			System.out.println("row exists");
		}

		else {
			System.out.println("row does not exist");
		}

		em.close();
	}

	private static boolean isExist(String tableName, String idName, long id) {
		try {
			String sql = "SELECT e.siteId FROM Rstation e WHERE e.siteId = :id";

			List<Rstation> list = em.createQuery(sql).setParameter("id", id).getResultList();


//			javax.persistence.TypedQuery<Rstation> q = em.createNamedQuery("Rstation.findAll", Rstation.class);
//			List<Rstation> list = q.getResultList();

			System.err.println("list size " + list.size());

//			@SuppressWarnings({ "rawtypes" })
//			List list = q.getResultList();

			return !list.isEmpty();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
