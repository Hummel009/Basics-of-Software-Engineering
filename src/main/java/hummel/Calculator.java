package hummel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

public class Calculator extends JFrame implements ActionListener {
	protected static final int[] EXTENDED_MODE_IDS = {22, 24, 25, 26, 27, 28, 29, 30, 31, 36, 37, 38, 39, 40, 41, 42};
	protected static final JButton[] BUTTONS = new JButton[50];
	protected static final JPanel PANEL = new JPanel();

	static {
		for (int i = 0; i <= 49; i++) {
			BUTTONS[i] = new JButton();
		}
	}

	private Map<Operation, Supplier<Double>> op = new EnumMap<>(Operation.class);
	private Operation operation;
	private double input1;
	private double input2;
	private double output;
	private JTextField outputField = new JTextField(20);
	private int notInclude;
	private boolean isExtended;

	public Calculator() {
		setTitle("Hummel009's Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		PANEL.setLayout(new GridLayout(7, 4));

		registerButton(BUTTONS[13], "C");
		registerButton(BUTTONS[12], "e");
		registerButton(BUTTONS[11], "p");
		registerButton(BUTTONS[14], "/");

		registerButton(BUTTONS[7], "7");
		registerButton(BUTTONS[8], "8");
		registerButton(BUTTONS[9], "9");
		registerButton(BUTTONS[15], "*");

		registerButton(BUTTONS[4], "4");
		registerButton(BUTTONS[5], "5");
		registerButton(BUTTONS[6], "6");
		registerButton(BUTTONS[16], "-");

		registerButton(BUTTONS[1], "1");
		registerButton(BUTTONS[2], "2");
		registerButton(BUTTONS[3], "3");
		registerButton(BUTTONS[17], "+");

		registerButton(BUTTONS[18], "%");
		registerButton(BUTTONS[0], "0");
		registerButton(BUTTONS[10], ".");
		registerButton(BUTTONS[19], "=");

		registerButton(BUTTONS[20], "sqrt");
		registerButton(BUTTONS[21], "^");
		registerButton(BUTTONS[34], "^2");
		registerButton(BUTTONS[35], "^3");

		registerHiddenButton(BUTTONS[22], "log");
		registerHiddenButton(BUTTONS[24], "sin°");
		registerHiddenButton(BUTTONS[25], "cos°");
		registerHiddenButton(BUTTONS[26], "tg°");
		registerHiddenButton(BUTTONS[27], "ctg°");
		registerHiddenButton(BUTTONS[28], "arcsin");
		registerHiddenButton(BUTTONS[29], "arccos");
		registerHiddenButton(BUTTONS[30], "arctg");
		registerHiddenButton(BUTTONS[31], "arcctg");
		registerHiddenButton(BUTTONS[42], "10^");
		registerHiddenButton(BUTTONS[36], "lg");
		registerHiddenButton(BUTTONS[37], "ln");
		registerHiddenButton(BUTTONS[38], "ch");
		registerHiddenButton(BUTTONS[39], "sh");
		registerHiddenButton(BUTTONS[40], "th");
		registerHiddenButton(BUTTONS[41], "cth");

		registerButton(BUTTONS[43], "1/x");
		registerButton(BUTTONS[23], "n!");
		registerButton(BUTTONS[44], "n!!");

		registerButton(BUTTONS[32], "Extended");

		outputField.setFont(outputField.getFont().deriveFont(40.0f));
		outputField.setHorizontalAlignment(SwingConstants.RIGHT);
		outputField.setEditable(false);

		operation = Operation.NULL;

		op.put(Operation.PLUS, () -> input1 + input2);
		op.put(Operation.MINUS, () -> input1 - input2);
		op.put(Operation.MULTIPLE, () -> input1 * input2);
		op.put(Operation.ARCSIN, () -> Math.asin(input1));
		op.put(Operation.ARCCOS, () -> Math.acos(input1));
		op.put(Operation.ARCTG, () -> Math.atan(input1));
		op.put(Operation.ARCCTG, () -> 1 / Math.atan(input1));
		op.put(Operation.SIN, () -> Math.sin(Math.toRadians(input1)));
		op.put(Operation.COS, () -> Math.cos(Math.toRadians(input1)));
		op.put(Operation.TG, () -> Math.tan(Math.toRadians(input1)));
		op.put(Operation.CTG, () -> 1 / Math.tan(Math.toRadians(input1)));
		op.put(Operation.SQRT, () -> Math.sqrt(input1));
		op.put(Operation.LOGARITHM, () -> Math.log10(input1) / Math.log10(input2));
		op.put(Operation.POWER, () -> Math.pow(input1, input2));
		op.put(Operation.DIVIDE, () -> input1 / input2);
		op.put(Operation.PERCENT, () -> input2 * input1 / 100);
		op.put(Operation.SQARE, () -> input1 * input1);
		op.put(Operation.CUBE, () -> Math.pow(input1, 3));
		op.put(Operation.LG, () -> Math.log10(input1));
		op.put(Operation.LN, () -> Math.log(input1));
		op.put(Operation.CH, () -> (Math.pow(2.7183, input1) + Math.pow(2.7183, -1 * input1)) / 2);
		op.put(Operation.SH, () -> (Math.pow(2.7183, input1) - Math.pow(2.7183, -1 * input1)) / 2);
		op.put(Operation.TH, () -> (Math.pow(2.7183, input1) - Math.pow(2.7183, -1 * input1)) / (Math.pow(2.7183, input1) + Math.pow(2.7183, -1 * input1)));
		op.put(Operation.CTH, () -> (Math.pow(2.7183, input1) + Math.pow(2.7183, -1 * input1)) / (Math.pow(2.7183, input1) - Math.pow(2.7183, -1 * input1)));
		op.put(Operation.TEN, () -> Math.pow(10, input1));
		op.put(Operation.BACK, () -> 1 / input1);
		op.put(Operation.NULL, () -> input2);
		op.put(Operation.DOUBLEFACT, () -> {
			long result = 1;
			for (long k = Math.round(input1); k > 0; k -= 2) {
				result = result * k;
			}
			output = result;
			return output;
		});
		op.put(Operation.FACTORIAL, () -> {
			long result = 1;
			for (long k = Math.round(input1); k > 0; k -= 1) {
				result = result * k;
			}
			output = result;
			return output;
		});

		add(outputField, BorderLayout.PAGE_START);
		add(PANEL, BorderLayout.CENTER);
		setSize(600, 700);
		setLocationRelativeTo(null);
	}

	public static void main(String[] arg) {
		EventQueue.invokeLater(() -> {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows Classic".equals(info.getName())) {
					try {
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
					         UnsupportedLookAndFeelException e) {
						throw new RuntimeException(e);
					}
					break;
				}
			}
			JFrame frame = new Calculator();
			frame.setVisible(true);
		});
	}

	public void calculate() {
		output = op.get(operation).get();
	}

	public void equals() {
		try {
			input2 = Double.parseDouble(outputField.getText().substring(notInclude));
			calculate();
			String result = new DecimalFormat("#.###############").format(output);
			outputField.setText(outputField.getText() + "=" + result);
		} catch (Exception e) {
			outputField.setText("");
		}
	}

	public void extendedMode() {
		if (isExtended) {
			PANEL.setLayout(new GridLayout(7, 4));
			isExtended = false;
			PANEL.remove(BUTTONS[32]);

			for (int exNum : EXTENDED_MODE_IDS) {
				PANEL.remove(BUTTONS[exNum]);
			}

			PANEL.add(BUTTONS[32]);
			BUTTONS[32].setText("Extended");
		} else {
			PANEL.setLayout(new GridLayout(11, 4));
			isExtended = true;
			PANEL.remove(BUTTONS[32]);

			for (int exNum : EXTENDED_MODE_IDS) {
				PANEL.add(BUTTONS[exNum]);
			}

			PANEL.add(BUTTONS[32]);
			BUTTONS[32].setText("Back");
		}
	}

	public void oneNumber(Operation op, AbstractButton button) {
		String outputText = outputField.getText();
		int equalsIndex = outputText.indexOf('=');
		if (equalsIndex != -1) {
			outputText = outputText.substring(equalsIndex + 1).trim();
			outputField.setText(outputText);
		}
		try {
			input1 = Double.parseDouble(outputField.getText());
			operation = op;
			calculate();
			String result = new DecimalFormat("#.###############").format(output);
			outputField.setText(button.getText() + "(" + outputField.getText() + ")" + "=" + result);
		} catch (Exception e) {
			outputField.setText("");
		}
	}

	public void selectButton(JButton jbutton) {
		Map<JButton, Operation> one = new HashMap<>();
		one.put(BUTTONS[23], Operation.FACTORIAL);
		one.put(BUTTONS[44], Operation.DOUBLEFACT);
		one.put(BUTTONS[20], Operation.SQRT);
		one.put(BUTTONS[24], Operation.SIN);
		one.put(BUTTONS[25], Operation.COS);
		one.put(BUTTONS[26], Operation.TG);
		one.put(BUTTONS[27], Operation.CTG);
		one.put(BUTTONS[28], Operation.ARCSIN);
		one.put(BUTTONS[29], Operation.ARCCOS);
		one.put(BUTTONS[30], Operation.ARCTG);
		one.put(BUTTONS[31], Operation.ARCCTG);
		one.put(BUTTONS[34], Operation.SQARE);
		one.put(BUTTONS[35], Operation.CUBE);
		one.put(BUTTONS[36], Operation.LG);
		one.put(BUTTONS[37], Operation.LN);
		one.put(BUTTONS[38], Operation.CH);
		one.put(BUTTONS[39], Operation.SH);
		one.put(BUTTONS[40], Operation.TH);
		one.put(BUTTONS[41], Operation.CTH);
		one.put(BUTTONS[42], Operation.TEN);
		one.put(BUTTONS[43], Operation.BACK);

		Map<JButton, Operation> two = new HashMap<>();
		two.put(BUTTONS[17], Operation.PLUS);
		two.put(BUTTONS[16], Operation.MINUS);
		two.put(BUTTONS[15], Operation.MULTIPLE);
		two.put(BUTTONS[22], Operation.LOGARITHM);
		two.put(BUTTONS[21], Operation.POWER);
		two.put(BUTTONS[14], Operation.DIVIDE);
		two.put(BUTTONS[18], Operation.PERCENT);

		Map<JButton, Runnable> vd = new HashMap<>();
		vd.put(BUTTONS[32], this::extendedMode);
		vd.put(BUTTONS[13], () -> {
			output = input1 = input2 = 0;
			outputField.setText("");
		});
		vd.put(BUTTONS[19], this::equals);
		vd.put(BUTTONS[12], () -> outputField.setText("2.718281828459045"));
		vd.put(BUTTONS[11], () -> outputField.setText("3.141592653589793"));

		boolean skip = false;
		for (Entry<JButton, Operation> btn : one.entrySet()) {
			if (jbutton == btn.getKey()) {
				oneNumber(btn.getValue(), btn.getKey());
				skip = true;
				break;
			}
		}

		if (!skip) {
			for (Entry<JButton, Operation> btn : two.entrySet()) {
				if (jbutton == btn.getKey()) {
					twoNumbers(btn.getValue(), btn.getKey());
					skip = true;
					break;
				}
			}
		}

		if (!skip) {
			for (Entry<JButton, Runnable> btn : vd.entrySet()) {
				if (jbutton == btn.getKey()) {
					btn.getValue().run();
					skip = true;
					break;
				}
			}
		}

		if (!skip) {
			for (int i = 0; i < 11; i++) {
				if (jbutton == BUTTONS[i]) {
					String t = outputField.getText();
					t += BUTTONS[i].getText();
					outputField.setText(t);
					break;
				}
			}
		}
	}

	public void twoNumbers(Operation op, AbstractButton button) {
		String outputText = outputField.getText();
		int equalsIndex = outputText.indexOf('=');
		if (equalsIndex != -1) {
			outputText = outputText.substring(equalsIndex + 1).trim();
			outputField.setText(outputText);
		}
		try {
			notInclude = outputField.getText().length() + button.getText().length();
			input1 = Double.parseDouble(outputField.getText());
			operation = op;
			outputField.setText(outputField.getText() + button.getText());
		} catch (Exception e) {
			outputField.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		selectButton((JButton) event.getSource());
	}

	public void registerButton(JButton button, String name) {
		button.setFont(button.getFont().deriveFont(20.0f));
		button.addActionListener(this);
		button.setText(name);
		PANEL.add(button);
	}

	public void registerHiddenButton(AbstractButton button, String name) {
		button.setFont(button.getFont().deriveFont(20.0f));
		button.addActionListener(this);
		button.setText(name);
	}

	public enum Operation {
		NULL, ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG, SQARE, CUBE, LG, LN, CH, SH, TH, CTH, TEN, BACK, DOUBLEFACT
	}

	public double getOutput() {
		return output;
	}

	public boolean isExtended() {
		return isExtended;
	}
}