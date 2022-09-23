package src.main.java.hummel;

import java.util.*;

public class DelphiPortLauncher {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the lab number to launch:");
		System.out.println(">> Lab0101");
		System.out.println(">> Lab0102");
		System.out.println(">> Lab0103");
		System.out.println(">> Lab0105");
		System.out.println(">> Lab0106");
		System.out.println(">> Lab0107");
		System.out.println(">> Lab0108");
		System.out.println(">> Lab0201");
		System.out.println(">> Lab0211");
		System.out.println(">> Lab0212");
		String name;

		sus: while (true) {
			name = input.nextLine();
			if (name.equals("0101")) {
				Lab0101.launch();
			} else if (name.equals("0102")) {
				Lab0102.launch();
			} else if (name.equals("0103")) {
				Lab0103.launch();
			} else if (name.equals("0105")) {
				Lab0105.launch();
			} else if (name.equals("0106")) {
				Lab0106.launch();
			} else if (name.equals("0107")) {
				Lab0107.launch();
			} else if (name.equals("0108")) {
				Lab0108.launch();
			} else if (name.equals("0201")) {
				Lab0201.launch();
			} else if (name.equals("0208")) {
				Lab0208.launch();
			} else if (name.equals("0211")) {
				Lab0211.launch();
			} else if (name.equals("0212")) {
				Lab0212.launch();
			} else if (name.equals("exit")) {
				break sus;
			}
		}
	}
}