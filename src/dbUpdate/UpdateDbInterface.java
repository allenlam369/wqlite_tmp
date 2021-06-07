package dbUpdate;

import java.sql.Connection;

import javax.persistence.EntityManager;

public interface UpdateDbInterface {
	int getAllFromMssql(Connection con, EntityManager em, String dbName);
}