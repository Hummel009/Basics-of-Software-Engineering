package main.java.hummel;

import java.util.*;

public class Lab1_07 {
	public static Scanner input = new Scanner(System.in);
	public static HashSet<Character> sogl = new HashSet<>();
	public static HashSet<Character> glas = new HashSet<>();

	static {
		glas.add('a');
		glas.add('e');
		glas.add('i');
		glas.add('o');
		glas.add('u');
		glas.add('y');
		sogl.add('b');
		sogl.add('c');
		sogl.add('d');
		sogl.add('f');
		sogl.add('g');
		sogl.add('h');
		sogl.add('j');
		sogl.add('k');
		sogl.add('l');
		sogl.add('m');
		sogl.add('n');
		sogl.add('p');
		sogl.add('q');
		sogl.add('r');
		sogl.add('s');
		sogl.add('t');
		sogl.add('v');
		sogl.add('w');
		sogl.add('x');
		sogl.add('z');
	}

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
			if (s != strList[last] && sogl.contains(s.charAt(s.length() - 1)) && glas.contains(s.charAt(0))) {
				System.out.print(s + " ");
			}
		}
	}
}