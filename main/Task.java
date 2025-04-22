package com.main;

public class Task {
	private String taskId;
	private String name;
	private String description;
	
	// Default constructor with placeholder values
	public Task() {
		taskId = "FIXME";
		name = "FIXME";
		description = "FIXME";
	}
	
	// Constructor with taskId only
	public Task(String taskId) {
		checkTaskId(taskId);
		name = "FIXME";
		description = "FIXME";
	}
	
	// Constructor with taskId and name
	public Task(String taskId, String name) {
		checkTaskId(taskId);
		setName(name);
		description = "FIXME";
	}
	
	// Full constructor
	public Task (String taskId, String name, String description)	{
		checkTaskId(taskId);
		setName(name);
		setDescription(description);
	}
	
	// Getters
	public final String getTaskId() {
		return taskId;
	}
	
	public final String getName() {
		return name;
	}
	
	public final String getDescription() {
		return description;
	}
	
	// Validates and sets taskId (only used in constructor)
	public void checkTaskId(String taskId) {
		if(taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid entry. Task ID must not be more then 10 characters.");
		}
		else {
			this.taskId = taskId;
		}
	}
	
	// Setter with validation for name
	public void setName(String name) {
		if(name == null || name.length() >20) {
			throw new IllegalArgumentException("Invalid Entry. Name must not be more then 20 characters.");
		}
		else {
			this.name = name;
		}
	}
	
	// Setter with validation for description
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Entry. Task Description must not be more the 50 characters");
		}
		else {
			this.description = description;
		}
	}
}