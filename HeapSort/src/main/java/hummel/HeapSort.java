package main.java.hummel;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {8, 4, 8, 13, 1, 10, 9, 5, 7, 6, 11, 14, 2, 12, 15};
		
		System.out.println("Start array is");
		printArray(arr);

		HeapSort ob = new HeapSort();
		ob.sort(arr);
		
		System.out.println("Final array is");
		printArray(arr);
	}

	/* ��������������� ������� ��� ������ �� ����� ������� ������� n */
	static void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// ��������� ��� �������������� � �������� ���� ��������� � �������� ����� i, ��� �������� �������� � arr[]. n - ������ ����
	void heapify(int[] arr, int n, int i) {
		int max = i; // �������������� ���������� ������� ��� ������
		int l = 2 * i + 1; // ����� = 2*i + 1
		int r = 2 * i + 2; // ������ = 2*i + 2
		boolean flag = true;

		System.out.println("I = " + Integer.toString(i) + "; Arr[I] = " + Integer.toString(arr[i]));
		System.out.println("L = " + Integer.toString(l) + "; R = " + Integer.toString(r) + "; Max = " + Integer.toString(max));
		if (l < n && r < n) {
			System.out.println("Arr[L] = " + Integer.toString(arr[l]) + "; Arr[R] = " + Integer.toString(arr[r]) + "; Arr[Max] = " + Integer.toString(arr[max]));
		} else if (l >= n && r < n) {
			System.out.println("L >= " + Integer.toString(n));
			flag = false;
		} else if (r >= n && l < n) {
			System.out.println("R >= " + Integer.toString(n));
			flag = false;
		} else {
			System.out.println("L >= " + Integer.toString(n) + "; R >= " + Integer.toString(n));
			flag = false;
		}
		
		// ���� ����� �������� ������� ������ �����
		if (l < n && arr[l] > arr[max]) {
			System.out.println("Arr[L] > Arr[Max] => Max = L = " + Integer.toString(l) + "; Arr[Max] = " + Integer.toString(arr[l]));
			max = l;
		} else if (flag){
			System.out.println("Arr[L] < Arr[Max]");
		}

		// ���� ������ �������� ������� ������, ��� ����� ������� ������� �� ������ ������
		if (r < n && arr[r] > arr[max]) {
			System.out.println("Arr[R] > Arr[Max] => Max = R = " + Integer.toString(r) + "; Arr[Max] = " + Integer.toString(arr[r]));
			max = r;
			System.out.println("Arr[Max] = " + Integer.toString(arr[max]));
		} else if (flag){
			System.out.println("Arr[R] < Arr[Max]");
		}
		
		// ���� ����� ������� ������� �� ������
		if (max != i) {
			System.out.println("Max <> I => Swap(Arr[I], Arr[Max])");
			int swap = arr[i];
			arr[i] = arr[max];
			arr[max] = swap;
			printArray(arr);
			// ���������� ����������� � �������� ���� ���������� ���������
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
		// ���������� ���� (�������������� ������)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
			printArray(arr);
			System.out.println();
		}
		System.out.println();
		System.out.println("Taking elements");

		// ���� �� ������ ��������� �������� �� ����
		for (int i = n - 1; i >= 0; i--) {
			// ���������� ������� ������ � �����
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			System.out.println("N = " + Integer.toString(i) + "; Swap(Arr[0], Arr[N])");
			System.out.println("Arr[0] = " + Integer.toString(arr[0]) + "; Arr[N] = " + Integer.toString(arr[i]));
			printArray(arr);
			heapify(arr, i, 0);
			printArray(arr);
			System.out.println();
		}
	}
}