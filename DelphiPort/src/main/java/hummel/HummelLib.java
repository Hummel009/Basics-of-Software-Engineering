package main.java.hummel;

import java.util.*;

public class HummelLib {
	public static int readNumberUntilNoError(Scanner input, String message) {
		int n = 0;
		boolean error;
		do {
			error = false;
			System.out.print(message);
			try {
				n = input.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				input.next();
			}
		} while (error);
		return n;
	}
}