package main.java.hummel;
import java.util.*;

public class Lab1_06_2 {
	public static void main(String[] args) {
		/* Шаг первый - ввод даты */
		Scanner in = new Scanner(System.in);
		System.out.println("Введите дату в формате ДД/ММ/ГГГГ (если до н. э., поставьте минус перед ГГГГ):");
		int[] date = Arrays.stream(in.nextLine().replaceAll("\\s","").split("/"))
                           .mapToInt(x -> Integer.parseInt(x))
                           .toArray();
		if (date[2] < 1)
			date[2] += 1; // Так как, например, 2 г. до н. э. = -1 г.
		/* Шаг второй - определяем високосные года */
		int isLeapYear = 0; // int, потому что будем прибавлять
		if (date[2] % 400 == 0 && date[1] > 2)
			isLeapYear = 1;
		else if (date[2] % 4 == 0 && date[2] % 100 != 0 && date[1] > 2)
			isLeapYear = 1;
		// ниже кол-во високосных лет от 1 г. до введённого
		int LeapYears = (int) (Math.floor((date[2]-1) / 4) - Math.floor((date[2]-1) / 100) + Math.floor((date[2]-1) / 400));

		/* Шаг третий - считаем дни с первого по введённый */
		int diiy = 0; // Прошедшие дни в введённом году (days in inputted year)
		if (date[1] > 1)  diiy += Months.JAN.getDays();
		if (date[1] > 2)  diiy += Months.FEB.getDays() - 1;
		if (date[1] > 3)  diiy += Months.MAR.getDays();
		if (date[1] > 4)  diiy += Months.APR.getDays();
		if (date[1] > 5)  diiy += Months.MAY.getDays();
		if (date[1] > 6)  diiy += Months.JUN.getDays();
		if (date[1] > 7)  diiy += Months.JUL.getDays();
		if (date[1] > 8)  diiy += Months.AUG.getDays();
		if (date[1] > 9)  diiy += Months.SEP.getDays();
		if (date[1] > 10) diiy += Months.OCT.getDays();
		if (date[1] > 11) diiy += Months.NOV.getDays();

		int allDays = (date[2]-1) * 365 + LeapYears + isLeapYear + diiy + date[0] - 1;

		/* Шаг четвёртый - определяем дни недели и выводим */
		switch (allDays % 7) {
			case 0:
				System.out.println(DaysOfWeek.MON.getName());
				break;
			case 1:
				System.out.println(DaysOfWeek.TUE.getName());
				break;
			case 2:
				System.out.println(DaysOfWeek.WED.getName());
				break;
			case 3:
				System.out.println(DaysOfWeek.THU.getName());
				break;
			case 4:
				System.out.println(DaysOfWeek.FRI.getName());
				break;
			case 5:
				System.out.println(DaysOfWeek.SAT.getName());
				break;
			case 6:
				System.out.println(DaysOfWeek.SUN.getName());
				break;
		}
	}
	public enum DaysOfWeek {
		MON("понедельник"),
		TUE("вторник"),
		WED("среда"),
		THU("четверг"),
		FRI("пятница"),
		SAT("суббота"),
		SUN("воскресенье");

		private String name;

		DaysOfWeek(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	public enum Months {
		JAN(31),
		FEB(29),
		MAR(31),
		APR(30),
		MAY(31),
		JUN(30),
		JUL(31),
		AUG(31),
		SEP(30),
		OCT(31),
		NOV(30),
		DEC(31);

		private int days;

		Months(int days) {
			this.days = days;
		}
		public int getDays() {
			return days;
		}
	}
}