package main.java.hummel;

import java.util.*;

public class Lab0108 {
	public static Random random = new Random();

	public static void launch() {
		int[][] matrix = new int[10][10];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = random.nextInt(10);
			}
		}

		for (int j = 0; j < 10; j++) {
			matrix[9][j] = 0;
		}

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 9; i++) {
				if (matrix[i][j] % 2 == 0) {
					matrix[9][j] += matrix[i][j];
				}
			}
		}

		printMatrix(matrix);

		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 9 - 1; k++) {
				for (int i = 0; i < 9 - 1 - k; i++) {
					if (matrix[i][j] > matrix[i + 1][j]) {
						int temp = matrix[i][j];
						matrix[i][j] = matrix[i + 1][j];
						matrix[i + 1][j] = temp;
					}
				}
			}
		}

		printMatrix(matrix);

		for (int k = 0; k < 9 - 1; k++) {
			for (int j = 0; j < 9 - 1 - k; j++) {
				if (matrix[9][j] > matrix[9][j + 1]) {
					for (int i = 0; i < 10; i++) {
						int temp = matrix[i][j];
						matrix[i][j] = matrix[i][j + 1];
						matrix[i][j + 1] = temp;
					}
				}
			}
		}
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] arr) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		for (int j = 0; j < 10; j++) {
			System.out.printf("%3d", arr[9][j]);
		}
		System.out.println();
		System.out.println();
	}
}