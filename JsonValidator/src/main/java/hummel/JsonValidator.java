package hummel;

import java.io.*;

public class JsonValidator {
	public static int cur;
	public static Tokens[] arr;

	public static boolean array() {
		return term(Tokens.ALEFT) && term(Tokens.ARIGHT) || term(Tokens.ALEFT) && elements() && term(Tokens.ARIGHT);
	}

	public static boolean element() {
		return value();
	}

	public static boolean elements() {
		return element() || element() && term(Tokens.KOSKA) && elements();
	}

	public static boolean json() {
		return element();
	}

	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("amogus.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.lineSeparator();
		try {
			while (true) {
				assert reader != null;
				if ((line = reader.readLine()) == null) break;
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String input = stringBuilder.toString();
		System.out.printf("%s", input);
		input = input.replace("\t", "").replace("\r", "").replace("\n", "").replace(" ", "");
		int c = 0;
		int a;
		arr = new Tokens[input.length()];
		for (a = 0; a < input.length(); a++) {
			String temp = input.substring(0, a + 1);
			for (Tokens token : Tokens.values()) {
				if (temp.equals(token.getS())) {
					System.out.printf("Added %s\n", temp);
					arr[c] = token;
					c++;
					input = input.substring(a + 1);
					a = -1;
				}
			}
		}

		for (int i = 0; i < c; i++) {
			System.out.printf("%s ", arr[i].getS());
		}

		if (json()) {
			System.out.print("\nTrue");
		} else {
			System.out.print("\nFalse");
		}
	}

	public static boolean member() {
		return string() && term(Tokens.DWUKROP) && element();
	}

	public static boolean members() {
		return member() || member() && term(Tokens.KOSKA) && members();
	}

	public static boolean object() {
		return term(Tokens.SLEFT) && term(Tokens.SRIGHT) || term(Tokens.SLEFT) && members() && term(Tokens.SRIGHT);
	}

	public static boolean string() {
		return term(Tokens.STRING);
	}

	public static boolean term(Tokens tok) {
		if (arr[cur] == tok) {
			cur++;
			return true;
		}
		return false;
	}

	public static boolean value() {
		return object() || array() || string();
	}

	enum Tokens {
		SLEFT("{"), SRIGHT("}"), ALEFT("{"), ARIGHT("}"), STRING("\"tag\""), DWUKROP(":"), KOSKA(",");

		public final String s;

		Tokens(String s) {
			this.s = s;
		}

		public String getS() {
			return s;
		}
	}
}