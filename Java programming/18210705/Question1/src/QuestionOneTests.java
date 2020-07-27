import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionOneTests {

	@Test
	void testPartA() {
		Method [] methods = Calculatable.class.getDeclaredMethods();
		assertEquals(methods.length, 2);
		
		Method m;
		
		try {
			m = Calculatable.class.getDeclaredMethod("getValue", null);
		} catch (NoSuchMethodException ex) {
			fail("No getValue method");
		}
		
		try {
			m = Calculatable.class.getDeclaredMethod("negate", null);
		} catch (NoSuchMethodException ex) {
			fail("No negate method");
		}
		

	}
	
	@Test
	void testPartB() {
		Method [] methods = Calculator.class.getDeclaredMethods();
		assertEquals(methods.length, 1);
		
		try {
			Method m = Calculator.class.getDeclaredMethod("calculate", Calculatable[].class);
		} catch (NoSuchMethodException ex) {
			fail("No calculate method");
		}
	}
	
	@Test
	void testPartC() {
		SimpleCalculatable s = new SimpleCalculatable(1);
		assertTrue(s instanceof Calculatable);
		
		assertEquals(1, s.getValue());
		
		s.negate();
		assertEquals(-1, s.getValue());
	}
	
	@Test
	void testPartD() {
		//example 1
		Calculatable c1 = new StringCalculatable("-one two three four five");
		assertEquals(-12345, c1.getValue());
		
		//example 2
		Calculatable c2 = new StringCalculatable("123");
		c2.negate();
		assertEquals(-123, c2.getValue());
	}
	
	@Test
	void testPartE() {
		Question1 q = new Question1();
		q.initialise();
		
		SimpleCalculatable sc = new SimpleCalculatable(2);
		Calculatable answer = q.getAdder().calculate(new Calculatable[]{sc, sc, sc, sc, sc});
		
		assertEquals(10, answer.getValue());
		
		answer = q.getMultiplier().calculate(new Calculatable[]{sc, sc, sc, sc, sc});
		assertEquals(32, answer.getValue());
	}

}
