package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	String input;
	String expected;
	
	StringHelper helper = new StringHelper();
	
	public StringHelperParameterizedTest(String input, String expected) {
		this.input = input;
		this.expected = expected;	
	}

	@Parameters
	public static Collection<String[]> possibleInputs() {
		String[][] inputs = {{"AACD","CD"},{"ACD","CD"}};
		return Arrays.asList(inputs);
	}
	
	//AACD => CD ACD => CD CDEF=>CDEF CDAA=>CDAA
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		assertEquals(expected, helper.truncateAInFirst2Positions(input));
	}
}
