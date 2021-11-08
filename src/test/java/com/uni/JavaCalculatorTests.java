package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.com.uni.JavaCalculator;
import main.java.com.uni.JavaCalculator.Operation;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();

	@Test
	@DisplayName("CLEAR")
	void testCLEAR() {
		calculator.setOutputText("3");
		calculator.clear();
		assertEquals("", calculator.getOutputText());
	}

	@Test
	@DisplayName("EQUALS")
	void testEQUALS() {
		calculator.setInput1(2);
		calculator.setOutputText("3");
		calculator.setOperation(Operation.MULTIPLE);
		calculator.equals();
		assertEquals(6, calculator.getOutput(), "2*3=6");
	}

	@Test
	@DisplayName("VOID2")
	void testVoid2() {
		calculator.setOutputText("2");
		calculator.twoNumbers(Operation.PLUS, calculator.getButton(17));
		String t = calculator.getOutputText();
		t += calculator.getButton(2).getText();
		calculator.setOutputText(t);
		calculator.setInput2(Double.parseDouble(calculator.getOutputText().substring(calculator.getNotInclude())));
		calculator.calculate();
		assertEquals(4, calculator.getOutput(), "2+2=4");
	}
	
	@Test
	@DisplayName("VOID1")
	void testVoid1() {
		calculator.setOutputText("3");
		calculator.oneNumber(Operation.FACTORIAL, calculator.getButton(23));
		assertEquals(6, calculator.getOutput(), "3!=6");
	}
	
	@Test
	@DisplayName("PLUS")
	void testPLUS() {
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.PLUS);
		calculator.calculate();
		assertEquals(5, calculator.getOutput(), "2+3=5");
	}

	@Test
	@DisplayName("MINUS")
	void testMINUS() {
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.MINUS);
		calculator.calculate();
		assertEquals(-1, calculator.getOutput(), "2-3=-1");
	}

	@Test
	@DisplayName("MULTIPLE")
	void testMULTIPLE() {
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.MULTIPLE);
		calculator.calculate();
		assertEquals(6, calculator.getOutput(), "2*3=6");
	}

	@Test
	@DisplayName("DIVIDE")
	void testDIVIDE() {
		calculator.setInput1(9);
		calculator.setInput2(3);
		calculator.setOperation(Operation.DIVIDE);
		calculator.calculate();
		assertEquals(3, calculator.getOutput(), "9:3=3");
	}

	@Test
	@DisplayName("PERCENT")
	void testPERCENT() {
		calculator.setInput1(90);
		calculator.setInput2(10);
		calculator.setOperation(Operation.PERCENT);
		calculator.calculate();
		assertEquals(9, calculator.getOutput(), "10% of 90 =9");
	}

	@Test
	@DisplayName("SQRT")
	void testSQRT() {
		calculator.setInput1(25);
		calculator.setOperation(Operation.SQRT);
		calculator.calculate();
		assertEquals(5, calculator.getOutput(), "sqrt(25)=5");
	}

	@Test
	@DisplayName("POWER")
	void testPOWER() {
		calculator.setInput1(5);
		calculator.setInput2(2);
		calculator.setOperation(Operation.POWER);
		calculator.calculate();
		assertEquals(25, calculator.getOutput(), "5^2=25");
	}

	@Test
	@DisplayName("LOGARITHM")
	void testLOGARITHM() {
		calculator.setInput1(25);
		calculator.setInput2(5);
		calculator.setOperation(Operation.LOGARITHM);
		calculator.calculate();
		assertEquals(2, calculator.getOutput(), "log5(25)=2");
	}

	@Test
	@DisplayName("FACTORIAL")
	void testFACTORIAL() {
		calculator.setInput1(3);
		calculator.setOperation(Operation.FACTORIAL);
		calculator.calculate();
		assertEquals(6, calculator.getOutput(), "3!=6");
	}

	@Test
	@DisplayName("SIN")
	void testSIN() {
		calculator.setInput1(30);
		calculator.setOperation(Operation.SIN);
		calculator.calculate();
		assertEquals(Math.sin(Math.toRadians(30)), calculator.getOutput(), "sin(30)=0.5");
	}

	@Test
	@DisplayName("COS")
	void testCOS() {
		calculator.setInput1(60);
		calculator.setOperation(Operation.COS);
		calculator.calculate();
		assertEquals(Math.cos(Math.toRadians(60)), calculator.getOutput(), "cos(60)=0.5");
	}

	@Test
	@DisplayName("TG")
	void testTG() {
		calculator.setInput1(45);
		calculator.setOperation(Operation.TG);
		calculator.calculate();
		assertEquals(Math.tan(Math.toRadians(45)), calculator.getOutput(), "tg(45)=1");
	}

	@Test
	@DisplayName("CTG")
	void testCTG() {
		calculator.setInput1(45);
		calculator.setOperation(Operation.CTG);
		calculator.calculate();
		assertEquals(1/Math.tan(Math.toRadians(45)), calculator.getOutput(), "ctg(45)=1");
	}


	@Test
	@DisplayName("ARCSIN")
	void testARCSIN() {
		calculator.setInput1(0.5);
		calculator.setOperation(Operation.ARCSIN);
		calculator.calculate();
		assertEquals(Math.asin(0.5), calculator.getOutput(), "arcsin(0.5)=30");
	}

	@Test
	@DisplayName("ARCCOS")
	void testARCCOS() {
		calculator.setInput1(0.5);
		calculator.setOperation(Operation.ARCCOS);
		calculator.calculate();
		assertEquals(Math.acos(0.5), calculator.getOutput(), "arccos(0.5)=60");
	}

	@Test
	@DisplayName("ARCTG")
	void testARCTG() {
		calculator.setInput1(1);
		calculator.setOperation(Operation.ARCTG);
		calculator.calculate();
		assertEquals(Math.atan(1), calculator.getOutput(), "arctg(1)=45");
	}

	@Test
	@DisplayName("ARCCTG")
	void testARCCTG() {
		calculator.setInput1(1);
		calculator.setOperation(Operation.ARCCTG);
		calculator.calculate();
		assertEquals(1/Math.atan(1), calculator.getOutput(), "arcctg(1)=45");
	}
}
