package hummel;

import java.util.*;

public class ExamLauncher {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<String, Runnable> functions = new HashMap<>();
		functions.put("0201", hummel.Ex0201::launch);
		functions.put("0202", hummel.Ex0202::launch);
		functions.put("0203", hummel.Ex0203::launch);
		functions.put("0204", hummel.Ex0204::launch);
		functions.put("0205", hummel.Ex0205::launch);
		functions.put("0301", hummel.Ex0301::launch);
		functions.put("0302", hummel.Ex0302::launch);
		functions.put("0401", hummel.Ex0401::launch);
		functions.put("0402", hummel.Ex0402::launch);
		functions.put("0501", hummel.Ex0501::launch);
		functions.put("0502", hummel.Ex0502::launch);
		functions.put("0503", hummel.Ex0503::launch);
		functions.put("0601", hummel.Ex0601::launch);
		functions.put("0602", hummel.Ex0602::launch);
		functions.put("0603", hummel.Ex0603::launch);
		functions.put("0604", hummel.Ex0604::launch);
		functions.put("0605", hummel.Ex0605::launch);
		String command = scan.nextLine();
		if (functions.containsKey(command)) {
			functions.get(command).run();
		} else {
			System.out.println("Invalid command");
		}
	}
}