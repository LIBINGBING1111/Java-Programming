import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionFiveTests {

	@Test
	void testPartA() {
		Abalone a1 = new Abalone(Abalone.MALE, .35, .53, .64, 10);
		Abalone a2 = new Abalone(Abalone.FEMALE, .45, .43, .51, 5);
		Abalone a3 = new Abalone(Abalone.INFANT, .15, .16, .05, 1);
		
		assertEquals(a1, a1);
		assertFalse(a1.equals(a2));
		
		String s = "Abalone (M), length=0.35, diameter=0.53, weight=0.64, age=10"; 
		assertEquals(s, a1.toString());
		
		s = "Abalone (F), length=0.45, diameter=0.43, weight=0.51, age=5";
		assertEquals(s, a2.toString());
		
		s = "Abalone (I), length=0.15, diameter=0.16, weight=0.05, age=1"; 
		assertEquals(s, a3.toString());
	}
	
	@Test
	void testPartB() {
		//complete this line to correspond to where you saved the file downloaded from moodle
		File f = new File("... testData.csv");
		
		try {
			ArrayList<Abalone> al = Abalone.read(f);
			assertEquals(12, al.size());
			
			Abalone a = new Abalone(Abalone.MALE,0.455,0.365,0.514,15);
			assertEquals(a, al.get(0));
		} catch (Exception ex) {
			fail("Something went wrong");
		}
	}
	
	@Test
	void testPartC() {
		//complete this line to correspond to where you saved the file downloaded from moodle
		File f = new File("... invalidData.csv");
				
		try {
			ArrayList<Abalone> al = Abalone.read(new File("notrealfile.txt"));
			fail("read method accepted a file that doesn't exist?");
		} catch (Exception ex) {}
		
		try {
			ArrayList<Abalone> al = Abalone.read(f);
			fail("read method accepted a file with errors in it");
		} catch (Exception ex) {}
	}

}
