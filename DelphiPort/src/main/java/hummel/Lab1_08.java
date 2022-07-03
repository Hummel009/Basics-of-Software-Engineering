package main.java.hummel;

import java.util.Scanner;

public class Lab1_08 {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[9][10];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = HummelLib.readNumberUntilNoError(input, "Enter the element: ");
			}
		}

	}
}