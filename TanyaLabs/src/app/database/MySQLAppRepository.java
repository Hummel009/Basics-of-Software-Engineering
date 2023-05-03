package app.database;

import java.sql.*;
import java.util.HashMap;

public class MySQLAppRepository implements AppRepository {

	public static final String APP_MYSQL_DATABASE_USER = "Hummel009";
	public static final String APP_MYSQL_DATABASE_PASS = "amogus";
	private String databaseUrl;

	private Connection connection = null;

	public MySQLAppRepository(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	@Override
	public void addToDB(HashMap<String, String> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, String> getFromDB() {
		// TODO Auto-generated method stub
		return null;
	}

	public void test() throws SQLException {
		try {
			connection = DriverManager.getConnection(databaseUrl, APP_MYSQL_DATABASE_USER, APP_MYSQL_DATABASE_PASS);
			Statement statemant = connection.createStatement();
			statemant.setQueryTimeout(1000);
			
			ResultSet rs = statemant.executeQuery(
						"select * from " + MySQLContract.UsersTAble.TABLE_NAME + ";"
			);
			while (rs.next()) {
				String name = rs.getString(MySQLContract.UsersTAble.COLUMN_NAME);
				String password = rs.getString(MySQLContract.UsersTAble.COLUMN_PASSWORD);
				System.out.println("name: " + name + ", password: " + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
