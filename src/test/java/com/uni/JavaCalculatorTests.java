package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.uni.JavaCalculator;
import main.java.com.uni.JavaCalculator.Operation;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();

	@Test
	void testARCCOS() {
		calculator.setInput1(0.5);
		calculator.setOperation(Operation.ARCCOS);
		calculator.calculate();
		assertEquals(Math.acos(0.5), calculator.getOutput());
	}

	@Test
	void testARCCTG() {
		calculator.setInput1(1);
		calculator.setOperation(Operation.ARCCTG);
		calculator.calculate();
		assertEquals(1 / Math.atan(1), calculator.getOutput());
	}

	@Test
	void testARCSIN() {
		calculator.setInput1(0.5);
		calculator.setOperation(Operation.ARCSIN);
		calculator.calculate();
		assertEquals(Math.asin(0.5), calculator.getOutput());
	}

	@Test
	void testARCTG() {
		calculator.setInput1(1);
		calculator.setOperation(Operation.ARCTG);
		calculator.calculate();
		assertEquals(Math.atan(1), calculator.getOutput());
	}

	@Test
	void testCLEAR() {
		calculator.addOutputText("3");
		calculator.clear();
		assertEquals("", calculator.getOutputText());
	}

	@Test
	void testCOS() {
		calculator.setInput1(60);
		calculator.setOperation(Operation.COS);
		calculator.calculate();
		assertEquals(Math.cos(Math.toRadians(60)), calculator.getOutput());
	}

	@Test
	void testCTG() {
		calculator.setInput1(45);
		calculator.setOperation(Operation.CTG);
		calculator.calculate();
		assertEquals(1 / Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testDIVIDE() {
		calculator.setInput1(9);
		calculator.setInput2(3);
		calculator.setOperation(Operation.DIVIDE);
		calculator.calculate();
		assertEquals(3, calculator.getOutput());
	}

	@Test
	void testEQUALS() {
		calculator.setInput1(2);
		calculator.addOutputText("3");
		calculator.setOperation(Operation.MULTIPLE);
		calculator.equals();
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testFACTORIAL2() {
		calculator.setInput1(9);
		calculator.setOperation(Operation.DOUBLEFACT);
		calculator.calculate();
		assertEquals(945, calculator.getOutput());
	}

	@Test
	void testFACTORIAL() {
		calculator.setInput1(3);
		calculator.setOperation(Operation.FACTORIAL);
		calculator.calculate();
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testLOGARITHM() {
		calculator.setInput1(25);
		calculator.setInput2(5);
		calculator.setOperation(Operation.LOGARITHM);
		calculator.calculate();
		assertEquals(2, calculator.getOutput());
	}

	@Test
	void testMINUS() {
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.MINUS);
		calculator.calculate();
		assertEquals(-1, calculator.getOutput());
	}

	@Test
	void testMULTIPLE() {
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.MULTIPLE);
		calculator.calculate();
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testPERCENT() {
		calculator.setInput1(90);
		calculator.setInput2(10);
		calculator.setOperation(Operation.PERCENT);
		calculator.calculate();
		assertEquals(9, calculator.getOutput());
	}

	@Test
	void testPLUS() {
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.PLUS);
		calculator.calculate();
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testPOWER() {
		calculator.setInput1(5);
		calculator.setInput2(2);
		calculator.setOperation(Operation.POWER);
		calculator.calculate();
		assertEquals(25, calculator.getOutput());
	}

	@Test
	void testSARCCOS() {
		calculator.addOutputText("0.5");
		calculator.selectButton(calculator.getButton(29));
		assertEquals(Math.acos(0.5), calculator.getOutput());
	}

	@Test
	void testSARCCTG() {
		calculator.addOutputText("1");
		calculator.selectButton(calculator.getButton(31));
		assertEquals(1 / Math.atan(1), calculator.getOutput());
	}

	@Test
	void testSARCSIN() {
		calculator.addOutputText("0.5");
		calculator.selectButton(calculator.getButton(28));
		assertEquals(Math.asin(0.5), calculator.getOutput());
	}

	@Test
	void testSARCTG() {
		calculator.addOutputText("1");
		calculator.selectButton(calculator.getButton(30));
		assertEquals(Math.atan(1), calculator.getOutput());
	}

	@Test
	void testSCOS() {
		calculator.addOutputText("60");
		calculator.selectButton(calculator.getButton(25));
		assertEquals(Math.cos(Math.toRadians(60)), calculator.getOutput());
	}

	@Test
	void testSCTG() {
		calculator.addOutputText("45");
		calculator.selectButton(calculator.getButton(27));
		assertEquals(1 / Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testSDIVIDE() {
		calculator.addOutputText("9");
		calculator.selectButton(calculator.getButton(14));
		calculator.addOutputText("3");
		calculator.setOperation(Operation.DIVIDE);
		calculator.selectButton(calculator.getButton(19));
		assertEquals(3, calculator.getOutput());
	}

	@Test
	void testSelection() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(23));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSFACTORIAL() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(23));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSIN() {
		calculator.setInput1(30);
		calculator.setOperation(Operation.SIN);
		calculator.calculate();
		assertEquals(Math.sin(Math.toRadians(30)), calculator.getOutput());
	}

	@Test
	void testSLOGARITHM() {
		calculator.addOutputText("25");
		calculator.selectButton(calculator.getButton(22));
		calculator.addOutputText("5");
		calculator.setOperation(Operation.LOGARITHM);
		calculator.selectButton(calculator.getButton(19));
		assertEquals(2, calculator.getOutput());
	}

	@Test
	void testSMINUS() {
		calculator.addOutputText("2");
		calculator.selectButton(calculator.getButton(16));
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(19));
		assertEquals(-1, calculator.getOutput());
	}

	@Test
	void testSMULTIPLE() {
		calculator.addOutputText("2");
		calculator.selectButton(calculator.getButton(15));
		calculator.addOutputText("3");
		calculator.setOperation(Operation.MULTIPLE);
		calculator.selectButton(calculator.getButton(19));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSPERCENT() {
		calculator.addOutputText("90");
		calculator.selectButton(calculator.getButton(18));
		calculator.addOutputText("10");
		calculator.setOperation(Operation.PERCENT);
		calculator.selectButton(calculator.getButton(19));
		assertEquals(9, calculator.getOutput());
	}

	@Test
	void testSPLUS() {
		calculator.addOutputText("2");
		calculator.selectButton(calculator.getButton(17));
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(19));
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testSPOWER() {
		calculator.addOutputText("5");
		calculator.selectButton(calculator.getButton(21));
		calculator.addOutputText("2");
		calculator.setOperation(Operation.POWER);
		calculator.selectButton(calculator.getButton(19));
		assertEquals(25, calculator.getOutput());
	}

	@Test
	void testSQRT() {
		calculator.setInput1(25);
		calculator.setOperation(Operation.SQRT);
		calculator.calculate();
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testSSIN() {
		calculator.addOutputText("30");
		calculator.selectButton(calculator.getButton(24));
		assertEquals(Math.sin(Math.toRadians(30)), calculator.getOutput());
	}

	@Test
	void testSSQRT() {
		calculator.addOutputText("25");
		calculator.selectButton(calculator.getButton(20));
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testSTG() {
		calculator.addOutputText("45");
		calculator.selectButton(calculator.getButton(26));
		assertEquals(Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testTG() {
		calculator.setInput1(45);
		calculator.setOperation(Operation.TG);
		calculator.calculate();
		assertEquals(Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testVoid1() {
		calculator.addOutputText("3");
		calculator.oneNumber(Operation.FACTORIAL, calculator.getButton(23));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testVoid2() {
		calculator.addOutputText("2");
		calculator.twoNumbers(Operation.PLUS, calculator.getButton(17));
		calculator.addOutputText("2");
		calculator.setInput2(Double.parseDouble(calculator.getOutputText().substring(calculator.getNotInclude())));
		calculator.calculate();
		assertEquals(4, calculator.getOutput());
	}
}