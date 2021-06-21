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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.TodoService;

//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockAnnotationsTest {
	//prefer using @Rule over @RunWith(), gives more flexibility as we can add another Rule.
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgCaptor;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	//BDD Mockito
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDDMock() {
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		//when
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosUnRelatedToSpring_usingBDDMock() {
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		//when
		todoBusinessImpl.deleteTodosUnrelatedToSpring("Dummy");
		
		//then		
		/*or we can verify the methods using then() in BBDMock -> more readable and preferable */
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to Dance");
		
	}
	
	//Argument capture
	@Test
	public void testDeleteTodosUnRelatedToSpring_usingBDDMock_ArgumentCapture() {		
		List<String> todos = Arrays.asList("Learn to Rock n Roll", "Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
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
