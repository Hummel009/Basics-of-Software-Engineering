import java.util.Scanner;

public class Ex0202 {
	public static void launch() {
		Scanner scanner = new Scanner(System.in);
		int root = -1;
		int amogus = scanner.nextInt();
		int[] nodes = new int[amogus];

		for (int i = 0; i < nodes.length; i++) {
			int node = scanner.nextInt();
			root = node == -1 ? i : root;
			nodes[i] = node;
		}
		scanner.close();

		int maxHeight = 0;

		for (int node : nodes) {
			int parent = node;
			int height = 1;
			while (true) {
				if (parent == -1) {
					maxHeight = height > maxHeight ? height : maxHeight;
					break;
				}
				height++;
				parent = nodes[parent];
			}
		}

		System.out.println(maxHeight);
	}
}
