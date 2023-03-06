package hummel;

import java.util.*;

public class Lab0208 {
	public static Scanner input = new Scanner(System.in);

	public static int readln(Scanner input, String message) {
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

	public static void launch() {
		int num = readln(input, "Enter the number: ");
		int factorial = factorial(num);
		System.out.println(factorial);
	}

	public static int factorial(int num) {
		if (num >= 1) {
			return num * factorial(num - 1);
		}
		return 1;
	}
}