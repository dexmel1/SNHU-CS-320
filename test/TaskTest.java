package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.Task;

class TaskTest {
	
	private String id, name, description, longId, longName, longDescription;
	
	@BeforeEach
	void initial() {
		id = "0000000000";
		name = "Test Name";
		description = "Test Description";
		longId = "0000000000123";
		longName = "Bad Test Name Because It Is Too Long";
		longDescription = "Bad Test Description. Bad Test Description. Bad Test Description. Bad Test Description.";
	}
	
	@Test
	void getTaskIdTest() {
		Task task = new Task(id);
		
		Assertions.assertEquals(id, task.getTaskId());
	}
	
	@Test
	void getNameTest() {
		Task task = new Task(id, name);
		Assertions.assertEquals(name, task.getName());
	}
	
	@Test
	void getDescriptionTest() {
		Task task = new Task(id, name, description);
		Assertions.assertEquals(description, task.getDescription());
	}
	
	@Test 
	void nameTest() {
		Task task = new Task();
		task.setName(name);
		Assertions.assertEquals(name, task.getName());
		
		// Invalid name tests
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(longName));
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(null));
	}
	

	
	@Test
	void DescriptionTest() {
		Task task = new Task();
		task.setDescription(description);
		Assertions.assertEquals(description, task.getDescription());
		
		// Invalid description tests
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription(longDescription));
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
		
	}
	
	@Test
	void taskIdTest() {
		
		// Invalid taskId tests: too long and null
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(longId));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
	}
	
	
	
}