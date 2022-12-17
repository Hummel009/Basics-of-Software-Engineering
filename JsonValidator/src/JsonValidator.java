import java.io.*;

public class JsonValidator {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("amogus.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		try {
			while ((line = reader.readLine()) != null) {
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
		System.out.println(input);
		input = input.replaceAll(" ", "").replaceAll("\t", "");
		boolean invalid = false;
		/* FAST PREVIEW */
		if (input.contains("{") && !input.contains("}")) {
			invalid = true;
		}
		if (!invalid) {
			if (input.contains("[") && !input.contains("]")) {
				invalid = true;
			}
		}
		/* SLOWER PREVIEW */
		if (!invalid) {
			int par1 = useRecursion(input, '{', 0);
			int par2 = useRecursion(input, '}', 0);
			if ((par1 + par2) % 2 == 1) {
				invalid = true;
			}
		}
		if (!invalid) {
			int sq1 = useRecursion(input, '[', 0);
			int sq2 = useRecursion(input, ']', 0);
			if ((sq1 + sq2) % 2 == 1) {
				invalid = true;
			}
		}
		if (!invalid) {
			int k = useRecursion(input, '"', 0);
			if (k % 2 == 1) {
				invalid = true;
			}
		}
		/* MAIN PROCESS (SLOWEST) */
		if (!invalid) {
			while (input.contains("\n")) {
				int counter = 0;
				int firstRB = input.indexOf('}');
				int prevLB = 0;
				for (int i = firstRB; i > 0; i--) {
					if (input.charAt(i) == '{') {
						prevLB = i;
						break;
					}
				}
				String input1 = input.substring(0, prevLB);
				String input2 = input.substring(firstRB + 1);
				input = input1.concat("\"tag\"").concat(input2);
				if (input.contains("\"tag\"\"tag\"")) {
					invalid = true;
					break;
				}
				if (input.contains("\"tag\"\r\n\"tag\"")) {
					invalid = true;
					break;
				}
				counter++;
				if (counter > 100) {
					break;
				}
			}
		}
		/* CHECK THE RESULT */
		input = input.replaceAll(" ", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll("\n", "");
		if (!"\"tag\"".equals(input)) {
			invalid = true;
		}
		if (!invalid) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
	}

	public static int useRecursion(String someString, char searchedChar, int index) {
		if (index >= someString.length()) {
			return 0;
		}
		int count = someString.charAt(index) == searchedChar ? 1 : 0;
		return count + useRecursion(someString, searchedChar, index + 1);
	}
}