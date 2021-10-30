package io.github.hummel.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//класс базируется на JFrame и наследует его содержимое, ActionListener отвечает за отслеживание нажатой кнопки
public class JavaCalculator extends JFrame implements ActionListener {
	public JButton button[] = new JButton[32]; //все наши кнопки
	public double output, input1, input2; //вводимые и выводимые данные
	public JTextField outputField = new JTextField(20); //поле вывода
	public JPanel panel = new JPanel();  //сетка из кнопок

	public static void main(String arg[]) {
		new JavaCalculator();
	}

	public JavaCalculator() {
		super("Calculator v1.2.0"); //полностью повторяем содержимое JFrame и задаём заголовок окна 
		
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
		
		outputField.setFont(outputField.getFont().deriveFont(50f)); //меняем размер шрифта полю вывода
		outputField.setHorizontalAlignment(JTextField.RIGHT); //располагаем выводимый текст справа, а не по умолчанию в центре
		outputField.setEditable(false); //запрещаем редактировать поле через мышь и клавиатуру, т.к. вычислять таким образом всё равно нельзя.
		
		add(outputField, BorderLayout.NORTH); //поле вывода - наверху
		add(panel, BorderLayout.CENTER); //кнопки - под полем вывода
		setVisible(true); //окно видимое
		setSize(600, 700); //размер окна
		setLocationRelativeTo(null); //выводим окно в центре экрана
	}

	/* Этот метод помогает сократить количество кода, выполняя сразу несколько действий. Аргументы:
	 * 
	 * button - кнопка, элемент массива, который мы настраиваем
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
}
