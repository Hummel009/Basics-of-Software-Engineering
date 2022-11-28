package main.java.hummel;

import java.util.*;

public class SD01 {
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
		if (c == '\'') {
			return Types.APOSTRAF;
		}
		return Types.APPLICABLE;
	}

	public enum Types {
		APPLICABLE(0), APOSTRAF(1);

		public int integer;

		Types(int i) {
			this.integer = i;
		}

		public int getNum() {
			return integer;
		}
	}
}