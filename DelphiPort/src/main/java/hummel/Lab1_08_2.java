package main.java.hummel;

public class Lab1_08_2 {
	public static void main(String[] args) {
		int[][] matrix = { { 8, 12, 90, 34, -56, 90, 10, -3, -10, 0 }, { 17, 29, 10, -8, 76, -20, 76, 82, 44, 13 }, { 80, 13, 72, 44, -6, 51, -99, 88, 12, -90 }, { 0, 12, -4, 14, 10, 67, 30, 5, 50, 33 }, { 99, 88, 77, 66, 55, 44, 33, 22, 11, 0 }, { 29, 57, 82, 5, 24, -2, -23, 10, 74, 84 }, { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 }, { 92, 57, 5, 1, 13, 14, 66, 21, 34, 20 }, { 3, 15, 42, 33, 12, 8, 9, 10, 2, 50 }, };
		long[] products = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		/* Собственно, сортировка внутри столбцов */
		int buffer;
		long longBuffer;
		boolean isSorted;
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 9 - 1; k++) {
				isSorted = true;
				for (int i = 0; i < 9 - 1 - k; i++) {
					if (matrix[i][j] > matrix[i + 1][j]) {
						isSorted = false;
						buffer = matrix[i][j];
						matrix[i][j] = matrix[i + 1][j];
						matrix[i + 1][j] = buffer;
					}
				}
				if (isSorted) {
					break;
				}
			}
		}

		/* Собственно, сортировка самих столбцов меж собою */
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 9; i++) {
				if (matrix[i][j] % 2 == 0) {
					products[j] *= matrix[i][j];
				}
			}
		}

		for (int k = 0; k < 9 - 1; k++) {
			isSorted = true;
			for (int j = 0; j < 9 - 1 - k; j++) {
				if (products[j] > products[j + 1]) {
					isSorted = false;
					for (int i = 0; i < 9; i++) {
						buffer = matrix[i][j + 1];
						matrix[i][j + 1] = matrix[i][j];
						matrix[i][j] = buffer;
					}
					longBuffer = products[j + 1];
					products[j + 1] = products[j];
					products[j] = longBuffer;
				}
			}
			if (isSorted) {
				break;
			}
		}

		/* Вывод */
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println("");
		}
		System.out.println("----");

		for (int i = 0; i < 10; i++) {
			System.out.printf("%13d", products[i]);
		}
	}
}