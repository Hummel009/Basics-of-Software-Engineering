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
}
