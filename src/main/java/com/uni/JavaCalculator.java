package main.java.com.uni;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//класс базируется на JFrame и наследует его содержимое, ActionListener отвечает за отслеживание нажатой кнопки
public class JavaCalculator implements ActionListener {
	private final JButton[] button = new JButton[50]; // все наши кнопки
	private Operation operation; // тип операции - сложение, вычитание и т.д.
	private double output; // выводимые данные
	private double input1; // вводимые данные
	private double input2; // вводимые данные
	private final JTextField outputField = new JTextField(20); // поле вывода
	private final JPanel panel = new JPanel(); // сетка из кнопок
	private int notInclude;
	private int[] exNums = { 22, 24, 25, 26, 27, 28, 29, 30, 31, 36, 37, 38, 39, 40, 41, 42 }; //айдишники кнопок в инженерной части
	boolean isExtended = false;

	public static void main(String[] arg) {
		new JavaCalculator();
	}

	public JavaCalculator() {
		JFrame frame = new JFrame("Calculator v2.0"); //создаём окно и задаём заголовок

		// создаём кнопки про помощи цикла
		for (int i = 0; i <= 49; i++) {
			button[i] = new JButton();
		}

		panel.setLayout(new GridLayout(7, 4)); // сетка из кнопок - в высоту и в ширину

		// настраиваем созданные кнопки, используя новый метод "registerButton"
		registerButton(button[13], "C");
		registerButton(button[12], "e");
		registerButton(button[11], "π");
		registerButton(button[14], "÷");

		registerButton(button[7], "7");
		registerButton(button[8], "8");
		registerButton(button[9], "9");
		registerButton(button[15], "×");

		registerButton(button[4], "4");
		registerButton(button[5], "5");
		registerButton(button[6], "6");
		registerButton(button[16], "−");

		registerButton(button[1], "1");
		registerButton(button[2], "2");
		registerButton(button[3], "3");
		registerButton(button[17], "+");

		registerButton(button[18], "%");
		registerButton(button[0], "0");
		registerButton(button[10], ".");
		registerButton(button[19], "=");

		registerButton(button[20], "√");
		registerButton(button[21], "^");
		registerButton(button[34], "^2");
		registerButton(button[35], "^3");

		registerHiddenButton(button[22], "log");
		registerHiddenButton(button[24], "sin°");
		registerHiddenButton(button[25], "cos°");
		registerHiddenButton(button[26], "tg°");
		registerHiddenButton(button[27], "ctg°");
		registerHiddenButton(button[28], "arcsin");
		registerHiddenButton(button[29], "arccos");
		registerHiddenButton(button[30], "arctg");
		registerHiddenButton(button[31], "arcctg");
		registerHiddenButton(button[42], "10^");
		registerHiddenButton(button[36], "lg");
		registerHiddenButton(button[37], "ln");
		registerHiddenButton(button[38], "ch");
		registerHiddenButton(button[39], "sh");
		registerHiddenButton(button[40], "th");
		registerHiddenButton(button[41], "cth");

		registerButton(button[43], "1/x");
		registerButton(button[23], "n!");
		registerButton(button[44], "n!!");

		registerButton(button[32], "Инженер");

		outputField.setFont(outputField.getFont().deriveFont(40f)); // меняем размер шрифта полю вывода
		outputField.setHorizontalAlignment(SwingConstants.RIGHT); // располагаем выводимый текст справа, а не по умолчанию в центре
		outputField.setEditable(false); // запрещаем редактировать поле через мышь и клавиатуру, т.к. вычислять таким образом всё равно нельзя.
		operation = Operation.NULL;
		frame.add(outputField, BorderLayout.NORTH); //поле вывода - наверху
		frame.add(panel, BorderLayout.CENTER); //кнопки - под полем вывода
		frame.setVisible(true); //окно видимое
		frame.setSize(600, 700); //размер окна
		frame.setLocationRelativeTo(null); //выводим окно в центре экрана
	}

	/*
	 * Этот метод помогает сократить количество кода, выполняя сразу несколько действий. Аргументы:
	 *
	 * button - конкретная кнопка, элемент массива, который мы настраиваем name - текст, который будет написан на кнопке
	 *
	 * От порядка настройки кнопок зависит их положение в сетке кнопок. Сетка заполняется сверху вниз и слева направо.
	 */
	public void registerButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20f)); // присваиваем кнопке увеличенный шрифт
		button.addActionListener(this); // присваиваем кнопке механизм вызова actionPerformed
		button.setText(name); // присваиваем кнопке name в качестве текста
		panel.add(button);// располагаем кнопку на сетке кнопок.
	}

	/*
	 * Этот метод помогает оптимизировать меню инженера, позволяя открывать и закрывать доселе невидимые кнопки. Аргументы:
	 *
	 * button - конкретная кнопка, элемент массива, который мы настраиваем name - текст, который будет написан на кнопке
	 */
	public void registerHiddenButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20f)); // присваиваем кнопке увеличенный шрифт
		button.addActionListener(this); // присваиваем кнопке механизм вызова actionPerformed
		button.setText(name); // присваиваем кнопке name в качестве текста
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		final JButton jbutton = (JButton) event.getSource(); // определяет, какая именно кнопка была нажата
		selectButton(jbutton); // выбирает условие в зависимости от нажатой кнопки
	}

	//выбор развилки в зависимости от нажатой кнопки
	public void selectButton(JButton jbutton) {
		
		//Регистрируем и заполняем карту соответствий "кнопка - операция с одним числом"
		Map<JButton, Operation> one = new HashMap<>();
		one.put(button[23], Operation.FACTORIAL);
		one.put(button[44], Operation.DOUBLEFACT);
		one.put(button[20], Operation.SQRT);
		one.put(button[24], Operation.SIN);
		one.put(button[25], Operation.COS);
		one.put(button[26], Operation.TG);
		one.put(button[27], Operation.CTG);
		one.put(button[28], Operation.ARCSIN);
		one.put(button[29], Operation.ARCCOS);
		one.put(button[30], Operation.ARCTG);
		one.put(button[31], Operation.ARCCTG);
		one.put(button[34], Operation.SQARE);
		one.put(button[35], Operation.CUBE);
		one.put(button[36], Operation.LG);
		one.put(button[37], Operation.LN);
		one.put(button[38], Operation.CH);
		one.put(button[39], Operation.SH);
		one.put(button[40], Operation.TH);
		one.put(button[41], Operation.CTH);
		one.put(button[42], Operation.TEN);
		one.put(button[43], Operation.BACK);

		//Регистрируем и заполняем карту соответствий "кнопка - операция с двумя числами"
		Map<JButton, Operation> two = new HashMap<>();
		two.put(button[17], Operation.PLUS);
		two.put(button[16], Operation.MINUS);
		two.put(button[15], Operation.MULTIPLE);
		two.put(button[22], Operation.LOGARITHM);
		two.put(button[21], Operation.POWER);
		two.put(button[14], Operation.DIVIDE);
		two.put(button[18], Operation.PERCENT);
		
		//Перебираем все ключи (первый стобик карты)
		for (JButton btn: one.keySet()) {
			if (jbutton == btn) {
				oneNumber(one.get(btn), btn); //Если кнопка равна ключу, то ей в соответствие ставим её значение из карты
			}
		}

		//Перебираем все ключи (первый стобик карты)
		for (JButton btn: two.keySet()) {
			if (jbutton == btn) {
				twoNumbers(two.get(btn), btn); //Если кнопка равна ключу, то ей в соответствие ставим её значение из карты
			}
		}
		
		// если нажатая кнопка - инженер
		if (jbutton == button[32]) {
			extendedMode();
		} 
		
		// если нажатая кнопка - очистить
		else if (jbutton == button[13]) {
			clear();
		}

		// если нажатая кнопка - равно
		else if (jbutton == button[19]) {
			equals();
		}

		// если нажатая кнопка - число Эйлера
		else if (jbutton == button[12]) {
			outputField.setText("2.718281828459045"); // выводим число Эйлера
		}

		// если нажатая кнопка - число Пи
		else if (jbutton == button[11]) {
			outputField.setText("3.141592653589793"); // выводим число Пи
		}

		// если нажатая кнопка - цифра или точка
		else {
			for (int i = 0; i < 11; i++) {
				if (jbutton == button[i]) {
					String t = outputField.getText(); // считываем введённые символы
					t += button[i].getText(); // добавляем к считанным данным символ, написанный на кпопке
					outputField.setText(t); // выводим обратно данные + добавленный нами символ
				}
			}
		}
	}

	/* Действия, выполняемые кнопкой "очистка" */
	public void clear() {
		output = input1 = input2 = 0; // стираем память
		outputField.setText(""); // очищаем поле вывода
	}

	/* Действия, выполняемые кнопкой "инженер" */
	public void extendedMode() {
		if (!isExtended) {
			panel.setLayout(new GridLayout(11, 4));
			isExtended = true;
			panel.remove(button[32]);

			//Перебираем номера в массиве с айдишниками
			for (int i = 0; i < exNums.length; i++) {
				panel.add(button[exNums[i]]); //добавляем кнопку с айдишником из массива
			}

			panel.add(button[32]);
			button[32].setText("Назад");
		} else {
			panel.setLayout(new GridLayout(7, 4));
			isExtended = false;
			panel.remove(button[32]);

			//Перебираем номера в массиве с айдишниками
			for (int i = 0; i < exNums.length; i++) {
				panel.remove(button[exNums[i]]); //удаляем кнопку с айдишником из массива
			}

			panel.add(button[32]);
			button[32].setText("Инженер");
		}
	}

	/* Действия, выполняемые кнопкой "равно" */
	public void equals() {
		input2 = Double.parseDouble(outputField.getText().substring(notInclude)); // считываем последние введённые
																					// данные
		calculate(); // выполняем последнюю присвоенную операцию
		final String result = new DecimalFormat("#.###############").format(output); // округление
		outputField.setText(outputField.getText() + "=" + result); // выводим результат
	}

	/*
	 * Этот метод помогает сократить количество кода, выполняя сразу несколько
	 * действий. Аргументы:
	 *
	 * op - присваемая нами операция
	 *
	 * Данный метод автоматически выполняет вычисление и выводит результат, не
	 * требуя нажатие кнопки "равно"
	 */
	public void oneNumber(Operation op, JButton button) {
		input1 = Double.parseDouble(outputField.getText()); // считываем введённые символы и преобразуем их в число
		operation = op; // присваиваем операцию
		calculate(); // выполняем вычисление, формула которого меняется в зависимости от операции
		final String result = new DecimalFormat("#.###############").format(output); // округление
		outputField.setText(button.getText() + "(" + outputField.getText() + ")" + "=" + result); // выводим результат
	}

	/*
	 * Этот метод помогает сократить количество кода, выполняя сразу несколько
	 * действий. Аргументы:
	 *
	 * op - присваемая нами операция
	 *
	 * Данный метод не выполняет вычисление, поскольку требуется ввод второго числа,
	 * после которого нужно нажать "равно"
	 */
	public void twoNumbers(Operation op, JButton button) {
		notInclude = outputField.getText().length() + button.getText().length();
		input1 = Double.parseDouble(outputField.getText()); // считываем введённые символы и преобразуем их в число
		operation = op; // присваиваем операцию
		outputField.setText(outputField.getText() + button.getText()); // выводим операцию
	}

	// вычисления, где формула зависит от ранее присвоенной операции
	public void calculate() {
		Map<Operation, Double> op = new HashMap<>();
		op.put(Operation.PLUS, input1 + input2);
		op.put(Operation.MINUS, input1 - input2);
		op.put(Operation.MULTIPLE, input1 * input2);
		op.put(Operation.ARCSIN, Math.asin(input1));
		op.put(Operation.ARCCOS, Math.acos(input1));
		op.put(Operation.ARCTG, Math.atan(input1));
		op.put(Operation.ARCCTG, 1 / Math.atan(input1));
		op.put(Operation.SIN, Math.sin(Math.toRadians(input1)));
		op.put(Operation.COS, Math.cos(Math.toRadians(input1)));
		op.put(Operation.TG, Math.tan(Math.toRadians(input1)));
		op.put(Operation.CTG, 1 / Math.tan(Math.toRadians(input1)));
		op.put(Operation.SQRT, Math.sqrt(input1));
		op.put(Operation.LOGARITHM, Math.log10(input1) / Math.log10(input2));
		op.put(Operation.POWER, Math.pow(input1, input2));
		op.put(Operation.DIVIDE, input1 / input2);
		op.put(Operation.PERCENT, input2 * input1 / 100);
		op.put(Operation.SQARE, input1 * input1);
		op.put(Operation.CUBE, Math.pow(input1, 3));
		op.put(Operation.LG, Math.log10(input1));
		op.put(Operation.LN, Math.log(input1));
		op.put(Operation.CH, (Math.pow(2.7183, input1) + Math.pow(2.7183, (-1) * input1)) / 2);
		op.put(Operation.SH, (Math.pow(2.7183, input1) - Math.pow(2.7183, (-1) * input1)) / 2);
		op.put(Operation.TH, (Math.pow(2.7183, input1) - Math.pow(2.7183, (-1) * input1)) / (Math.pow(2.7183, input1) + Math.pow(2.7183, (-1) * input1)));
		op.put(Operation.CTH, (Math.pow(2.7183, input1) + Math.pow(2.7183, (-1) * input1)) / (Math.pow(2.7183, input1) - Math.pow(2.7183, (-1) * input1)));
		op.put(Operation.TEN, Math.pow(10, input1));
		op.put(Operation.BACK, 1 / input1);
		op.put(Operation.NULL, input2);
		
		switch(operation) {
		case DOUBLEFACT:
			long result2 = 1;
			for (Long k = Math.round(input1); k > 0; k = k - 2) {
				result2 = result2 * k;
			}
			output = result2;
			break;
		case FACTORIAL:	
			long result = 1;
			for (long i = 1; i <= input1; i++) {
				result = result * i;
			}
			output = result;
			break;
		default:
			output = op.get(operation);
		}
	}

	// перечисление всех операций, где NULL - операция по умолчанию, использущаяся,
	// если пользователь не присвоил новую операцию.
	public enum Operation {
		NULL, ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG, SQARE, CUBE, LG, LN, CH, SH, TH, CTH, TEN, BACK, DOUBLEFACT;
	}

	// доступ к приватному полю
	public JButton getButton(int i) {
		return button[i];
	}

	// доступ к приватному полю
	public boolean getExtended() {
		return isExtended;
	}

	// доступ к приватному полю
	public double getOutput() {
		return output;
	}
}