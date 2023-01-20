import java.util.Scanner;

public class Ex0605 {
	public static String str;
	public static Scanner sc = new Scanner(System.in);

	public static void launch() {
		str = sc.nextLine();
		int q = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < q; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();

			String sub = str.substring(start, end + 1);
			str = str.substring(0, start) + str.substring(end + 1);

			if (k == 0) {
				str = sub + str;
			} else {
				str = str.substring(0, k) + sub + str.substring(k);
			}
		}

		System.out.println(str);
	}
}