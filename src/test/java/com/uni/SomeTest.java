package test.java.com.uni;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.uni.Some;

class JavaCalculatorTests {
	
    @Test
    void square() {
        Some obj = new Some();
        obj.setNumber(5);
        assertEquals(25, obj.square());
    }

    @Test
    void triple() {
        Some obj = new Some();
        obj.setNumber(5);
        assertEquals(15, obj.triple());
    }
}