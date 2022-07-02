package main.java.hummel;

import java.util.Scanner;

public class Lab1_02 {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 0;
		boolean error;
		do {
			error = false;
			System.out.print("Enter the quantity of numbers: ");
			try {
				n = input.nextInt();
			} catch (NumberFormatException e) {
				error = true;
			}
		} while (error);

		int[] arr = new int[n];

		for (int i = 0; i <= n - 1; i++) {
			do {
				error = false;
				System.out.print("Enter the element: ");
				try {
					arr[i] = input.nextInt();
					if (arr[i] < 0) {
						arr[i] *= -1;
					}
				} catch (NumberFormatException e) {
					error = true;
				}
			} while (error);
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