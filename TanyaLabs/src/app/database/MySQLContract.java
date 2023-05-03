package app.database;

public class MySQLContract {

	// public static final String APP_MYSQL_DATABASE_URL =
	// "jdbc:mysql://D:/Eclipse/Java Projects/TanyaLabs/bd/test_users.sql";
	public static final String APP_MYSQL_DATABASE_URL = "jdbc:mysql://localhost/test";

	public static class UsersTAble {

		public static final String TABLE_NAME = "users";
		public static final String COLUMN_NAME = "name";
		public static final String COLUMN_PASSWORD = "password";
	}
}
