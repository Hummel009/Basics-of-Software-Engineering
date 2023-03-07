package hummel;

public class HeapSort {
	void heapify(int[] arr, int n, int i) {
		int max = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		boolean flag = true;

		System.out.println("I = " + i + "; Arr[I] = " + arr[i]);
		System.out.println("L = " + l + "; R = " + r + "; Max = " + max);
		if (l < n && r < n) {
			System.out.println("Arr[L] = " + arr[l] + "; Arr[R] = " + arr[r] + "; Arr[Max] = " + arr[max]);
		} else {
			if (l >= n && r < n) {
				System.out.println("L >= " + n);
			} else if (l < n) {
				System.out.println("R >= " + n);
			} else {
				System.out.println("L >= " + n + "; R >= " + n);
			}
			flag = false;
		}

		if (l < n && arr[l] > arr[max]) {
			System.out.println("Arr[L] > Arr[Max] => Max = L = " + l + "; Arr[Max] = " + arr[l]);
			max = l;
		} else if (flag) {
			System.out.println("Arr[L] < Arr[Max]");
		}

		if (r < n && arr[r] > arr[max]) {
			System.out.println("Arr[R] > Arr[Max] => Max = R = " + r + "; Arr[Max] = " + arr[r]);
			max = r;
			System.out.println("Arr[Max] = " + arr[max]);
		} else if (flag) {
			System.out.println("Arr[R] < Arr[Max]");
		}

		if (max != i) {
			System.out.println("Max <> I => Swap(Arr[I], Arr[Max])");
			int swap = arr[i];
			arr[i] = arr[max];
			arr[max] = swap;
			printArray(arr);
			heapify(arr, n, max);
		} else {
			System.out.println("Max = I");
		}
	}

	public void sort(int[] arr) {
		int n = arr.length;

		System.out.println();
		System.out.println();
		System.out.println("Making heap");
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
			printArray(arr);
			System.out.println();
		}
		System.out.println();
		System.out.println("Taking elements");

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			System.out.println("N = " + i + "; Swap(Arr[0], Arr[N])");
			System.out.println("Arr[0] = " + arr[0] + "; Arr[N] = " + arr[i]);
			printArray(arr);
			heapify(arr, i, 0);
			printArray(arr);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = { 8, 4, 8, 13, 1, 10, 9, 5, 7, 6, 11, 14, 2, 12, 15 };

		System.out.println("Start array is");
		printArray(arr);

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Final array is");
		printArray(arr);
	}

	static void printArray(int[] arr) {
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
	}
}