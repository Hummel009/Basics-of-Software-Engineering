package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.uni.JavaCalculator;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();

	@Test
	void testSARCCOS() {
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(10));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(29));
		assertEquals(Math.acos(0.5), calculator.getOutput());
	}

	@Test
	void testSARCCTG() {
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(31));
		assertEquals(1 / Math.atan(1), calculator.getOutput());
	}

	@Test
	void testSARCSIN() {
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(10));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(28));
		assertEquals(Math.asin(0.5), calculator.getOutput());
	}

	@Test
	void testSARCTG() {
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(30));
		assertEquals(Math.atan(1), calculator.getOutput());
	}

	@Test
	void testSCOS() {
		calculator.selectButton(calculator.getButton(6));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(25));
		assertEquals(Math.cos(Math.toRadians(60)), calculator.getOutput());
	}

	@Test
	void testSCTG() {
		calculator.selectButton(calculator.getButton(4));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(27));
		assertEquals(1 / Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testSDIVIDE() {
		calculator.selectButton(calculator.getButton(9));
		calculator.selectButton(calculator.getButton(14));
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(3, calculator.getOutput());
	}

	@Test
	void testSNUMBER() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(23));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSFACTORIAL() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(23));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSLOGARITHM() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(22));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(2, calculator.getOutput());
	}

	@Test
	void testSMINUS() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(16));
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(-1, calculator.getOutput());
	}

	@Test
	void testSMULTIPLE() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(15));
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(6, calculator.getOutput());
	}

	@Test
	void testSPERCENT() {
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(18));
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(10, calculator.getOutput());
	}

	@Test
	void testSPLUS() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(17));
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testSPOWER() {
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(21));
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(19));
		assertEquals(25, calculator.getOutput());
	}

	@Test
	void testSSIN() {
		calculator.selectButton(calculator.getButton(3));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(24));
		assertEquals(Math.sin(Math.toRadians(30)), calculator.getOutput());
	}

	@Test
	void testSSQRT() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(20));
		assertEquals(5, calculator.getOutput());
	}

	@Test
	void testSTG() {
		calculator.selectButton(calculator.getButton(4));
		calculator.selectButton(calculator.getButton(5));
		calculator.selectButton(calculator.getButton(26));
		assertEquals(Math.tan(Math.toRadians(45)), calculator.getOutput());
	}

	@Test
	void testSDOUBLEFACT() {
		calculator.selectButton(calculator.getButton(9));
		calculator.selectButton(calculator.getButton(44));
		assertEquals(945, calculator.getOutput());
	}

	@Test
	void testSTEN() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(42));
		assertEquals(100, calculator.getOutput());
	}

	@Test
	void testSLN() {
		calculator.selectButton(calculator.getButton(1));
		calculator.selectButton(calculator.getButton(0));
		calculator.selectButton(calculator.getButton(37));
		assertEquals(Math.log(10), calculator.getOutput());
	}

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
	}

	@Test
	void testCLEAR() {
		calculator.selectButton(calculator.getButton(3));
		calculator.clear();
		assertEquals(0, calculator.getOutput());
	}

	@Test
	void testEQUALS() {
		calculator.selectButton(calculator.getButton(2));
		calculator.selectButton(calculator.getButton(15));
		calculator.selectButton(calculator.getButton(3));
		calculator.equals();
		assertEquals(6, calculator.getOutput());
	}
}