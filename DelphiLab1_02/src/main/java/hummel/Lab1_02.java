package main.java.hummel;

import java.util.*;

public class Lab1_02 {
	private static Scanner input = new Scanner(System.in);

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

	public static void main(String[] args) {
		int n = readln(input, "Enter the quantity of elements: ");

		int[] arr = new int[n];

		for (int i = 0; i <= n - 1; i++) {
			arr[i] = readln(input, "Enter the element: ");
			if (arr[i] < 0) {
				arr[i] *= -1;
			}
		}

		for (int i = 0; i <= n - 2; i++) {
			if (arr[i] != 0) {
				do {
					if (arr[i] < arr[i + 1]) {
						arr[i + 1] = arr[i + 1] % arr[i];
					} else {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
					}
				} while (arr[i] != 0);
			}
		}

		System.out.println("GCD is " + arr[n - 1]);
	}
}