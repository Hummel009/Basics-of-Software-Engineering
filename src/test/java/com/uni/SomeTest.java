package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.uni.Some;
import main.java.com.uni.Some.Operation;

class JavaCalculatorTests {
	
	@Test
	void testPLUS() {
		Some calculator = new Some();
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.PLUS);
		calculator.calculate();
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testMINUS() {
		Some calculator = new Some();
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.MINUS);
		calculator.calculate();
		assertEquals(-1, calculator.getOutput());
	}

	@Test
	void testMULTIPLE() {
		Some calculator = new Some();
		calculator.setInput1(2);
		calculator.setInput2(3);
		calculator.setOperation(Operation.MULTIPLE);
		calculator.calculate();
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testDIVIDE() {
		Some calculator = new Some();
		calculator.setInput1(9);
		calculator.setInput2(3);
		calculator.setOperation(Operation.DIVIDE);
		calculator.calculate();
		assertEquals(3, calculator.getOutput());
	}

	@Test
	void testPERCENT() {
		Some calculator = new Some();
		calculator.setInput1(90);
		calculator.setInput2(10);
		calculator.setOperation(Operation.PERCENT);
		calculator.calculate();
		assertEquals(9, calculator.getOutput());
	}

	@Test
	void testSQRT() {
		Some calculator = new Some();
		calculator.setInput1(25);
		calculator.setOperation(Operation.SQRT);
		calculator.calculate();
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testPOWER() {
		Some calculator = new Some();
		calculator.setInput1(5);
		calculator.setInput2(2);
		calculator.setOperation(Operation.POWER);
		calculator.calculate();
		assertEquals(25, calculator.getOutput());
	}

	@Test
	void testLOGARITHM() {
		Some calculator = new Some();
		calculator.setInput1(25);
		calculator.setInput2(5);
		calculator.setOperation(Operation.LOGARITHM);
		calculator.calculate();
		assertEquals(2, calculator.getOutput());
	}

	@Test
	void testFACTORIAL() {
		Some calculator = new Some();
		calculator.setInput1(3);
		calculator.setOperation(Operation.FACTORIAL);
		calculator.calculate();
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSIN() {
		Some calculator = new Some();
		calculator.setInput1(30);
		calculator.setOperation(Operation.SIN);
		calculator.calculate();
		assertEquals(Math.sin(Math.toRadians(30)), calculator.getOutput());
	}

	@Test
	void testCOS() {
		Some calculator = new Some();
		calculator.setInput1(60);
		calculator.setOperation(Operation.COS);
		calculator.calculate();
		assertEquals(Math.cos(Math.toRadians(60)), calculator.getOutput());
	}

	@Test
	void testTG() {
		Some calculator = new Some();
		calculator.setInput1(45);
		calculator.setOperation(Operation.TG);
		calculator.calculate();
		assertEquals(Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testCTG() {
		Some calculator = new Some();
		calculator.setInput1(45);
		calculator.setOperation(Operation.CTG);
		calculator.calculate();
		assertEquals(1/Math.tan(Math.toRadians(45)), calculator.getOutput());
	}


	@Test
	void testARCSIN() {
		Some calculator = new Some();
		calculator.setInput1(0.5);
		calculator.setOperation(Operation.ARCSIN);
		calculator.calculate();
		assertEquals(Math.asin(0.5), calculator.getOutput());
	}

	@Test
	void testARCCOS() {
		Some calculator = new Some();
		calculator.setInput1(0.5);
		calculator.setOperation(Operation.ARCCOS);
		calculator.calculate();
		assertEquals(Math.acos(0.5), calculator.getOutput());
	}

	@Test
	void testARCTG() {
		Some calculator = new Some();
		calculator.setInput1(1);
		calculator.setOperation(Operation.ARCTG);
		calculator.calculate();
		assertEquals(Math.atan(1), calculator.getOutput());
	}

	@Test
	void testARCCTG() {
		Some calculator = new Some();
		calculator.setInput1(1);
		calculator.setOperation(Operation.ARCCTG);
		calculator.calculate();
		assertEquals(1/Math.atan(1), calculator.getOutput());
	}
}