package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {
	//What is mocking?
	//mocking is creating objects that simulate the behavior of real objects.
	//Unlike stubs, mocks can be dynamically created from code - at runtime.
	//Mocks offer more functionality than stubbing.
	//You can verify method calls and a lot of other things.
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	//BDD Mockito
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDDMock() {
		//given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//then
		assertThat(filteredTodos.size(), is(2));
	}
	
	//Verify a method being called
	@Test
	public void testDeleteTodosUnRelatedToSpring_usingBDDMock() {
		//given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		todoBusinessImpl.deleteTodosUnrelatedToSpring("Dummy");
		
		//then
		/*Not BBDMock format */
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");
		verify(todoServiceMock, never()).deleteTodo("Learn Spring");
		
		/*or we can verify the methods using then() in BBDMock -> more readable and preferable */
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to Dance");
		
	}
	
	//Argument capture
	@Test
	public void testDeleteTodosUnRelatedToSpring_usingBDDMock_ArgumentCapture() {
		//declare Argument Captor
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
		
		//given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn to Rock n Roll", "Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		todoBusinessImpl.deleteTodosUnrelatedToSpring("Dummy");
		
		//then
		//for capturing single value
		/*then(todoServiceMock).should().deleteTodo(stringCaptor.capture());	
		assertThat(stringCaptor.getValue(), is("Learn to Dance"));*/
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgCaptor.capture());	
		assertThat(stringArgCaptor.getAllValues().size(), is(2));
	}
}
