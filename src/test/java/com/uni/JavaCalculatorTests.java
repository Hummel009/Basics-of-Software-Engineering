package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.uni.JavaCalculator;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();

	@Test
	void testSLG() {
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(36));
		assertEquals(1, calculator.getOutput());
	}

	@Test
	void testSCUBE() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(35));
		assertEquals(27, calculator.getOutput());
	}

	@Test
	void testSSQUARE() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(34));
		assertEquals(9, calculator.getOutput());
	}

	@Test
	void testSSH() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(39));
		assertEquals((Math.pow(2.7183, 3) - Math.pow(2.7183, (-1) * 3)) / 2, calculator.getOutput());
	}

	@Test
	void testSCH() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(38));
		assertEquals((Math.pow(2.7183, 3) + Math.pow(2.7183, (-1) * 3)) / 2, calculator.getOutput());
	}

	@Test
	void testSBACK() {
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(43));
		assertEquals(1, calculator.getOutput());
	}

	@Test
	void testSTH() {
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(40));
		assertEquals((Math.pow(2.7183, 0) - Math.pow(2.7183, (-1) * 0)) / (Math.pow(2.7183, 0) + Math.pow(2.7183, (-1) * 0)), calculator.getOutput());
	}

	@Test
	void testSCTH() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(41));
		assertEquals((Math.pow(2.7183, 3) + Math.pow(2.7183, (-1) * 3)) / (Math.pow(2.7183, 3) - Math.pow(2.7183, (-1) * 3)), calculator.getOutput());
	}

	@Test
	void testExtended() {
		calculator.selectButton(calculator.getButton(32));
		assertEquals(true, calculator.getExtended());
		calculator.selectButton(calculator.getButton(32));
		assertEquals(false, calculator.getExtended());
	}

	@Test
	void testCLEAR() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(13));
		assertEquals(0, calculator.getOutput());
	}

	@Test
	void testE() {
		calculator.selectButton(calculator.getButton(12));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(2.718281828459045, calculator.getOutput());
	}

	@Test
	void testP() {
		calculator.selectButton(calculator.getButton(11));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(3.141592653589793, calculator.getOutput());
	}
}
