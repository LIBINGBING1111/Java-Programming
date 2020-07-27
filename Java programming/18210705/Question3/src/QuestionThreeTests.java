import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionThreeTests {

	@Test
	void testPartA() {
		try {
			DrawShape.class.getDeclaredMethod("draw", int.class, int.class, DrawShape.type.class, char.class, char.class, boolean.class);
		} catch (NoSuchMethodException ex) {
			fail("draw method signature incorrect");
		}
		
		try {
			DrawShape.draw(-1, -1, DrawShape.type.PLUS, 'x', 'o', false);
			fail("invalid input");
		} catch (Exception ex) {}
	}
	
	@Test
	void testPartB() {
		//example 1
		String answer = DrawShape.draw(4, 4, DrawShape.type.TRIANGLE, 'x', 'o', true);
		String s = "x   \noo  \nxxx \noooo\n";
		
		assertEquals(s, answer);
		
		//example 2
		answer = DrawShape.draw(10, 10, DrawShape.type.TRIANGLE, 'x', 'o', false);
		s = "xxxxxxxxxx\n ooooooooo\n  xxxxxxxx\n   ooooooo\n    xxxxxx\n     ooooo\n      xxxx\n       ooo\n        xx\n         o\n";
		
		assertEquals(s, answer);
	}
	
	@Test
	void testPartC() {
		String answer = DrawShape.draw(5, 5, DrawShape.type.PLUS, 'v', 'y', true);
		String s = "  y  \n  y  \nvv+vv\n  y  \n  y  \n";
		
		assertEquals(s, answer);
		
		answer = DrawShape.draw(7, 7, DrawShape.type.PLUS, 'e', 't', false);
		s = "   e   \n   e   \n   e   \nttt+ttt\n   e   \n   e   \n   e   \n";
		
		assertEquals(s, answer);
	}

}
