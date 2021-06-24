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

			System.err.println("list size " + list.size());

			return !list.isEmpty();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
