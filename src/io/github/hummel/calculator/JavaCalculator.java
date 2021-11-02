package io.github.hummel.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JavaCalculator extends JFrame implements ActionListener {
	public JButton button[] = new JButton[32];
	public Operation operation;
	public double output, input1, input2;
	public JTextField outputField;
	public JPanel panel = new JPanel();

	public static void main(String arg[]) {
		new JavaCalculator();
	}

	public JavaCalculator() {
		super("Calculator v1.2.0");
		setLayout(new BorderLayout());
		for (int i = 0; i <= 31; i++) {
			button[i] = new JButton();
		}
		panel.setLayout(new GridLayout(8, 4));

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

		outputField = new JTextField(20);
		outputField.setFont(outputField.getFont().deriveFont(50f));
		outputField.setHorizontalAlignment(JTextField.RIGHT);
		outputField.setEditable(false);

		add(panel, BorderLayout.CENTER);
		add(outputField, BorderLayout.NORTH);
		setVisible(true);
		setSize(600, 700);
		setLocationRelativeTo(null);
	}

	public void registerButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20f));
		button.addActionListener(this);
		button.setText(name);
		panel.add(button);
	}

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
			output = input1 * input2 / 100;
			break;
		}
		return 0;
	}

	public enum Operation {
		ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG;
	}
}