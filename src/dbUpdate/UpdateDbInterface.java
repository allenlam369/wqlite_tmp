package dbUpdate;

import java.sql.Connection;

import javax.persistence.EntityManager;

public interface UpdateDbInterface {
	int updateAllFromMssql(Connection con, EntityManager em, String sql);

	int incrementalUpdateFromMssql(Connection con, EntityManager em, String sql);

}