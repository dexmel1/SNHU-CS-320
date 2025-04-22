package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	
	private final List<Task> taskList = new ArrayList<Task>();
	private String uniqueId;
	
	// Generate a 10-character unique ID using UUID
	public String newUniqueId(){
	    uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	    return uniqueId;
	}
	

	// Create and add task with just an ID
	public void newTask() {
		Task task = new Task(newUniqueId());
		taskList.add(task);
	}
	
	// Create and add task with ID and name
	public void newTask(String name) {
		Task task = new Task(newUniqueId(), name);
		taskList.add(task);
	}
	
	// Create and add task with ID, name, and description
	public void newTask(String name, String description) {
		Task task = new Task(newUniqueId(), name, description);
		taskList.add(task);
	}
	
	// Get all current tasks
	public List<Task> getTaskList() {
		return taskList;
	}
	
	// Search for a task by ID and return it
	public Task searchTask(String id) throws Exception {
		for (Task task : taskList) {
			if (id.equals(task.getTaskId())) {
				return task;
			}
		}
		throw new Exception("Task does not exist.");
	}
	
	// Remove task by ID
	public void  deleteTask (String id) throws Exception {
		taskList.remove(searchTask(id));
	}
	
	// Update task name by ID
	public void updateName(String id, String name) throws Exception {
		searchTask(id).setName(name);
	}
	
	// Update task description by ID
	public void updateDescription(String id, String description) throws Exception {
		searchTask(id).setDescription(description);
	}
}