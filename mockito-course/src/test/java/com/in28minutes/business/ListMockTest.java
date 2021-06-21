package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListMockTest {

	@Test
	public void letsMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2,listMock.size());
	}
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2,listMock.size());
		assertEquals(3,listMock.size());
	}
	
	@Test
	public void letsMockListSizeGet() {
		List listMock = mock(List.class);
		//when(listMock.get(0)).thenReturn("in28minutes");
		//Argument matcher
		when(listMock.get(anyInt())).thenReturn("in28minutes");
		
		assertEquals("in28minutes",listMock.get(0));
		//assertEquals(null,listMock.get(1));
		assertEquals("in28minutes",listMock.get(0));
	}
	
	@Test(expected = RuntimeException.class)
	public void letsMockList_ThrowAnException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something wrong"));
		
		listMock.get(0);
	}
	
	//BDD Mockito
	@Test
	public void letsMockListSizeGet_UsingMockito() {
		//given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("in28minutes");
		
		//when
		String firstEle = listMock.get(0);
		assertThat(firstEle, is("in28minutes"));
	}

}
