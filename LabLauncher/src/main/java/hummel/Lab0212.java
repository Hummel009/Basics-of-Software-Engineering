package hummel;

import java.util.*;

public class Lab0212 {
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
		ArrayList<Integer> sus = new ArrayList<>();
		ArrayList<Integer> amogus = new ArrayList<>();

		int n = readln(input, "Enter the number: ");

		for (int i = 1; i <= n; i++) {
			sus.add(i);
			amogus.add(n - i + 1);
		}

		Iterator<Integer> iter1 = sus.iterator();
		Iterator<Integer> iter2 = amogus.iterator();

		int result = 1;
		while (iter1.hasNext() && iter2.hasNext()) {
			result *= iter1.next() + iter2.next();
		}

		System.out.println(result);
	}
}