package main.java.hummel;

import java.util.*;

public class SD00 {
	public static boolean[] isFinalState = new boolean[] {false, false, true, false, true};
	public static int[][] transitions = new int[][] { { 0, 0, 0 }, { 0, 2, 0 }, { 0, 2, 3 }, { 0, 4, 0 }, { 0, 4, 3 } };
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			String s = scan.nextLine();
			if (s.equals("exit")) {
				break;
			}
			int state = 1;
			for (int i = 0; i < s.length(); i++) {
				state = transitions[state][getCharType(s.charAt(i)).getNum()];
			}
			boolean res = isFinalState[state];
			System.out.println(res);
		}
	}

	public static Types getCharType(char c) {
		if (Character.isDigit(c)) {
			return Types.DIGIT;
		} else if (c == '+' || c == '-' || c == '*' || c == '/') {
			return Types.OP;
		}
		return Types.NULL;
	}

	public enum Types {
		NULL(0), DIGIT(1), OP(2);

		public int integer;

		Types(int i) {
			this.integer = i;
		}

		public int getNum() {
			return integer;
		}
	}
}