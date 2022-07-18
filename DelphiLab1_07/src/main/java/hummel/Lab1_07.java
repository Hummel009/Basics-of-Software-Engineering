package main.java.hummel;

import java.util.*;

public class Lab1_07 {
	public static Scanner input = new Scanner(System.in);

	public static HashSet<Character> sogl = new HashSet<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z'));
	public static HashSet<Character> glas = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

	public static void main(String[] args) {
		System.out.println("Enter the string: ");
		String str = input.nextLine();

		String newStr = str.replace(",", "").replace(".", "") + " ";

		while (newStr.contains("  ")) {
			newStr = newStr.replace("  ", " ");
		}

		String[] strList = newStr.split(" ");
		int last = strList.length - 1;

		for (String s : strList) {
			if (s != strList[last] && sogl.contains(s.charAt(s.length() - 1)) && glas.contains(s.charAt(0)) ) {
				System.out.print(s + " ");
			}
		}
	}
}