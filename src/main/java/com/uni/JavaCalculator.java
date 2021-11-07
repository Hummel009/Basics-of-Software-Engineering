package main.java.com.uni;

public class JavaCalculator {
	private Operation operation; //тип операции - сложение, вычитание и т.д.
	private double output; //выводимые данные
	private double input1; //вводимые данные
	private double input2; //вводимые данные
	
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