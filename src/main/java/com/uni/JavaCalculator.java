package main.java.com.uni;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//класс базируется на JFrame и наследует его содержимое, ActionListener отвечает за отслеживание нажатой кнопки
public class JavaCalculator implements ActionListener {
	private JButton[] button = new JButton[32]; //все наши кнопки
	private Operation operation; //тип операции - сложение, вычитание и т.д.
	private double output; //выводимые данные
	private double input1; //вводимые данные
	private double input2; //вводимые данные
	private JTextField outputField = new JTextField(20); //поле вывода
	private JPanel panel = new JPanel();  //сетка из кнопок
	private int notInclude;

	public static void main(String[] arg) {
		new JavaCalculator();
	}

	public JavaCalculator() {
		JFrame frame = new JFrame("Calculator v1.2.0");  //создаём окно и задаём заголовок

		//создаём кнопки про помощи цикла
		for (int i = 0; i <= 31; i++) {
			button[i] = new JButton();
		}

		panel.setLayout(new GridLayout(8, 4)); //сетка из кнопок - в высоту и в ширину

		//настраиваем созданные кнопки, используя новый метод "registerButton"
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
		registerButton(button[22], "log");
		registerButton(button[23], "n!");

		registerButton(button[24], "sin°");
		registerButton(button[25], "cos°");
		registerButton(button[26], "tg°");
		registerButton(button[27], "ctg°");

		registerButton(button[28], "arcsin");
		registerButton(button[29], "arccos");
		registerButton(button[30], "arctg");
		registerButton(button[31], "arcctg");

		outputField.setFont(outputField.getFont().deriveFont(40f)); //меняем размер шрифта полю вывода
		outputField.setHorizontalAlignment(SwingConstants.RIGHT); //располагаем выводимый текст справа, а не по умолчанию в центре
		outputField.setEditable(false); //запрещаем редактировать поле через мышь и клавиатуру, т.к. вычислять таким образом всё равно нельзя.

		//frame.add(outputField, BorderLayout.NORTH); //поле вывода - наверху
		//frame.add(panel, BorderLayout.CENTER); //кнопки - под полем вывода
		//frame.setVisible(true); //окно видимое
		//frame.setSize(600, 700); //размер окна
		//frame.setLocationRelativeTo(null); //выводим окно в центре экрана
	}

	/* Этот метод помогает сократить количество кода, выполняя сразу несколько действий. Аргументы:
	 *
	 * button - конкретная кнопка, элемент массива, который мы настраиваем
	 * name - текст, который будет написан на кнопке
	 *
	 * От порядка настройки кнопок зависит их положение в сетке кнопок. Сетка заполняется сверху вниз и слева направо.
	 */
	public void registerButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20f)); //присваиваем кнопке увеличенный шрифт
		button.addActionListener(this); //присваиваем кнопке механизм вызова actionPerformed
		button.setText(name); //присваиваем кнопке name в качестве текста
		panel.add(button); //располагаем кнопку на сетке кнопок.
	}

	//@Override
	public void actionPerformed(ActionEvent event) {
		final JButton jbutton = (JButton) event.getSource(); //определяет, какая именно кнопка была нажата

		//если нажатая кнопка - очистить
		if (jbutton == button[13]) {
			output = input1 = input2 = 0; //стираем память
			outputField.setText(""); //очищаем поле вывода
		}

		//если нажатая кнопка - равно
		else if (jbutton == button[19]) {
			input2 = Double.parseDouble(outputField.getText().substring(notInclude)); //считываем последние введённые данные
			calculate(); //выполняем последнюю присвоенную операцию
			String result = new DecimalFormat("#.###############").format(output); //округление
			outputField.setText(outputField.getText() + "=" + result); //выводим результат
		}

		//если нажатая кнопка - операция, то мы присваиваем ей операцию методами oneNumber или twoNumbers
		else if (jbutton == button[23]) {
			oneNumber(Operation.FACTORIAL, button[23]);
		} else if (jbutton == button[20]) {
			oneNumber(Operation.SQRT, button[20]);
		} else if (jbutton == button[24]) {
			oneNumber(Operation.SIN, button[24]);
		} else if (jbutton == button[25]) {
			oneNumber(Operation.COS, button[25]);
		} else if (jbutton == button[26]) {
			oneNumber(Operation.TG, button[26]);
		} else if (jbutton == button[27]) {
			oneNumber(Operation.CTG, button[27]);
		} else if (jbutton == button[28]) {
			oneNumber(Operation.ARCSIN, button[28]);
		} else if (jbutton == button[29]) {
			oneNumber(Operation.ARCCOS, button[29]);
		} else if (jbutton == button[30]) {
			oneNumber(Operation.ARCTG, button[30]);
		} else if (jbutton == button[31]) {
			oneNumber(Operation.ARCCTG, button[31]);
		} else if (jbutton == button[17]) {
			twoNumbers(Operation.PLUS, button[17]);
		} else if (jbutton == button[16]) {
			twoNumbers(Operation.MINUS, button[16]);
		} else if (jbutton == button[15]) {
			twoNumbers(Operation.MULTIPLE, button[15]);
		} else if (jbutton == button[22]) {
			twoNumbers(Operation.LOGARITHM, button[22]);
		} else if (jbutton == button[21]) {
			twoNumbers(Operation.POWER, button[21]);
		} else if (jbutton == button[14]) {
			twoNumbers(Operation.DIVIDE, button[14]);
		} else if (jbutton == button[18]) {
			twoNumbers(Operation.PERCENT, button[18]);
		}

		//если нажатая кнопка - число Эйлера
		else if (jbutton == button[12]) {
			outputField.setText("2.718281828459045"); //выводим число Эйлера
		}

		//если нажатая кнопка - число Пи
		else if (jbutton == button[11]) {
			outputField.setText("3.141592653589793"); //выводим число Пи
		}

		//если нажатая кнопка - цифра или точка
		else {
			for (int i = 0; i < 11; i++) {
				if (jbutton == button[i]) {
					String t = outputField.getText(); //считываем введённые символы
					t += button[i].getText(); //добавляем к считанным данным символ, написанный на кпопке
					outputField.setText(t); //выводим обратно данные + добавленный нами символ
				}
			}
		}
	}

	/* Этот метод помогает сократить количество кода, выполняя сразу несколько действий. Аргументы:
	 *
	 * op - присваемая нами операция
	 *
	 * Данный метод автоматически выполняет вычисление и выводит результат, не требуя нажатие кнопки "равно"
	 */
	public void oneNumber(Operation op, JButton button) {
		input1 = Double.parseDouble(outputField.getText()); //считываем введённые символы и преобразуем их в число
		operation = op; //присваиваем операцию
		calculate(); //выполняем вычисление, формула которого меняется в зависимости от операции
		String result = new DecimalFormat("#.###############").format(output); //округление
		outputField.setText(button.getText() + "(" + outputField.getText() + ")" + "=" + result); //выводим результат
	}

	/* Этот метод помогает сократить количество кода, выполняя сразу несколько действий. Аргументы:
	 *
	 * op - присваемая нами операция
	 *
	 * Данный метод не выполняет вычисление, поскольку требуется ввод второго числа, после которого нужно нажать "равно"
	 */
	public void twoNumbers(Operation op, JButton button) {
		notInclude = outputField.getText().length() + button.getText().length();
		input1 = Double.parseDouble(outputField.getText());  //считываем введённые символы и преобразуем их в число
		operation = op; //присваиваем операцию
		outputField.setText(outputField.getText() + button.getText()); //выводим операцию
	}

	//вычисления, где формула зависит от ранее присвоенной операции
	public double calculate() {
		switch (operation) {
		case PLUS:
			output = input1 + input2;
			break;
		case MINUS:
			output = input1 - input2;
			break;
		case MULTIPLE:
			output = input1 * input2;
			break;
		case ARCSIN:
			output = Math.asin(input1);
			break;
		case ARCCOS:
			output = Math.acos(input1);
			break;
		case ARCTG:
			output = Math.atan(input1);
			break;
		case ARCCTG:
			output = 1 / Math.atan(input1);
			break;
		case SIN:
			output = Math.sin(Math.toRadians(input1));
			break;
		case COS:
			output = Math.cos(Math.toRadians(input1));
			break;
		case TG:
			output = Math.tan(Math.toRadians(input1));
			break;
		case CTG:
			output = 1 / Math.tan(Math.toRadians(input1));
			break;
		case SQRT:
			output = Math.sqrt(input1);
			break;
		case LOGARITHM:
			output = Math.log10(input1) / Math.log10(input2);
			break;
		case POWER:
			output = Math.pow(input1, input2);
			break;
		case FACTORIAL:
			long result = 1;
			for (long i = 1; i <= input1; i++) {
				result = result * i;
			}
			output = result;
			break;
		case DIVIDE:
			output = input1 / input2;
			break;
		case PERCENT:
			output = input2 * input1 / 100;
			break;
		}
		return 0;
	}

	//перечисление всех операций, где NULL - операция по умолчанию, использущаяся, если пользователь не присвоил новую операцию.
	public enum Operation {
		ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG;
	}
	
	//доступ к приватному полю
	public void setInput1(double i) {
		input1 = i;
	}
	
	//доступ к приватному полю
	public void setInput2(double i) {
		input2 = i;
	}
	
	//доступ к приватному полю
	public double getOutput() {
		return output;
	}
	
	//доступ к приватному полю
	public void setOperation(Operation op) {
		operation = op;
	}
}