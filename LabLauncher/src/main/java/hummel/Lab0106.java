package hummel;

import java.util.*;

public class Lab0106 {
	public static Scanner input = new Scanner(System.in);
	public static Map<Month, Integer> daysSinceNY = new EnumMap<>(Month.class);
	public static Map<Month, Integer> monthCapacity = new EnumMap<>(Month.class);

	static {
		daysSinceNY.put(Month.JAN, 0);
		daysSinceNY.put(Month.FEB, 31);
		daysSinceNY.put(Month.MAR, 59);
		daysSinceNY.put(Month.APR, 90);
		daysSinceNY.put(Month.MAY, 120);
		daysSinceNY.put(Month.JUN, 151);
		daysSinceNY.put(Month.JUL, 181);
		daysSinceNY.put(Month.AUG, 212);
		daysSinceNY.put(Month.SEP, 243);
		daysSinceNY.put(Month.OCT, 273);
		daysSinceNY.put(Month.NOV, 304);
		daysSinceNY.put(Month.DEC, 334);

		monthCapacity.put(Month.JAN, 31);
		monthCapacity.put(Month.FEB, 28);
		monthCapacity.put(Month.MAR, 31);
		monthCapacity.put(Month.APR, 30);
		monthCapacity.put(Month.MAY, 31);
		monthCapacity.put(Month.JUN, 30);
		monthCapacity.put(Month.JUL, 31);
		monthCapacity.put(Month.AUG, 31);
		monthCapacity.put(Month.SEP, 30);
		monthCapacity.put(Month.OCT, 31);
		monthCapacity.put(Month.NOV, 30);
		monthCapacity.put(Month.DEC, 31);
	}

	public static int readln(Scanner input, String message) {
		int n = 0;
		boolean error;
		do {
			error = false;
			System.out.print(message);
			try {
				n = input.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				input.next();
			}
		} while (error);
		return n;
	}

	public static void launch() {
		System.out.println("Enter the date in three steps like, 2002 07 10");
		int year;
		do {
			year = readln(input, "Enter the year: ");
		} while (year < 1);

		boolean isHigher = year % 4 == 0 && year % 100 != 0 && year % 400 == 0;

		Month month = null;
		int temp1;
		do {
			temp1 = readln(input, "Enter the month number: ");
			for (Month m : Month.values()) {
				if (m.num == temp1) {
					month = m;
					break;
				}
			}
		} while (temp1 > 12 || temp1 < 1);

		int date;
		int temp2;
		if (month == Month.FEB && isHigher) {
			temp2 = 29;
		} else {
			temp2 = monthCapacity.get(month);
		}
		do {
			date = readln(input, "Enter the day: ");
		} while (date > temp2 || date < 1);

		assert month != null;
		System.out.println(date + " " + month + " " + year);

		int result = date + daysSinceNY.get(month) + (year - 1) * 365;
		int additional = (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		if (isHigher && daysSinceNY.get(month) + date > 59) {
			additional += 1;
		}
		result += additional;
		int day = result % 7;

		Weekday weekday = null;
		for (Weekday wd : Weekday.values()) {
			if (wd.num == day) {
				weekday = wd;
				break;
			}
		}
		assert weekday != null;
		System.out.println(weekday);
	}

	public enum Month {
		JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);

		public final int num;

		Month(int i) {
			num = i;
		}
	}

	public enum Weekday {
		MON(1), TUE(2), WED(3), THI(4), FRI(5), SAT(6), SUN(0);

		public final int num;

		Weekday(int i) {
			num = i;
		}
	}
}