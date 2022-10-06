package main.java.hummel;

import java.util.*;

import main.java.hummel.Room.*;

public class ADS01 {
	public static Room rm;
	public static Scanner input = new Scanner(System.in);
	public static String color;
	public static String glowing;
	public static String direct;
	public static String environment;
	public static RoomType type;
	public static WindowType wtype;

	public static void main(String[] args) {
		System.out.println("─────────────────────────────────────────────────────────────────────────");
		System.out.println("─██████──────────██████─██████████████─██████████████████─██████████████─");
		System.out.println("─██░░██████████████░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─");
		System.out.println("─██░░░░░░░░░░░░░░░░░░██─██░░██████░░██─████████████░░░░██─██░░██████████─");
		System.out.println("─██░░██████░░██████░░██─██░░██──██░░██─────────████░░████─██░░██─────────");
		System.out.println("─██░░██──██░░██──██░░██─██░░██████░░██───────████░░████───██░░██████████─");
		System.out.println("─██░░██──██░░██──██░░██─██░░░░░░░░░░██─────████░░████─────██░░░░░░░░░░██─");
		System.out.println("─██░░██──██████──██░░██─██░░██████░░██───████░░████───────██░░██████████─");
		System.out.println("─██░░██──────────██░░██─██░░██──██░░██─████░░████─────────██░░██─────────");
		System.out.println("─██░░██──────────██░░██─██░░██──██░░██─██░░░░████████████─██░░██████████─");
		System.out.println("─██░░██──────────██░░██─██░░██──██░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─");
		System.out.println("─██████──────────██████─██████──██████─██████████████████─██████████████─");
		System.out.println("─────────────────────────────────────────────────────────────────────────");

		Floors floor = null;
		do {
			System.out.println("Enter the color of the floor: ");
			String color = input.nextLine();
			floor = Floors.forName(color);
		} while (floor == null);

		System.out.println("Enter the color of the room (green, black, grey): ");
		color = input.nextLine();

		System.out.println("Enter the glowing of the room (true/false): ");
		glowing = input.nextLine();

		System.out.println("Enter the glowing type of the room (true/false): ");
		direct = input.nextLine();

		System.out.println("Enter the med environment of the room (true/false): ");
		environment = input.nextLine();

		do {
			System.out.println("Enter the room type of the room: ");
			String r = input.nextLine();
			type = RoomType.forName(r);
		} while (type == null);

		do {
			System.out.println("Enter the window type of the room: ");
			String w = input.nextLine();
			wtype = WindowType.forName(w);
		} while (wtype == null);

		rm = new Room(color, glowing, direct, environment, type, wtype);

		int i = 0;

		Room room[] = new Room[216];

		Room blackRoom = new Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.SMALL);
		Room lab = new Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.BIG);
		Room prison = new Room("green", "false", "false", "false", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "true", "true", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "true", "true", "true", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "false", "true", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "false", "true", "true", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "true", "false", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "true", "false", "true", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "false", "false", "true", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "false", "false", "true", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "true", "true", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "true", "true", "false", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "false", "true", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "false", "true", "false", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "true", "false", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "true", "false", "false", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("black", "false", "false", "false", RoomType.ROOM, WindowType.BIG);
		room[i++] = new Room("green", "false", "false", "false", RoomType.ROOM, WindowType.BIG);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "true", "true", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "true", "true", "true", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "false", "true", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "false", "true", "true", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "true", "false", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "true", "false", "true", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "false", "false", "true", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "false", "false", "true", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "true", "true", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "true", "true", "false", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "false", "true", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "false", "true", "false", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "true", "false", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "true", "false", "false", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("black", "false", "false", "false", RoomType.CORRIDOR, WindowType.BIG);
		room[i++] = new Room("green", "false", "false", "false", RoomType.CORRIDOR, WindowType.BIG);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "true", "true", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "true", "true", "true", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "false", "true", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "false", "true", "true", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "true", "false", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "true", "false", "true", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "false", "false", "true", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "false", "false", "true", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "true", "true", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "true", "true", "false", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "false", "true", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "false", "true", "false", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "true", "false", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "true", "false", "false", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("black", "false", "false", "false", RoomType.OTSEK, WindowType.BIG);
		room[i++] = new Room("green", "false", "false", "false", RoomType.OTSEK, WindowType.BIG);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "true", "true", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "true", "true", "true", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "false", "true", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "false", "true", "true", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "true", "false", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "true", "false", "true", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "false", "false", "true", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "false", "false", "true", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "true", "true", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "true", "true", "false", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "false", "true", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "false", "true", "false", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "true", "false", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "true", "false", "false", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("black", "false", "false", "false", RoomType.ROOM, WindowType.SMALL);
		room[i++] = new Room("green", "false", "false", "false", RoomType.ROOM, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "true", "true", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "true", "true", "true", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "false", "true", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "false", "true", "true", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "true", "false", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "true", "false", "true", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "false", "false", "true", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "false", "false", "true", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "true", "true", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "true", "true", "false", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "false", "true", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "false", "true", "false", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "true", "false", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "true", "false", "false", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("black", "false", "false", "false", RoomType.CORRIDOR, WindowType.SMALL);
		room[i++] = new Room("green", "false", "false", "false", RoomType.CORRIDOR, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "true", "true", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "true", "true", "true", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "false", "true", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "false", "true", "true", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "true", "false", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "true", "false", "true", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "false", "false", "true", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "false", "false", "true", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "true", "true", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "true", "true", "false", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "false", "true", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "false", "true", "false", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "true", "false", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "true", "false", "false", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("black", "false", "false", "false", RoomType.OTSEK, WindowType.SMALL);
		room[i++] = new Room("green", "false", "false", "false", RoomType.OTSEK, WindowType.SMALL);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "true", "true", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "true", "true", "true", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "false", "true", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "false", "true", "true", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "true", "false", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "true", "false", "true", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "false", "false", "true", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "false", "false", "true", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "true", "true", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "true", "true", "false", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "false", "true", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "false", "true", "false", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "true", "false", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "true", "false", "false", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("black", "false", "false", "false", RoomType.ROOM, WindowType.NONE);
		room[i++] = new Room("green", "false", "false", "false", RoomType.ROOM, WindowType.NONE);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "true", "true", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "true", "true", "true", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "false", "true", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "false", "true", "true", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "true", "false", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "true", "false", "true", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "false", "false", "true", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "false", "false", "true", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "true", "true", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "true", "true", "false", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "false", "true", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "false", "true", "false", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "true", "false", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "true", "false", "false", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("black", "false", "false", "false", RoomType.CORRIDOR, WindowType.NONE);
		room[i++] = new Room("green", "false", "false", "false", RoomType.CORRIDOR, WindowType.NONE);

		room[i++] = new Room("grey", "true", "true", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "true", "true", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "true", "true", "true", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "false", "true", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "false", "true", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "false", "true", "true", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "true", "false", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "true", "false", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "true", "false", "true", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "false", "false", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "false", "false", "true", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "false", "false", "true", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "true", "true", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "true", "true", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "true", "true", "false", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "false", "true", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "false", "true", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "false", "true", "false", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "true", "false", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "true", "false", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "true", "false", "false", RoomType.OTSEK, WindowType.NONE);

		room[i++] = new Room("grey", "false", "false", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("black", "false", "false", "false", RoomType.OTSEK, WindowType.NONE);
		room[i++] = new Room("green", "false", "false", "false", RoomType.OTSEK, WindowType.NONE);

		System.out.println("|=======================================|");
		System.out.println("|==============  GO BACK  ==============|");
		System.out.println("|=======================================|");
		System.out.println();
		switch (floor) {
		case ONE:
			if (compareRooms(rm, blackRoom)) {
				System.out.println("You are on the first floor.\n" + "Turn left and go " + 12 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 50 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 18 + " steps.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 48 + " steps.\n" + "Then use lift." + "Turn to the angle of " + 45 + " degrees to left and go " + 50 + " metres.\n");
			} else {
				Random rand = new Random();
				int left1 = rand.nextInt(20) + 20;
				int left2 = rand.nextInt(20) + 20;
				int right = rand.nextInt(20) + 20;

				System.out.println("You are on the second floor.\n" + "Turn left and go " + left1 + " steps.\n" + "Then turn right and go " + right + " steps.\n" + "Turn left and go " + left2 + " steps.\n" + "Then use lift.\n");
				drawAsAMatrix(left1, right, left2);
			}
			break;
		case TWO:
			if (compareRooms(rm, lab)) {
				System.out.println("You are on the second floor.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Then use lift.\n" + "You are on the first floor.\n" + "Turn left and go " + 12 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 50 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 18 + " steps.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 48 + " steps.\n" + "Then use lift." + "Turn to the angle of " + 45 + " degrees to left and go " + 50 + " metres.\n");
			} else {
				Random rand = new Random();
				int left1 = rand.nextInt(20) + 20;
				int left2 = rand.nextInt(20) + 20;
				int right = rand.nextInt(20) + 20;

				System.out.println("You are on the second floor.\n" + "Turn left and go " + left1 + " steps.\n" + "Then turn right and go " + right + " steps.\n" + "Turn left and go " + left2 + " steps.\n" + "Then use lift.\n");
				drawAsAMatrix(left1, right, left2);
			}
			break;
		case THREE:
			if (compareRooms(rm, prison)) {
				System.out.println("You are on the third floor.\n" + "Turn left and go " + 8 + " steps.\n" + "Then use lift.\n" + "You are on the second floor.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Then use lift.\n" + "You are on the first floor.\n" + "Turn left and go " + 12 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 50 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 18 + " steps.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 48 + " steps.\n" + "Then use lift.\n" + "Turn to the angle of " + 45 + " degrees to left and go " + 50 + " metres.\n");
			} else {
				Random rand = new Random();
				int left1 = rand.nextInt(20) + 20;
				int left2 = rand.nextInt(20) + 20;
				int right = rand.nextInt(20) + 20;

				System.out.println("You are on the second floor.\n" + "Turn left and go " + left1 + " steps.\n" + "Then turn right and go " + right + " steps.\n" + "Turn left and go " + left2 + " steps.\n" + "Then use lift.\n");
				drawAsAMatrix(left1, right, left2);
			}
		}
	}

	public static boolean compareRooms(Room rm1, Room rm2) {
		if (rm1.direct.equals(rm2.direct) && rm1.color.equals(rm2.color)) {
			if (rm1.glowing.equals(rm2.glowing)) {
				if (rm1.environment.equals(rm2.environment)) {
					if (rm1.rtype.getName().equals(rm2.rtype.getName())) {
						if (rm1.wtype.getName().equals(rm2.wtype.getName())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void drawAsAMatrix(int left1, int right, int left2) {
		int lLeft1 = left1 / 5;
		int lRight = right / 5;
		int lLeft2 = left2 / 5;
		String matr[][] = new String[26][26];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				matr[i][j] = " ";
			}
		}
		int x = 12;
		int y = 12;
		while (lLeft1 > 0) {
			matr[x][y] = "G";
			x--;
			lLeft1--;
		}
		while (lRight > 0) {
			matr[x][y] = "G";
			y--;
			lRight--;
		}
		while (lLeft2 > 0) {
			matr[x][y] = "G";
			x++;
			lLeft2--;
		}
		matr[x][y] = "L";
		matr[12][12] = "S";
		System.out.println("|=======================================|");
		System.out.println("|===============  ROUTE  ===============|");
		System.out.println("|=======================================|");
		System.out.println();
		System.out.println("==========================");
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				System.out.print(matr[i][j]);
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

	public enum Floors {
		ONE("black"), TWO("grey"), THREE("green");

		private String name;
		Floors(String fName) {
			name = fName;
		}

		public String getName() {
			return name;
		}

		public static Floors forName(String search) {
			for (Floors color : Floors.values()) {
				if (search.equals(color.getName())) {
					return color;
				}
			}
			return null;
		}
	}
}