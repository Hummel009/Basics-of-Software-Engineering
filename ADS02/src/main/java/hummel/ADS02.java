package main.java.hummel;

import java.util.*;

public class ADS02 {
	public static Scanner input1 = new Scanner(System.in);
	public static Scanner input11 = new Scanner(System.in);
	public static Scanner input12 = new Scanner(System.in);
	public static Scanner input13 = new Scanner(System.in);
	public static Scanner input21 = new Scanner(System.in);
	public static Scanner input22 = new Scanner(System.in);
	public static Scanner input31 = new Scanner(System.in);
	public static Scanner input32 = new Scanner(System.in);
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
		String name = input11.nextLine();
		Content cont = map.get(name);
		cont.ids.clear();
		cont.sub.ids.clear();
		System.out.println("Enter the new ids of the old object.");
		while (true) {
			int read = input12.nextInt();
			if (read == 0) break;
			cont.ids.add(read);
		}
		System.out.println("Enter the new ids of the old sub-object.");
		while (true) {
			int read = input21.nextInt();
			if (read == 0) break;
			cont.sub.ids.add(read);
		}
		Collections.sort(cont.ids);
		Collections.sort(cont.sub.ids);
	}

	private static void findObject() {
		System.out.println("Enter the name of the old object.");
		String name = input11.nextLine();
		Content cont = map.get(name);
		if (cont != null) {
			System.out.println(cont.toString());
		} else {
			System.out.println("Wrong! Enter the sub-object name then.");
			String namesub = input13.nextLine();
			for (Content c: map.values()) {
				if (c.sub.name.equals(namesub)) {
					System.out.println(c.toString());
					break;
				}
			}
		}
	}

	private static void showObjects() {
		for (Content cont: list) {
			System.out.println(cont.toString());
		}
	}

	private static void removeObject() {
		System.out.println("Enter the old name of the old object.");
		String name = input11.nextLine();
		Content cont = map.get(name);
		list.remove(cont);
		map.remove(name);
	}

	private static void addObject() {
		System.out.println("Enter the new name of the new object.");
		String name1 = input11.nextLine();
		ArrayList<Integer> ids1 = new ArrayList<>();
		System.out.println("Enter the new ids of the new object.");
		while (true) {
			int read = input12.nextInt();
			if (read == 0) break;
			ids1.add(read);
		}
		Collections.sort(ids1);

		System.out.println("Enter the new name of the new sub-object.");
		String name2 = input21.nextLine();
		ArrayList<Integer> ids2 = new ArrayList<>();
		System.out.println("Enter the new ids of the new sub-object.");
		while (true) {
			int read = input22.nextInt();
			if (read == 0) break;
			ids2.add(read);
		}
		Collections.sort(ids2);

		System.out.println("Enter the new name of the new sub-object.");
		String name3 = input31.nextLine();
		ArrayList<Integer> ids3 = new ArrayList<>();
		System.out.println("Enter the new ids of the new sub-object.");
		while (true) {
			int read = input32.nextInt();
			if (read == 0) break;
			ids3.add(read);
		}
		Collections.sort(ids3);

		list.add(new Content(name1, ids1, new Content(name2, ids2, new Content(name3, ids3))));
		map.put(name1, new Content(name1, ids1, new Content(name2, ids2, new Content(name3, ids3))));
	}
}