import java.util.*;

public class Ex0201 {
	public static HashMap<Character, Character> pairBrace = new HashMap<>();
	public static Scanner scanner = new Scanner(System.in);

	static {
		pairBrace = new HashMap<>();
		pairBrace.put(')', '(');
		pairBrace.put(']', '[');
		pairBrace.put('}', '{');
	}

	public static void launch() {
		char[] input = scanner.next().toCharArray();
		Deque<Pair> bracers = new ArrayDeque<>();
		int errorPosition = -1;

		for (int i = 0; i < input.length; i++) {
			char inputChar = input[i];

			if (inputChar == '(' || inputChar == '[' || inputChar == '{') {
				bracers.push(new Pair(inputChar, i));
			} else if (inputChar == ')' || inputChar == ']' || inputChar == '}') {
				if (bracers.isEmpty() || bracers.peek().character != pairBrace.get(inputChar)) {
					errorPosition = i + 1;
					break;
				}
				bracers.pop();
			}

			if (i + 1 == input.length && !bracers.isEmpty()) {
				errorPosition = bracers.peek().position + 1;
				break;
			}
		}

		if (errorPosition != -1) {
			System.out.println(errorPosition);
		} else {
			System.out.println("Success");
		}

	}

	public static class Pair {
		public char character;
		public int position;

		public Pair(char character, int position) {
			this.character = character;
			this.position = position;
		}
	}
}