import java.sql.SQLException;

import app.database.*;

public class Main {

	public static void main(String[] args) throws SQLException {
//        new Application().start();
		MySQLAppRepository tmp = new MySQLAppRepository(MySQLContract.APP_MYSQL_DATABASE_URL);
		tmp.test();
	}
}
