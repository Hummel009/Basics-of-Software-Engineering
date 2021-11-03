package test.java.com.github.hummel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.com.github.hummel.JavaCalculator;
import main.java.com.github.hummel.JavaCalculator.Operation;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();
	
	@Test
	@DisplayName("PLUS")
	void testPLUS() {
		calculator.input1 = 2;
		calculator.input2 = 3;
		calculator.operation = Operation.PLUS;
		calculator.calculate();
		assertEquals(5, calculator.output, "2+3=5");
	}
	
	@Test
	@DisplayName("MINUS")
	void testMINUS() {
		calculator.input1 = 2;
		calculator.input2 = 3;
		calculator.operation = Operation.MINUS;
		calculator.calculate();
		assertEquals(-1, calculator.output, "2-3=-1");
	}
	
	@Test
	@DisplayName("MULTIPLE")
	void testMULTIPLE() {
		calculator.input1 = 2;
		calculator.input2 = 3;
		calculator.operation = Operation.MULTIPLE;
		calculator.calculate();
		assertEquals(6, calculator.output, "2*3=6");
	}
	
	@Test
	@DisplayName("DIVIDE")
	void testDIVIDE() {
		calculator.input1 = 9;
		calculator.input2 = 3;
		calculator.operation = Operation.DIVIDE;
		calculator.calculate();
		assertEquals(3, calculator.output, "9:3=3");
	}
	
	@Test
	@DisplayName("PERCENT")
	void testPERCENT() {
		calculator.input1 = 90;
		calculator.input2 = 10;
		calculator.operation = Operation.PERCENT;
		calculator.calculate();
		assertEquals(9, calculator.output, "10% of 90 =9");
	}
	
	@Test
	@DisplayName("SQRT")
	void testSQRT() {
		calculator.input1 = 25;
		calculator.operation = Operation.SQRT;
		calculator.calculate();
		assertEquals(5, calculator.output, "sqrt(25)=5");
	}
	
	@Test
	@DisplayName("POWER")
	void testPOWER() {
		calculator.input1 = 5;
		calculator.input2 = 2;
		calculator.operation = Operation.POWER;
		calculator.calculate();
		assertEquals(25, calculator.output, "5^2=25");
	}
	
	@Test
	@DisplayName("LOGARITHM")
	void testLOGARITHM() {
		calculator.input1 = 25;
		calculator.input2 = 5;
		calculator.operation = Operation.LOGARITHM;
		calculator.calculate();
		assertEquals(2, calculator.output, "log5(25)=2");
	}

	@Test
	@DisplayName("FACTORIAL")
	void testFACTORIAL() {
		calculator.input1 = 3;
		calculator.operation = Operation.FACTORIAL;
		calculator.calculate();
		assertEquals(6, calculator.output, "3!=6");
	}

	@Test
	@DisplayName("SIN")
	void testSIN() {
		calculator.input1 = 30;
		calculator.operation = Operation.SIN;
		calculator.calculate();
		assertEquals(Math.sin(Math.toRadians(30)), calculator.output, "sin(30)=0.5");
	}

	@Test
	@DisplayName("COS")
	void testCOS() {
		calculator.input1 = 60;
		calculator.operation = Operation.COS;
		calculator.calculate();
		assertEquals(Math.cos(Math.toRadians(60)), calculator.output, "cos(60)=0.5");
	}

	@Test
	@DisplayName("TG")
	void testTG() {
		calculator.input1 = 45;
		calculator.operation = Operation.TG;
		calculator.calculate();
		assertEquals(Math.tan(Math.toRadians(45)), calculator.output, "tg(45)=1");
	}

	@Test
	@DisplayName("CTG")
	void testCTG() {
		calculator.input1 = 45;
		calculator.operation = Operation.CTG;
		calculator.calculate();
		assertEquals(1/Math.tan(Math.toRadians(45)), calculator.output, "ctg(45)=1");
	}


	@Test
	@DisplayName("ARCSIN")
	void testARCSIN() {
		calculator.input1 = 0.5;
		calculator.operation = Operation.ARCSIN;
		calculator.calculate();
		assertEquals(Math.asin(0.5), calculator.output, "arcsin(0.5)=30");
	}

	@Test
	@DisplayName("ARCCOS")
	void testARCCOS() {
		calculator.input1 = 0.5;
		calculator.operation = Operation.ARCCOS;
		calculator.calculate();
		assertEquals(Math.acos(0.5), calculator.output, "arccos(0.5)=60");
	}

	@Test
	@DisplayName("ARCTG")
	void testARCTG() {
		calculator.input1 = 1;
		calculator.operation = Operation.ARCTG;
		calculator.calculate();
		assertEquals(Math.atan(1), calculator.output, "arctg(1)=45");
	}

	@Test
	@DisplayName("ARCCTG")
	void testARCCTG() {
		calculator.input1 = 1;
		calculator.operation = Operation.ARCCTG;
		calculator.calculate();
		assertEquals(1/Math.atan(1), calculator.output, "arcctg(1)=45");
	}
}