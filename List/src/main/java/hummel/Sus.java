package main.java.hummel;

import java.util.*;

public class Sus {
	public static Scanner input1 = new Scanner(System.in);
	public static Scanner input2 = new Scanner(System.in);
	public static Scanner input3 = new Scanner(System.in);
	public static Scanner input4 = new Scanner(System.in);
	public static Scanner input5 = new Scanner(System.in);
	public static ArrayList<Content> list = new ArrayList<>();
	public static HashMap<String, Content> map = new HashMap<>();

	public static void printOptions() {
		System.out.println();
		System.out.println("====================");
		System.out.println();
		System.out.println("1. Add object.");
		System.out.println("2. Edit object.");
		System.out.println("3. Remove object.");
		System.out.println("4. Show objects.");
		System.out.println("5. Find object.");
		System.out.println("6. Sort by name.");
		System.out.println("7. Sort by content.");
		System.out.println("8. Close.");
		System.out.println();
		System.out.println("====================");
		System.out.println();
	}

	public static void main(String[] args) {
		sus: while (true) {
			printOptions();
			int opt = input1.nextInt();
			switch (opt) {
			case 1:
				addObject();
				break;
			case 2:
				editObject();
				break;
			case 3:
				removeObject();
				break;
			case 4:
				showObjects();
				break;
			case 5:
				findObject();
				break;
			case 6:
				sortName();
				break;
			case 7:
				sortContent();
				break;
			case 8:
				break sus;
			}
		}
	}

	private static void sortContent() {
		Comparator<Content> comparator = new Comparator<Content>() {
			@Override
			public int compare(Content o1, Content o2) {
			    return o1.ids.get(0).compareTo(o2.ids.get(0));
			}
		};
		Collections.sort(list, comparator);
		showObjects();
	}

	private static void sortName() {
		Comparator<Content> comparator = new Comparator<Content>() {
			@Override
			public int compare(Content o1, Content o2) {
			    return o1.name.compareTo(o2.name);
			}
		};
		Collections.sort(list, comparator);
		showObjects();
	}

	private static void editObject() {
		System.out.println("Enter the old name of the old object.");
		String name = input2.nextLine();
		Content cont = map.get(name);
		ArrayList<Integer> ids = new ArrayList<>();
		System.out.println("Enter the new ids of the old object.");
		for (int i = 0; i < 3; i++) {
			int read = input3.nextInt();
			ids.add(read);
		}
		ArrayList<Integer> ids2 = new ArrayList<>();
		System.out.println("Enter the new ids of the old sub-object.");
		for (int i = 0; i < 3; i++) {
			int read = input4.nextInt();
			ids.add(read);
		}
		Collections.sort(ids);
		cont.ids = ids;
		cont.sub.ids = ids2;
	}

	private static void findObject() {
		System.out.println("Enter the old name of the old object.");
		String name = input2.nextLine();
		Content cont = map.get(name);
		System.out.println(cont.toString());
	}

	private static void showObjects() {
		for (Content cont: list) {
			System.out.println(cont.toString());
		}
	}

	private static void removeObject() {
		System.out.println("Enter the old name of the old object.");
		String name = input2.nextLine();
		Content cont = map.get(name);
		list.remove(cont);
		map.remove(name);
	}

	private static void addObject() {
		System.out.println("Enter the new name of the new object.");
		String name = input2.nextLine();
		ArrayList<Integer> ids = new ArrayList<>();
		System.out.println("Enter the new ids of the new object.");
		for (int i = 0; i < 3; i++) {
			int read = input3.nextInt();
			ids.add(read);
		}

		System.out.println("Enter the new name of the new sub-object.");
		String name2 = input4.nextLine();
		ArrayList<Integer> ids2 = new ArrayList<>();
		System.out.println("Enter the new ids of the new sub-object.");
		for (int i = 0; i < 3; i++) {
			int read = input5.nextInt();
			ids.add(read);
		}
		Collections.sort(ids);
		list.add(new Content(name, ids, new SubContent(name2, ids2)));
		map.put(name, new Content(name, ids, new SubContent(name2, ids2)));
	}
}