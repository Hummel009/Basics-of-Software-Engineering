package hummel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTests {
	private Calculator calculator;

	@Test
	public void testSARCCOS() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[10]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[29]);
		assertEquals(Math.acos(0.5), calculator.getOutput());
	}

	@Test
	public void testSARCCTG() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[31]);
		assertEquals(1 / (Math.PI / 4.0), calculator.getOutput());
	}

	@Test
	public void testSARCSIN() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[10]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[28]);
		assertEquals(Math.asin(0.5), calculator.getOutput());
	}

	@Test
	public void testSARCTG() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[30]);
		assertEquals((Math.PI / 4.0), calculator.getOutput());
	}

	@Test
	public void testSCOS() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[6]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[25]);
		assertEquals(Math.cos(1.0471975511965976), calculator.getOutput());
	}

	@Test
	public void testSCTG() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[4]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[27]);
		assertEquals(1 / Math.tan(0.7853981633974483), calculator.getOutput());
	}

	@Test
	public void testSDIVIDE() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[9]);
		calculator.selectButton(Calculator.BUTTONS[14]);
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(3, calculator.getOutput());
	}

	@Test
	public void testSNUMBER() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[23]);
		assertEquals(6, calculator.getOutput());
	}

	@Test
	public void testSFACTORIAL() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[23]);
		assertEquals(6, calculator.getOutput());
	}

	@Test
	public void testSLOGARITHM() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[22]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(2, calculator.getOutput());
	}

	@Test
	public void testSMINUS() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[16]);
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(-1, calculator.getOutput());
	}

	@Test
	public void testSMULTIPLE() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[15]);
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(6, calculator.getOutput());
	}

	@Test
	public void testSPERCENT() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[18]);
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(10, calculator.getOutput());
	}

	@Test
	public void testSPLUS() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[17]);
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(5, calculator.getOutput());
	}

	@Test
	public void testSPOWER() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[21]);
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(25, calculator.getOutput());
	}

	@Test
	public void testSSIN() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[24]);
		assertEquals(Math.sin(0.5235987755982988), calculator.getOutput());
	}

	@Test
	public void testSSQRT() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[20]);
		assertEquals(5, calculator.getOutput());
	}

	@Test
	public void testSTG() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[4]);
		calculator.selectButton(Calculator.BUTTONS[5]);
		calculator.selectButton(Calculator.BUTTONS[26]);
		assertEquals(Math.tan(0.7853981633974483), calculator.getOutput());
	}

	@Test
	public void testSDOUBLEFACT() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[9]);
		calculator.selectButton(Calculator.BUTTONS[44]);
		assertEquals(945, calculator.getOutput());
	}

	@Test
	public void testSTEN() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[2]);
		calculator.selectButton(Calculator.BUTTONS[42]);
		assertEquals(100, calculator.getOutput());
	}

	@Test
	public void testSLN() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[37]);
		assertEquals(Math.log(10), calculator.getOutput());
	}

	@Test
	public void testSLG() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[36]);
		assertEquals(1, calculator.getOutput());
	}

	@Test
	public void testSCUBE() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[35]);
		assertEquals(27, calculator.getOutput());
	}

	@Test
	public void testSSQUARE() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[34]);
		assertEquals(9, calculator.getOutput());
	}

	@Test
	public void testSSH() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[39]);
		assertEquals((Math.pow(2.7183, 3) - Math.pow(2.7183, (-1) * 3)) / 2, calculator.getOutput());
	}

	@Test
	public void testSCH() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[38]);
		assertEquals((Math.pow(2.7183, 3) + Math.pow(2.7183, (-1) * 3)) / 2, calculator.getOutput());
	}

	@Test
	public void testSBACK() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[1]);
		calculator.selectButton(Calculator.BUTTONS[43]);
		assertEquals(1, calculator.getOutput());
	}

	@Test
	public void testSTH() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[0]);
		calculator.selectButton(Calculator.BUTTONS[40]);
		assertEquals((0.0) / (Math.pow(2.7183, 0) + Math.pow(2.7183, 0)), calculator.getOutput());
	}

	@Test
	public void testSCTH() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[41]);
		assertEquals((Math.pow(2.7183, 3) + Math.pow(2.7183, (-1) * 3)) / (Math.pow(2.7183, 3) - Math.pow(2.7183, (-1) * 3)), calculator.getOutput());
	}

	@Test
	public void testExtended() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[32]);
		assertEquals(true, calculator.isExtended());
		calculator.selectButton(Calculator.BUTTONS[32]);
		assertEquals(false, calculator.isExtended());
	}

	@Test
	public void testCLEAR() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[3]);
		calculator.selectButton(Calculator.BUTTONS[13]);
		assertEquals(0, calculator.getOutput());
	}

	@Test
	public void testE() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[12]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(2.718281828459045, calculator.getOutput());
	}

	@Test
	public void testP() {
		calculator = new Calculator();
		calculator.selectButton(Calculator.BUTTONS[11]);
		calculator.selectButton(Calculator.BUTTONS[19]);
		assertEquals(3.141592653589793, calculator.getOutput());
	}

	@Test
	public void testMain() {
		Calculator.main(new String[]{""});
	}
}