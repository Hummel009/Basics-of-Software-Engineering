package hummel;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.LongStream;

public class Calculator extends JFrame {
	protected static final int[] EXTENDED_MODE_IDS = {22, 24, 25, 26, 27, 28, 29, 30, 31, 36, 37, 38, 39, 40, 41, 42};
	protected static final JButton[] BUTTONS = new JButton[50];
	protected static final JPanel PANEL = new JPanel();

	protected static final Map<Operation, Supplier<Double>> ENGINE = new EnumMap<>(Operation.class);
	protected static final Map<JButton, Supplier<Runnable>> FUNC = new HashMap<>();

	protected static final Map<Operation, JButton> ONE_OPERAND = new EnumMap<>(Operation.class);
	protected static final Map<Operation, JButton> TWO_OPERAND = new EnumMap<>(Operation.class);

	static {
		for (var i = 0; i <= 49; i++) {
			BUTTONS[i] = new JButton();
		}
	}

	private final JLabel outputField = new JLabel();
	private Operation operation;
	private double input1;
	private double input2;
	private double output;
	private int notInclude;
	private boolean isExtended;

	public Calculator() {
		setTitle("Hummel009's Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		PANEL.setLayout(new GridLayout(7, 4));

		registerButton(BUTTONS[13], "C", false);
		registerButton(BUTTONS[12], "e", false);
		registerButton(BUTTONS[11], "π", false);
		registerButton(BUTTONS[14], "÷", false);

		registerButton(BUTTONS[7], "7", false);
		registerButton(BUTTONS[8], "8", false);
		registerButton(BUTTONS[9], "9", false);
		registerButton(BUTTONS[15], "×", false);

		registerButton(BUTTONS[4], "4", false);
		registerButton(BUTTONS[5], "5", false);
		registerButton(BUTTONS[6], "6", false);
		registerButton(BUTTONS[16], "-", false);

		registerButton(BUTTONS[1], "1", false);
		registerButton(BUTTONS[2], "2", false);
		registerButton(BUTTONS[3], "3", false);
		registerButton(BUTTONS[17], "+", false);

		registerButton(BUTTONS[18], "%", false);
		registerButton(BUTTONS[0], "0", false);
		registerButton(BUTTONS[10], ".", false);
		registerButton(BUTTONS[19], "=", false);

		registerButton(BUTTONS[20], "√", false);
		registerButton(BUTTONS[21], "^", false);
		registerButton(BUTTONS[34], "^2", false);
		registerButton(BUTTONS[35], "^3", false);

		registerButton(BUTTONS[22], "log", true);
		registerButton(BUTTONS[24], "sin°", true);
		registerButton(BUTTONS[25], "cos°", true);
		registerButton(BUTTONS[26], "tg°", true);
		registerButton(BUTTONS[27], "ctg°", true);
		registerButton(BUTTONS[28], "arcsin", true);
		registerButton(BUTTONS[29], "arccos", true);
		registerButton(BUTTONS[30], "arctg", true);
		registerButton(BUTTONS[31], "arcctg", true);
		registerButton(BUTTONS[42], "10^", true);
		registerButton(BUTTONS[36], "lg", true);
		registerButton(BUTTONS[37], "ln", true);
		registerButton(BUTTONS[38], "ch", true);
		registerButton(BUTTONS[39], "sh", true);
		registerButton(BUTTONS[40], "th", true);
		registerButton(BUTTONS[41], "cth", true);

		registerButton(BUTTONS[43], "1/x", false);
		registerButton(BUTTONS[23], "n!", false);
		registerButton(BUTTONS[44], "n!!", false);

		registerButton(BUTTONS[32], "ext", false);

		outputField.setFont(outputField.getFont().deriveFont(20.0f));
		outputField.setHorizontalAlignment(SwingConstants.RIGHT);
		outputField.setPreferredSize(new Dimension(outputField.getWidth(), outputField.getFontMetrics(outputField.getFont()).getHeight()));

		operation = Operation.NULL;

		ENGINE.put(Operation.PLUS, () -> input1 + input2);
		ENGINE.put(Operation.MINUS, () -> input1 - input2);
		ENGINE.put(Operation.MULTIPLE, () -> input1 * input2);
		ENGINE.put(Operation.ARCSIN, () -> Math.asin(input1));
		ENGINE.put(Operation.ARCCOS, () -> Math.acos(input1));
		ENGINE.put(Operation.ARCTG, () -> Math.atan(input1));
		ENGINE.put(Operation.ARCCTG, () -> 1 / Math.atan(input1));
		ENGINE.put(Operation.SIN, () -> Math.sin(Math.toRadians(input1)));
		ENGINE.put(Operation.COS, () -> Math.cos(Math.toRadians(input1)));
		ENGINE.put(Operation.TG, () -> Math.tan(Math.toRadians(input1)));
		ENGINE.put(Operation.CTG, () -> 1 / Math.tan(Math.toRadians(input1)));
		ENGINE.put(Operation.SQRT, () -> Math.sqrt(input1));
		ENGINE.put(Operation.LOGARITHM, () -> Math.log10(input1) / Math.log10(input2));
		ENGINE.put(Operation.POWER, () -> Math.pow(input1, input2));
		ENGINE.put(Operation.DIVIDE, () -> input1 / input2);
		ENGINE.put(Operation.PERCENT, () -> input2 * input1 / 100);
		ENGINE.put(Operation.SQARE, () -> input1 * input1);
		ENGINE.put(Operation.CUBE, () -> Math.pow(input1, 3));
		ENGINE.put(Operation.LG, () -> Math.log10(input1));
		ENGINE.put(Operation.LN, () -> Math.log(input1));
		ENGINE.put(Operation.CH, () -> (Math.pow(2.7183, input1) + Math.pow(2.7183, -1 * input1)) / 2);
		ENGINE.put(Operation.SH, () -> (Math.pow(2.7183, input1) - Math.pow(2.7183, -1 * input1)) / 2);
		ENGINE.put(Operation.TH, () -> (Math.pow(2.7183, input1) - Math.pow(2.7183, -1 * input1)) / (Math.pow(2.7183, input1) + Math.pow(2.7183, -1 * input1)));
		ENGINE.put(Operation.CTH, () -> (Math.pow(2.7183, input1) + Math.pow(2.7183, -1 * input1)) / (Math.pow(2.7183, input1) - Math.pow(2.7183, -1 * input1)));
		ENGINE.put(Operation.TEN, () -> Math.pow(10, input1));
		ENGINE.put(Operation.BACK, () -> 1 / input1);
		ENGINE.put(Operation.NULL, () -> input2);
		ENGINE.put(Operation.DOUBLEFACT, () -> {
			output = LongStream.iterate(Math.round(input1), k -> k > 0, k -> k - 2).reduce(1L, (a, b) -> a * b);
			return output;
		});
		ENGINE.put(Operation.FACTORIAL, () -> {
			output = LongStream.iterate(Math.round(input1), k -> k > 0, k -> k - 1).reduce(1L, (a, b) -> a * b);
			return output;
		});

		ONE_OPERAND.put(Operation.FACTORIAL, BUTTONS[23]);
		ONE_OPERAND.put(Operation.DOUBLEFACT, BUTTONS[44]);
		ONE_OPERAND.put(Operation.SQRT, BUTTONS[20]);
		ONE_OPERAND.put(Operation.SIN, BUTTONS[24]);
		ONE_OPERAND.put(Operation.COS, BUTTONS[25]);
		ONE_OPERAND.put(Operation.TG, BUTTONS[26]);
		ONE_OPERAND.put(Operation.CTG, BUTTONS[27]);
		ONE_OPERAND.put(Operation.ARCSIN, BUTTONS[28]);
		ONE_OPERAND.put(Operation.ARCCOS, BUTTONS[29]);
		ONE_OPERAND.put(Operation.ARCTG, BUTTONS[30]);
		ONE_OPERAND.put(Operation.ARCCTG, BUTTONS[31]);
		ONE_OPERAND.put(Operation.SQARE, BUTTONS[34]);
		ONE_OPERAND.put(Operation.CUBE, BUTTONS[35]);
		ONE_OPERAND.put(Operation.LG, BUTTONS[36]);
		ONE_OPERAND.put(Operation.LN, BUTTONS[37]);
		ONE_OPERAND.put(Operation.CH, BUTTONS[38]);
		ONE_OPERAND.put(Operation.SH, BUTTONS[39]);
		ONE_OPERAND.put(Operation.TH, BUTTONS[40]);
		ONE_OPERAND.put(Operation.CTH, BUTTONS[41]);
		ONE_OPERAND.put(Operation.TEN, BUTTONS[42]);
		ONE_OPERAND.put(Operation.BACK, BUTTONS[43]);

		TWO_OPERAND.put(Operation.PLUS, BUTTONS[17]);
		TWO_OPERAND.put(Operation.MINUS, BUTTONS[16]);
		TWO_OPERAND.put(Operation.MULTIPLE, BUTTONS[15]);
		TWO_OPERAND.put(Operation.LOGARITHM, BUTTONS[22]);
		TWO_OPERAND.put(Operation.POWER, BUTTONS[21]);
		TWO_OPERAND.put(Operation.DIVIDE, BUTTONS[14]);
		TWO_OPERAND.put(Operation.PERCENT, BUTTONS[18]);

		FUNC.put(BUTTONS[32], () -> () -> {
			if (isExtended) {
				PANEL.setLayout(new GridLayout(7, 4));
				isExtended = false;
				PANEL.remove(BUTTONS[32]);

				for (var exNum : EXTENDED_MODE_IDS) {
					PANEL.remove(BUTTONS[exNum]);
				}

				PANEL.add(BUTTONS[32]);
				BUTTONS[32].setText("Extended");
			} else {
				PANEL.setLayout(new GridLayout(11, 4));
				isExtended = true;
				PANEL.remove(BUTTONS[32]);

				for (var exNum : EXTENDED_MODE_IDS) {
					PANEL.add(BUTTONS[exNum]);
				}

				PANEL.add(BUTTONS[32]);
				BUTTONS[32].setText("Back");
			}
		});
		FUNC.put(BUTTONS[13], () -> () -> {
			output = input1 = input2 = 0;
			outputField.setText("");
		});
		FUNC.put(BUTTONS[19], () -> () -> {
			try {
				input2 = Double.parseDouble(outputField.getText().substring(notInclude));
				calculate();
				var result = new DecimalFormat("#.###############").format(output);
				outputField.setText(outputField.getText() + "=" + result);
			} catch (Exception e) {
				outputField.setText("");
			}
		});
		FUNC.put(BUTTONS[12], () -> () -> outputField.setText("2.718281828459045"));
		FUNC.put(BUTTONS[11], () -> () -> outputField.setText("3.141592653589793"));

		add(outputField, BorderLayout.PAGE_START);
		add(PANEL, BorderLayout.CENTER);
		setSize(400, 500);
		setLocationRelativeTo(null);
	}

	private void calculate() {
		output = ENGINE.get(operation).get();
	}

	private void oneNumber(Operation op, AbstractButton button) {
		var outputText = outputField.getText();
		var equalsIndex = outputText.indexOf('=');
		if (equalsIndex != -1) {
			outputText = outputText.substring(equalsIndex + 1).trim();
			outputField.setText(outputText);
		}
		try {
			input1 = Double.parseDouble(outputField.getText());
			operation = op;
			calculate();
			var result = new DecimalFormat("#.###############").format(output);
			outputField.setText(button.getText() + "(" + outputField.getText() + ")" + "=" + result);
		} catch (Exception e) {
			outputField.setText("");
		}
	}

	public void selectButton(JButton jbutton) {
		var skip = false;
		for (var btn : ONE_OPERAND.entrySet()) {
			if (jbutton == btn.getValue()) {
				oneNumber(btn.getKey(), btn.getValue());
				skip = true;
				break;
			}
		}

		if (!skip) {
			for (var btn : TWO_OPERAND.entrySet()) {
				if (jbutton == btn.getValue()) {
					twoNumbers(btn.getKey(), btn.getValue());
					skip = true;
					break;
				}
			}
		}

		if (!skip) {
			for (var btn : FUNC.entrySet()) {
				if (jbutton == btn.getKey()) {
					btn.getValue().get().run();
					skip = true;
					break;
				}
			}
		}

		if (!skip) {
			for (var i = 0; i < 11; i++) {
				if (jbutton == BUTTONS[i]) {
					var t = outputField.getText();
					t += BUTTONS[i].getText();
					outputField.setText(t);
					break;
				}
			}
		}
	}

	private void twoNumbers(Operation op, AbstractButton button) {
		var outputText = outputField.getText();
		var equalsIndex = outputText.indexOf('=');
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

	private void registerButton(AbstractButton button, String name, boolean hidden) {
		button.setFont(button.getFont().deriveFont(20.0f));
		button.addActionListener(event -> selectButton((JButton) event.getSource()));
		button.setText(name);
		if (!hidden) {
			PANEL.add(button);
		}
	}

	public enum Operation {
		NULL, ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG, SQARE, CUBE, LG, LN, CH, SH, TH, CTH, TEN, BACK, DOUBLEFACT
	}

	public Operation getOperation() {
		return operation;
	}

	public double getOutput() {
		return output;
	}

	public boolean isExtended() {
		return isExtended;
	}
}