package app.database;

import java.util.HashMap;

public interface AppRepository {

	void addToDB(HashMap<String, String> map);

	HashMap<String, String> getFromDB();
}
