package hummel;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Belarcon {
	public static Scanner scan = new Scanner(System.in);
	public static Map<String, String> letters = new HashMap<>();

	public static void main(String[] args) {
		try {
			InputStream stream = Belarcon.class.getResourceAsStream("/resources/convert1.txt");
			assert stream != null;
			InputStreamReader streamReader = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(streamReader);
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(":");
				if (parts.length == 2) {
					letters.put(parts[0], parts[1]);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String entered;
		do {
			entered = scan.nextLine();
			entered = entered.toUpperCase();
			entered = removeNonSetCharacters(entered, letters.keySet());
			for (Entry<String, String> sus : letters.entrySet()) {
				entered = entered.replace(sus.getKey(), sus.getValue());
			}
			System.out.println(reverse(entered));
		} while (!"stop".equals(entered));
	}

	public static String removeNonSetCharacters(String input, Set<String> allowedCharacters) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			String c = String.valueOf(input.charAt(i));
			if (allowedCharacters.contains(c)) {
				result.append(c);
			}
		}
		return result.toString();
	}

	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}