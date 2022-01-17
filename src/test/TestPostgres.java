package test;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.EntityManagerUtil;
import model.Rstation;

public class TestPostgres {
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static Logger log = LoggerFactory.getLogger(TestPostgres.class);

	public static void main(String[] args) {
		em.getTransaction().begin();

		String tableName = "rstation";
		String idName = "site_id";
		if (isExist(tableName, idName, 1452)) {
//			System.out.println("row exists");
			log.info("row exists");
		}

		else {
			System.out.println("row does not exist");
			log.info("row does not exist");
		}

		em.close();
	}

	private static boolean isExist(String tableName, String idName, long id) {
		try {
			String sql = "SELECT e.siteId FROM Rstation e WHERE e.siteId = :id";

			@SuppressWarnings("unchecked")
			List<Rstation> list = em.createQuery(sql).setParameter("id", id).getResultList();

			System.err.println("list size " + list.size());

			return !list.isEmpty();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
