package com.in28minutes.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	//array unit testing
	@Test
	public void testArraySorting_RandomArray() {
		int[] numbers = {12,3,5,1,6};
		int[] expected = {1,3,5,6,12};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	//exception unit testing
	@Test(expected=NullPointerException.class)
	public void testArraySorting_NullArray() {
		int[] numbers = null;
		Arrays.sort(numbers);
		//assertArrayEquals(expected, numbers);
	}
	
	//performance unit testing
	@Test(timeout = 100)
	public void testSort_Performance() {
		int[] array = {12,23,4};
		for(int i=0; i<=1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}
}
