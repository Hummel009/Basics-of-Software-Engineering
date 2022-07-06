package main.java.hummel;

import java.util.*;

public class Lab2_12 {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> sus = new ArrayList<>();
		ArrayList<Integer> amogus = new ArrayList<>();

		int n = HummelLib.readNumberUntilNoError(input, "Enter the number: ");

		for (int i = 1; i <= n; i++) {
			sus.add(i);
			amogus.add(n - i + 1);
		}

		for (Integer i: sus) {

		}
	}
}