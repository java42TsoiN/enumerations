package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		assertTrue(new Length(1,LengthUnit.M).equals(new Length(100,LengthUnit.CM))); 
		assertFalse(new Length(1,LengthUnit.M).equals(new Length(101,LengthUnit.CM))); 
		assertFalse(new Length(1,LengthUnit.M).equals(new Length(100,LengthUnit.MM))); 
	}

	@Test
	void testCompareTo() {
		assertTrue(new Length(1,LengthUnit.M).compareTo(new Length(100,LengthUnit.CM))==0);
	}

	@Test
	void testConvert() {
		assertEquals("1000,0MM",new Length(1,LengthUnit.M).convert(LengthUnit.MM).toString()); 
	}
	@Test
	void testToString() {
		assertEquals("1,0M",new Length(1,LengthUnit.M).toString());
	}
	@Test
	void testBetween() {
		assertEquals("0,8M", (LengthUnit.M.between(new Length(20f,LengthUnit.CM), new Length(1f,LengthUnit.M))).toString());
	}


}
