package hummel;

import java.util.*;

public class Lab0103 {
	private static final Scanner input = new Scanner(System.in);

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
		int n = readln(input, "Enter the quantity of elements: ");

		System.out.println();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = readln(input, "Enter the element: ");
		}

		HashSet<Integer> nums = new HashSet<>();
		for (int i = 0; i < n; i++) {
			nums.add(arr[i]);
		}

		System.out.println("Unique elements: " + nums);
		System.out.println("The quantity of unique elements: " + nums.size());

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j] && i != j) {
					max = arr[i];
					break;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j] && i != j && max < arr[i]) {
					max = arr[i];
				}
			}
		}
		System.out.println("Max duplicate: " + max);
	}
}