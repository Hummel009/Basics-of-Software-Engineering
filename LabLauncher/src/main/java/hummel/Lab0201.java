package hummel;

public class Lab0201 {
	public static void launch() {
		int[][] arr1 = { { 1, -1, 0 }, { 2, 0, -1 }, { 1, 1, 1 } };
		int[][] arr2 = { { 5, 3, 1 }, { -1, 2, 0 }, { -3, 0, 0 } };

		print(arr1);
		System.out.println();
		print(arr2);
		System.out.println();

		int[][] res1 = sum(arr1, arr2);
		print(res1);
		System.out.println();

		int[][] res2 = new int[3][3];
		sum(arr1, arr2, res2);
		print(res2);
	}

	public static void print(int[][] arr) {
		for (int[] ints : arr) {
			for (int anInt : ints) {
				System.out.printf("%3d", anInt);
			}
			System.out.println();
		}
	}

	public static int[][] sum(int[][] arr1, int[][] arr2) {
		int[][] res = new int[arr1.length][arr1[1].length];

		for (int i = 1; i < arr1.length; i++) {
			for (int j = 1; j < arr1[i].length; j++) {
				res[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return res;
	}

	public static void sum(int[][] arr1, int[][] arr2, int[][] res) {
		for (int i = 1; i < arr1.length; i++) {
			for (int j = 1; j < arr1[i].length; j++) {
				res[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
	}
}