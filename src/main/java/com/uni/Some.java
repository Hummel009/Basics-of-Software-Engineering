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

public class Some extends JFrame implements ActionListener {
	private JButton[] button = new JButton[32]; 
	private Operation operation; 
	private double output; 
	private double input1; 
	private double input2; 
	private JTextField outputField = new JTextField(20); 
	private JPanel panel = new JPanel();  
	private int notInclude;

	public static void main(String[] arg) {
		new Some();
	}

	public Some() {
		super("Calculator v1.2.0"); 

		
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

		outputField.setFont(outputField.getFont().deriveFont(40f)); 
		outputField.setHorizontalAlignment(SwingConstants.RIGHT); 
		outputField.setEditable(false); 

		add(outputField, BorderLayout.NORTH); 
		add(panel, BorderLayout.CENTER); 
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

	@Override
	public void actionPerformed(ActionEvent event) {
		final JButton jbutton = (JButton) event.getSource(); 

		
		if (jbutton == button[13]) {
			output = input1 = input2 = 0; 
			outputField.setText(""); 
		}

		
		else if (jbutton == button[19]) {
			input2 = Double.parseDouble(outputField.getText().substring(notInclude)); 
			calculate(); 
			String result = new DecimalFormat("#.###############").format(output); 
			outputField.setText(outputField.getText() + "=" + result); 
		}

		
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

		
		else if (jbutton == button[12]) {
			outputField.setText("2.718281828459045"); 
		}

		
		else if (jbutton == button[11]) {
			outputField.setText("3.141592653589793"); 
		}

		
		else {
			for (int i = 0; i < 11; i++) {
				if (jbutton == button[i]) {
					String t = outputField.getText(); 
					t += button[i].getText(); 
					outputField.setText(t); 
				}
			}
		}
	}

	
	public void oneNumber(Operation op, JButton button) {
		input1 = Double.parseDouble(outputField.getText()); 
		operation = op; 
		calculate(); 
		String result = new DecimalFormat("#.###############").format(output); 
		outputField.setText(button.getText() + "(" + outputField.getText() + ")" + "=" + result); 
	}

	
	public void twoNumbers(Operation op, JButton button) {
		notInclude = outputField.getText().length() + button.getText().length();
		input1 = Double.parseDouble(outputField.getText());  
		operation = op; 
		outputField.setText(outputField.getText() + button.getText()); 
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
			output = input2 * input1 / 100;
			break;
		}
		return 0;
	}

	
	public enum Operation {
		ARCCOS, ARCCTG, ARCSIN, ARCTG, COS, CTG, DIVIDE, FACTORIAL, LOGARITHM, MINUS, MULTIPLE, PERCENT, PLUS, POWER, SIN, SQRT, TG;
	}
	
	
	public void setInput1(double i) {
		input1 = i;
	}
	
	
	public void setInput2(double i) {
		input2 = i;
	}
	
	
	public double getOutput() {
		return output;
	}
	
	
	public void setOperation(Operation op) {
		operation = op;
	}
}