package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchers {

	@Test
	public void basicHamcrestMatchersTest() {
		List<Integer> intList = Arrays.asList(91, 100, 95, 102);
		
		assertThat(intList, hasSize(4));
		assertThat(intList, hasItems(91,100));
		assertThat(intList, everyItem(greaterThan(90)));
		assertThat(intList, everyItem(lessThan(200)));

		// String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());

		// Array
		Integer[] marks = { 1, 2, 3 };

		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContainingInAnyOrder(2, 3, 1));
	}

}
