package main.java.hummel;

import java.util.*;

public class HummelLib {
	public static void sort(int arr[], int arrSize) {
		for (int i = 0; i < arrSize - 1; i++) {
			for (int j = 0; j < arrSize - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

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
}