package com.in28minutes.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterAnnotation {

	@BeforeClass
	public static void beforeClassAnnotation() {
		System.out.println("@BeforeClass annotation called.");
	}
	
	@Before
	public void beforeSetUp() {
		System.out.println("@Before Test called");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1 executing");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2 executing");
	}
	
	@After
	public void afterSetUp() {
		System.out.println("@After Test called-Resources closed");
	}
	
	@AfterClass
	public static void afterClassAnnotation() {
		System.out.println("@AfterClass annotation called.");
	}
}
