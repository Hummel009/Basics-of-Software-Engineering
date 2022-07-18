package main.java.hummel;

import java.util.Scanner;

public class Lab2_08 {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int num = HummelLib.readln(input, "Enter the number: ");
		int factorial = factorial(num);
		System.out.println(factorial);
	}

	public static int factorial(int num) {
		if (num >= 1) {
			return num * factorial(num - 1);
		}
		return 1;
	}
}