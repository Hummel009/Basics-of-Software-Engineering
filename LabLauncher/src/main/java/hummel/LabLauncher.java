package hummel;

import java.util.*;

public class LabLauncher {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<String, Runnable> functions = new HashMap<>();
		functions.put("0101", hummel.Lab0101::launch);
		functions.put("0102", hummel.Lab0102::launch);
		functions.put("0103", hummel.Lab0103::launch);
		functions.put("0105", hummel.Lab0105::launch);
		functions.put("0106", hummel.Lab0106::launch);
		functions.put("0107", hummel.Lab0107::launch);
		functions.put("0108", hummel.Lab0108::launch);
		functions.put("0201", hummel.Lab0201::launch);
		functions.put("0208", hummel.Lab0208::launch);
		functions.put("0211", hummel.Lab0211::launch);
		functions.put("0212", hummel.Lab0212::launch);
		String command = scan.nextLine();
		if (functions.containsKey(command)) {
			functions.get(command).run();
		} else {
			System.out.println("Invalid command");
		}
	}
}