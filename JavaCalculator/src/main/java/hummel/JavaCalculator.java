package main.java.hummel;

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

public class JavaCalculator implements ActionListener {
	private final JButton[] button = new JButton[50];
	private Operation operation;
	private double output;
	private double input1;
	private double input2;
	private final JTextField outputField = new JTextField(20);
	private final JPanel panel = new JPanel();
	private int notInclude;
	private int[] exNums = { 22, 24, 25, 26, 27, 28, 29, 30, 31, 36, 37, 38, 39, 40, 41, 42 };
	private boolean isExtended = false;

	public static void main(String[] arg) {
		new JavaCalculator();
	}

	public JavaCalculator() {
		JFrame frame = new JFrame("JavaCalculator v2.0");

		for (int i = 0; i <= 49; i++) {
			button[i] = new JButton();
		}

		panel.setLayout(new GridLayout(7, 4));

		registerButton(button[13], "C");
		registerButton(button[12], "e");
		registerButton(button[11], "\u03C0");
		registerButton(button[14], "\u00F7");

		registerButton(button[7], "7");
		registerButton(button[8], "8");
		registerButton(button[9], "9");
		registerButton(button[15], "\u00D7");

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

		registerButton(button[20], "\u221A");
		registerButton(button[21], "^");
		registerButton(button[34], "^2");
		registerButton(button[35], "^3");

		registerHiddenButton(button[22], "log");
		registerHiddenButton(button[24], "sin\u00B0");
		registerHiddenButton(button[25], "cos\u00B0");
		registerHiddenButton(button[26], "tg\u00B0");
		registerHiddenButton(button[27], "ctg\u00B0");
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

		registerButton(button[32], "\u0418\u043D\u0436\u0435\u043D\u0435\u0440");

		outputField.setFont(outputField.getFont().deriveFont(40f));
		outputField.setHorizontalAlignment(SwingConstants.RIGHT);
		outputField.setEditable(false);
		operation = Operation.NULL;
		frame.add(outputField, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setSize(600, 700);
		frame.setLocationRelativeTo(null);
	}

	public void registerButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20f));
		button.addActionListener(this);
		button.setText(name);
		panel.add(button);
	}

	public void registerHiddenButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20f));
		button.addActionListener(this);
		button.setText(name);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		final JButton jbutton = (JButton) event.getSource();
		selectButton(jbutton);
	}

	public void selectButton(JButton jbutton) {

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

		Map<JButton, Operation> two = new HashMap<>();
		two.put(button[17], Operation.PLUS);
		two.put(button[16], Operation.MINUS);
		two.put(button[15], Operation.MULTIPLE);
		two.put(button[22], Operation.LOGARITHM);
		two.put(button[21], Operation.POWER);
		two.put(button[14], Operation.DIVIDE);
		two.put(button[18], Operation.PERCENT);

		Map<JButton, Integer> vd = new HashMap<>();
		vd.put(button[32], 0);
		vd.put(button[13], 1);
		vd.put(button[19], 2);
		vd.put(button[12], 3);
		vd.put(button[11], 4);

		for (JButton btn: one.keySet()) {
			if (jbutton == btn) {
				oneNumber(one.get(btn), btn);
				break;
			}
		}

		for (JButton btn: two.keySet()) {
			if (jbutton == btn) {
				twoNumbers(two.get(btn), btn);
				break;
			}
		}

		for (JButton btn: vd.keySet()) {
			if (jbutton == btn) {
				enable(vd.get(btn));
				break;
			}
		}

		for (int i = 0; i < 11; i++) {
			if (jbutton == button[i]) {
				String t = outputField.getText();
				t += button[i].getText();
				outputField.setText(t);
				break;
			}
		}
	}

	private void enable(int i) {
		switch(i) {
		case 0:
			extendedMode();
			break;
		case 1:
			output = input1 = input2 = 0;
			outputField.setText("");
			break;
		case 2:
			equals();
			break;
		case 3:
			outputField.setText("2.718281828459045");
			break;
		case 4:
			outputField.setText("3.141592653589793");
		}
	}

	public void extendedMode() {
		if (!isExtended) {
			panel.setLayout(new GridLayout(11, 4));
			isExtended = true;
			panel.remove(button[32]);

			for (int exNum : exNums) {
				panel.add(button[exNum]);
			}

			panel.add(button[32]);
			button[32].setText("\u041D\u0430\u0437\u0430\u0434");
		} else {
			panel.setLayout(new GridLayout(7, 4));
			isExtended = false;
			panel.remove(button[32]);

			for (int exNum : exNums) {
				panel.remove(button[exNum]);
			}

			panel.add(button[32]);
			button[32].setText("\u0418\u043D\u0436\u0435\u043D\u0435\u0440");
		}
	}

	public void equals() {
		input2 = Double.parseDouble(outputField.getText().substring(notInclude));

		calculate();
		final String result = new DecimalFormat("#.###############").format(output);
		outputField.setText(outputField.getText() + "=" + result);
	}

	public void oneNumber(Operation op, JButton button) {
		input1 = Double.parseDouble(outputField.getText());
		operation = op;
		calculate();
		final String result = new DecimalFormat("#.###############").format(output);
		outputField.setText(button.getText() + "(" + outputField.getText() + ")" + "=" + result);
	}

	public void twoNumbers(Operation op, JButton button) {
		notInclude = outputField.getText().length() + button.getText().length();
		input1 = Double.parseDouble(outputField.getText());
		operation = op;
		outputField.setText(outputField.getText() + button.getText());
	}

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

	public enum Operation {
		NULL, ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG, SQARE, CUBE, LG, LN, CH, SH, TH, CTH, TEN, BACK, DOUBLEFACT;
	}
}