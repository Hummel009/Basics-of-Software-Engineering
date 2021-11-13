package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.uni.JavaCalculator;
import main.java.com.uni.JavaCalculator.Operation;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();

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
	void testSNUMBER() {
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
	void testSDOUBLEFACT() {
		calculator.addOutputText("9");
		calculator.selectButton(calculator.getButton(44));
		assertEquals(945, calculator.getOutput());
	}

	@Test
	void testSTEN() {
		calculator.addOutputText("2");
		calculator.selectButton(calculator.getButton(42));
		assertEquals(100, calculator.getOutput());
	}

	@Test
	void testSLN() {
		calculator.addOutputText("10");
		calculator.selectButton(calculator.getButton(37));
		assertEquals(Math.log(10), calculator.getOutput());
	}

	@Test
	void testSLG() {
		calculator.addOutputText("10");
		calculator.selectButton(calculator.getButton(36));
		assertEquals(1, calculator.getOutput());
	}

	@Test
	void testSCUBE() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(35));
		assertEquals(27, calculator.getOutput());
	}

	@Test
	void testSSQUARE() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(34));
		assertEquals(9, calculator.getOutput());
	}

	@Test
	void testSSH() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(39));
		assertEquals((Math.pow(2.7183, 3) - Math.pow(2.7183, (-1) * 3)) / 2, calculator.getOutput());
	}

	@Test
	void testSCH() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(38));
		assertEquals((Math.pow(2.7183, 3) + Math.pow(2.7183, (-1) * 3)) / 2, calculator.getOutput());
	}

	@Test
	void testSBACK() {
		calculator.addOutputText("1");
		calculator.selectButton(calculator.getButton(43));
		assertEquals(1, calculator.getOutput());
	}

	@Test
	void testSTH() {
		calculator.addOutputText("0");
		calculator.selectButton(calculator.getButton(40));
		assertEquals((Math.pow(2.7183, 0) - Math.pow(2.7183, (-1) * 0)) / (Math.pow(2.7183, 0) + Math.pow(2.7183, (-1) * 0)), calculator.getOutput());
	}

	@Test
	void testSCTH() {
		calculator.addOutputText("3");
		calculator.selectButton(calculator.getButton(41));
		assertEquals((Math.pow(2.7183, 3) + Math.pow(2.7183, (-1) * 3)) / (Math.pow(2.7183, 3) - Math.pow(2.7183, (-1) * 3)), calculator.getOutput());
	}
}