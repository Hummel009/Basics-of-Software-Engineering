package app;

import java.sql.*;
import java.util.*;

public class MySQLAppRepository {
	public static final String APP_MYSQL_DATABASE_URL = "jdbc:mysql://localhost/tanya009";
	public static final String APP_MYSQL_DATABASE_USER = "Hummel009";
	public static final String APP_MYSQL_DATABASE_PASS = "amogus";
	public static final String INSERT_MYSQL = "INSERT INTO messages (message) VALUES (?)";
	public static final String SELECT_MYSQL = "SELECT message FROM messages ORDER BY id DESC LIMIT 1";

	public static void saveToDB(List<String> users) {
		String usr = users.toString();
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_MYSQL);
			statement.setString(1, usr);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Данные успешно добавлены в базу данных.");
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Ошибка при работе с базой данных: " + e.getMessage());
		}
	}

	public static List<String> getFromDB() {
		String usr = null;
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_MYSQL);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				usr = resultSet.getString("message");
			} else {
				System.out.println("База данных пуста.");
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Ошибка при работе с базой данных: " + e.getMessage());
		}
		usr = usr.substring(1, usr.length() - 1);
		String[] userListAsArray = usr.split(", ");
		ArrayList<String> userList = new ArrayList<>(Arrays.asList(userListAsArray));
		return userList;
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(APP_MYSQL_DATABASE_URL, APP_MYSQL_DATABASE_USER, APP_MYSQL_DATABASE_PASS);
	}

	public static class UsersTable {
		public static final String TABLE_NAME = "users";
		public static final String COLUMN_NAME = "name";
	}

}
