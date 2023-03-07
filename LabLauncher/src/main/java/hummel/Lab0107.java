package hummel;

import java.util.*;

public class Lab0107 {
	public static Scanner input = new Scanner(System.in);

	public static Set<Character> sogl = new HashSet<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z'));
	public static Set<Character> glas = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

	public static void launch() {
		System.out.println("Enter the string: ");
		String str = input.nextLine();

		String newStr = str.replace(",", "").replace(".", "") + " ";

		while (newStr.contains("  ")) {
			newStr = newStr.replace("  ", " ");
		}

		String[] strList = newStr.split(" ");
		int last = strList.length - 1;

		for (String s : strList) {
			if (!Objects.equals(s, strList[last]) && sogl.contains(s.charAt(s.length() - 1)) && glas.contains(s.charAt(0))) {
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}
}