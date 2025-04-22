package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.main.TaskService;

class TaskServiceTest {
	
	private String name, description, longName, longDescription;
	
	@BeforeEach
	void initial() {
		name = "Test Name";
		description = "Test Description";
		longName = "Bad Test Name Because It Is Too Long";
		longDescription = "Bad Test Description. Bad Test Description. Bad Test Description. Bad Test Description.";
	}
	
	@Test
	void taskTest() throws Exception {
	    TaskService service = new TaskService();

	    // Create a task and validate it
	    service.newTask();
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
	    Assertions.assertNotEquals("FIXME", service.getTaskList().get(0).getTaskId());

	    // Delete that task and validate size
	    service.deleteTask(service.getTaskList().get(0).getTaskId());
	    assertEquals(0, service.getTaskList().size());

	    // Recreate a task and validate
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());

	    // Delete again
	    service.deleteTask(service.getTaskList().get(0).getTaskId());
	    assertEquals(0, service.getTaskList().size());

	    // Try to delete from empty list — should throw exception
	    assertThrows(Exception.class, () -> service.deleteTask("someFakeId"));

	    // Add one more task and ensure size is 1
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());

	    // Try deleting using a wrong ID (should throw)
	    assertThrows(Exception.class, () -> service.deleteTask("0000000000")); // 'id' defined in @BeforeEach
	    assertEquals(1, service.getTaskList().size());
	}

	
	@Test
	void nameTest() throws Exception {
		TaskService service = new TaskService();
		
		// Create a task with name and validate
		service.newTask(name);
		Assertions.assertNotNull(service.getTaskList().get(0).getName());
		Assertions.assertEquals(name, service.getTaskList().get(0).getName());
		
		// Check invalid name inputs (null or too long)
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(longName));
		
		// Update the name on an existing task
		service.deleteTask(service.getTaskList().get(0).getTaskId());
		service.newTask();
		service.updateName(service.getTaskList().get(0).getTaskId(), name);
		assertEquals(name, service.getTaskList().get(0).getName());
	}
	
	@Test
	void descriptionTest() throws Exception {
		TaskService service = new TaskService();
		
		// Create task with name and description, then validate
		service.newTask(name, description);
		Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
		Assertions.assertEquals(description, service.getTaskList().get(0).getDescription());
		
		// Check invalid descriptions (null or too long)
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(name, null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(name, longDescription));
		
		// Update description of existing task
		service.deleteTask(service.getTaskList().get(0).getTaskId());
		service.newTask();
		service.updateDescription(service.getTaskList().get(0).getTaskId(), description);
		assertEquals(description, service.getTaskList().get(0).getDescription());
	}
	
	@RepeatedTest(4)
	void UuidTest() {
		TaskService service = new TaskService();
		
		// Add multiple tasks and verify unique task IDs
		service.newTask();
		service.newTask();
		service.newTask();
		
		assertEquals(3, service.getTaskList().size());
		assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(1).getTaskId());
		assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(2).getTaskId());
		assertNotEquals(service.getTaskList().get(1).getTaskId(), service.getTaskList().get(2).getTaskId());
	}
		
	
}