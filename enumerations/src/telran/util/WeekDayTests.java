package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WeekDayTests {
	private static String expectedSUN = "Good but not for Israel";
	private static String expectedSAT = "Good for all";
	private static String expectedFRI = "Good for Israel";
	private static String expectedOthers = "Regular wwek day";
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void weekDayComment() {
		assertEquals(expectedSUN,getComment(WeekDay.SUN));
		assertEquals(expectedSAT,getComment(WeekDay.SAT));
		assertEquals(expectedFRI,getComment(WeekDay.FRI));
		assertEquals(expectedOthers,getComment(WeekDay.WED));
	}
	@Test 
	void allValuesTest(){
		WeekDay[] days = {WeekDay.SUN,WeekDay.MON,WeekDay.TUE,WeekDay.WED,
				WeekDay.THU,WeekDay.FRI,WeekDay.SAT};
		assertArrayEquals(days, WeekDay.values());
	}
	@Test
	void valueOfTest() {
		assertEquals(WeekDay.FRI,WeekDay.valueOf("FRI"));
		boolean flException = false;
		try {
			WeekDay wd = WeekDay.valueOf("KUKU");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			flException = true;
		}
		assertTrue(flException);
		
	}
	@Test
	void toStringTest() {
		assertEquals("FRI",WeekDay.FRI.toString());
	}
	private String getComment(WeekDay wd) {
		switch(wd) {
		case SUN:{
			return expectedSUN;
		}
		case SAT:{
			return expectedSAT;
		}
		case FRI:{
			return expectedFRI;
		}
		default:{
			return expectedOthers;
		}
		}
	}
}
