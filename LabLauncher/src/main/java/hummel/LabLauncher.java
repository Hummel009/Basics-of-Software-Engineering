package hummel;

import java.util.*;

public class LabLauncher {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<String, Runnable> functions = new HashMap<>();
		functions.put("0101", Lab0101::launch);
		functions.put("0102", Lab0102::launch);
		functions.put("0103", Lab0103::launch);
		functions.put("0105", Lab0105::launch);
		functions.put("0106", Lab0106::launch);
		functions.put("0107", Lab0107::launch);
		functions.put("0108", Lab0108::launch);
		functions.put("0201", Lab0201::launch);
		functions.put("0211", Lab0211::launch);
		functions.put("0212", Lab0212::launch);
		String command = scan.nextLine();
		if (functions.containsKey(command)) {
			functions.get(command).run();
		} else {
			System.out.println("Invalid command");
		}
	}
}