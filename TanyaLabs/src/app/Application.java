package app;

import java.util.*;

import app.entities.*;

public class Application {
	private static final String FACILITIES = "0 -> create new user;\r\n" + "1 -> Choose payment method;\r\n" + "2 -> Choose user;\r\n" + "3 -> Cancel user selection;\r\n" + "4 -> Print users;\r\n" + "5 -> Print selected user;\r\n" + "6 -> Print current user payment methods;\r\n" + "7 -> Search by payment method;\r\n" + "8 -> History;\r\n" + "99 -> Exit;\r\n";
	private static final String INPUT_ERROR = "Incorrect input;";
	private static final String EXIT = "Bye;";
	private static final String ADD_USER = "Username:";
	private static final String ADD_USER_EXCEPTION = "User not added;";
	private static final String USER_ADDED = "User added;";
	private static final String USER_NOT_SELECTED = "Error. User not selected;";
	private static final String USER_SELECTED = "User selected;";
	private final Scanner console = new Scanner(System.in);
	private ApplicationUserImpl currentUser = new ApplicationUserImpl("");
	private final List<ApplicationUserImpl> users = new ArrayList<>();

	private void handleAddUser() {
		System.out.println(ADD_USER);
		try {
			String name = console.nextLine();
			ApplicationUserImpl user = new ApplicationUserImpl(name);
			while (user.name.isEmpty()) {
				name = console.nextLine();
				user = new ApplicationUserImpl(name);
			}
			users.add(user);
			Main.userNames.add(name);
		} catch (Exception e) {
			System.out.println(ADD_USER_EXCEPTION);
			throw e;
		}
		System.out.println(USER_ADDED);
	}

	private void handleCanselUserSelection() {
		users.add(currentUser);
		currentUser = new ApplicationUserImpl("");
	}

	private void handleChoosePaymentMethod() {
		if (currentUser.name.isEmpty()) {
			System.out.println(USER_NOT_SELECTED);
		} else {
			System.out.println("0 -> add PayPal\r\n" + "1-> add Erip\r\n" + "2 -> add Card\r\n");
			switch (console.nextInt()) {
			case 0: {
				System.out.println("Owner id: ");
				String ownerId = console.nextLine();
				while (ownerId.isEmpty()) {
					ownerId = console.nextLine();
				}
				System.out.println("Receiver id:");
				String receiverId = console.nextLine();
				while (receiverId.isEmpty()) {
					receiverId = console.nextLine();
				}
				currentUser.addPaymentMethod(new PayPalImpl().name, ownerId, receiverId);
				currentUser.usePaymentMethod(new PayPalImpl().name);
				break;
			}
			case 1: {
				System.out.println("Erip code:");
				String code = console.nextLine();
				while (code.isEmpty()) {
					code = console.nextLine();
				}
				currentUser.addPaymentMethod(new EripImpl().name, code);
				break;
			}
			case 2: {
				System.out.println("Card number:");
				String cardNumber = console.nextLine();
				while (cardNumber.isEmpty()) {
					cardNumber = console.nextLine();
				}
				currentUser.addPaymentMethod(new CardImpl().name, cardNumber);
				break;
			}
			}
		}
	}

	private void handleChooseUser() {
		System.out.println(ADD_USER);
		try {
			String name = console.nextLine();
			while (name.isEmpty()) {
				name = console.nextLine();
			}
			for (ApplicationUserImpl user : users) {
				if (Objects.equals(user.name, name)) {
					currentUser = user;
				}
			}
		} catch (Exception e) {
			System.out.println(USER_NOT_SELECTED);
			throw e;
		}
		System.out.println(USER_SELECTED);
	}

	private void handlePrintSelectedUser() {
		if ("".equals(currentUser.name)) {
			System.out.println(USER_NOT_SELECTED);
		} else {
			System.out.println(currentUser.name);
		}
	}

	private void history() {
		for (String s: Main.userNames) {
			System.out.println(s);
		}
		System.out.println();
	}

	private void handlePrintUsers() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println("[" + i + " -> " + users.get(i).name + "]");
		}
		System.out.println();
	}

	private Boolean handleUserInput() {
		System.out.println(FACILITIES);
		try {
			switch (console.nextInt()) {
			case 0:
				handleAddUser();
				break;
			case 1:
				handleChoosePaymentMethod();
				break;
			case 2:
				handleChooseUser();
				break;
			case 3:
				handleCanselUserSelection();
				break;
			case 4:
				handlePrintUsers();
				break;
			case 5:
				handlePrintSelectedUser();
				break;
			case 6:
				printCurrentUserMethods();
				break;
			case 7:
				search();
				break;
			case 8:
				history();
				break;
			case 99:
				System.out.println(EXIT);
				return false;
			default:
				System.out.println(INPUT_ERROR);
				return true;
			}
		} catch (Exception e) {
			System.out.println(INPUT_ERROR);
		}
		return true;
	}

	private void printCurrentUserMethods() {
		System.out.println(currentUser.name + ":");
		System.out.println("   PayPal: " + currentUser.usePaymentMethod(new PayPalImpl().name));
		System.out.println("   Erip: " + currentUser.usePaymentMethod(new EripImpl().name));
		System.out.println("   Card: " + currentUser.usePaymentMethod(new CardImpl().name));
	}

	private void search() {
		if (currentUser.name.isEmpty()) {
			System.out.println(USER_NOT_SELECTED);
		} else {
			System.out.println("0 -> PayPal\r\n" + "1-> Erip\r\n" + "2 -> Card\r\n");
			switch (console.nextInt()) {
			case 0: {
				for (ApplicationUserImpl it : users) {
					if (it.paymentMethods.get(new PayPalImpl().name) != null) {
						System.out.println(it.name + " -> " + it.paymentMethods.get(new PayPalImpl().name));
					}
				}
				break;
			}
			case 1: {
				for (ApplicationUserImpl it : users) {
					if (it.paymentMethods.get(new EripImpl().name) != null) {
						System.out.println(it.name + " -> " + it.paymentMethods.get(new EripImpl().name));
					}
				}
				break;
			}
			case 2: {
				for (ApplicationUserImpl it : users) {
					if (it.paymentMethods.get(new CardImpl().name) != null) {
						System.out.println(it.name + " -> " + it.paymentMethods.get(new CardImpl().name));
					}
				}
				break;
			}
			default:
				System.out.println("Incorrect input;");
				break;
			}
		}
	}

	public void start() {
		while (handleUserInput()) {
		}
	}
}
