package test.java.com.github.hummel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.github.hummel.JavaCalculator;

class JavaCalculatorTests {
	JavaCalculator calculator = new JavaCalculator();
	
	@Test
    void square() {
        assertEquals(25, 5*5);
    }
}